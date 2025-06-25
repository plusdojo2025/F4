package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.doTimesDAO;
import dao.goalsDAO;
import dao.resultsDAO;
import dto.doTimesDTO;
import dto.goalsDTO;
import dto.usersDTO;
import model.calc;

@WebServlet("/feedback")
public class feedbackServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        if (session == null || session.getAttribute("userinfo") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        usersDTO user = (usersDTO) session.getAttribute("userinfo");
        int userId = user.getId();

        try {
            doTimesDAO dtdao = new doTimesDAO();
            calc cc = new calc();

            LocalDate nowdate = LocalDate.now();
            LocalDate firstdate = dtdao.getFirstDate(userId);

            if (firstdate == null) {
                // 初回アクセス
                request.getRequestDispatcher("/WEB-INF/jsp/resultDefault.jsp").forward(request, response);
                return;
            }

            LocalDate lastdate = dtdao.getLastTimes(userId);
            long interval = cc.judgeDate(firstdate, nowdate);
            long lastInsert = cc.judgeDate(lastdate, nowdate);

            // 週末フィードバックへ
            if (interval >= 6 && lastInsert == 0) {
                response.sendRedirect(request.getContextPath() + "/weekFeedback");
                System.out.print("七日目の評価画面に移ります");
                return;
            }

            // 7日経過でリセットされた場合（delete成功）
            boolean deleted = deleteTables.delete(userId);
            if (deleted) {
                request.setAttribute("message", "7日が経過しました。");
                request.setAttribute("message2", "新しい目標を決めましょう!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registGoal.jsp");
                dispatcher.forward(request, response);
                return;
            }

            // ↓ここからDB書き込みなどの処理
            List<Double> timesList = dtdao.getTimes(userId);
            double extime = timesList.get(0);//DBから最新の実施時間を受け取る
            double sttime = timesList.get(1);
            double sltime = timesList.get(2);
            System.out.println(timesList);;
            

            goalsDAO goalsdao = new goalsDAO();
            resultsDAO resultsdao = new resultsDAO();
            goalsDTO goalsdto = goalsdao.selectGoal(userId);

            double goalExercise = goalsdto.getExercise_goal();
            double goalStudy = goalsdto.getStudy_goal();
            double goalSleep = goalsdto.getSleep_goal();

            //sessionから値を取得
            doTimesDTO sessionDoTime = (doTimesDTO) session.getAttribute("lastDoTime");
            
            List<Double> dayLevelList = cc.dayLevelCheck(//値を受け取り各進捗計算をする
                extime, sttime, sltime,
                goalExercise, goalStudy, goalSleep
            );
            System.out.println(dayLevelList);
            String sleepfeed = cc.sleepCheck(sltime);
            //文章つくるメソッドあったとこString yourFeed = cc.buildDayFeedback(dayLevelList, sleepfeed);//ここで文章作成
            

            // DBに現在ある最新の進捗率
            Double latestLevel = resultsdao.getNewLevel(userId);
            System.out.println(latestLevel);
            if (sessionDoTime != null) {
            	
            	System.out.println("計算に使われるextime:" + extime + " 前画面でセッション格納されたedo2: " + sessionDoTime.getExercise_do());
                System.out.println("計算に使われるsttime:" + sttime + " 前画面でセッション格納されたstdo2: " + sessionDoTime.getStudy_do());
                System.out.println("計算に使われるsltime:" + sltime + " 前画面でセッション格納されたsldo2: " + sessionDoTime.getSleep_do());
                

                boolean docheck = false;
                if (sessionDoTime != null) {
                    docheck = Math.abs(extime - sessionDoTime.getExercise_do()) < 0.001 &&
                              Math.abs(sttime - sessionDoTime.getStudy_do()) < 0.001 &&
                              Math.abs(sltime - sessionDoTime.getSleep_do()) < 0.001;
                }
                
                //resultsテーブルにレコードがない　｜｜　doTimesから計算した進捗率とresultsの進捗率を比較|| DBから得た時間とセッションにある時間を比較 
                if (latestLevel == null || (dayLevelList.get(0).equals(latestLevel) && docheck == false) || !dayLevelList.get(0).equals(latestLevel)) {
                		String yourFeed = cc.buildDayFeedback(dayLevelList, sleepfeed);//ここで文章作成
                	
                		resultsdao.setResults(userId, dayLevelList.get(0), yourFeed);
                        System.out.println("新リザルトをインサート完了");
                        System.out.println("DBにあるインサート前の最新の進捗率" + latestLevel);
                        System.out.println("今回インサートされた計算後の進捗率" + dayLevelList.get(0));
                	
                }
                else 
                {
                	System.out.println("最初のifから外れました");
                	boolean elsecheck = (dayLevelList.get(0).equals(latestLevel) && !docheck);
                	System.out.println("DBにあるインサート前の最新の進捗率：" + latestLevel);
                	System.out.println("今回計算された進捗率：" + dayLevelList.get(0));
                	System.out.println("エルスチェック：" + elsecheck);
                	System.out.println("docheckは" + docheck);
                }
            }
            
            	String yourNewFeed = resultsdao.getNewFeedback(userId);
                System.out.println("画面に渡すフィード：" + yourNewFeed);

                session.setAttribute("extime", extime);
                session.setAttribute("sttime", sttime);
                session.setAttribute("sltime", sltime);
                session.setAttribute("level", dayLevelList.get(0));
                session.setAttribute("feedback", yourNewFeed);

           //session破棄
            session.removeAttribute("lastDoTime");

            request.getRequestDispatcher("/WEB-INF/jsp/resultDay.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "予期せぬエラーが発生しました。");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
