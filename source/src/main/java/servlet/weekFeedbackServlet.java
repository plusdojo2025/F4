package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.doTimesDAO;
import dao.goalsDAO;
import dto.goalsDTO;
import dto.usersDTO;
import model.calc;

@WebServlet("/weekFeedback")
public class weekFeedbackServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        usersDTO user = (usersDTO) session.getAttribute("userinfo");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = user.getId();

        try {
            // 実施時間の取得
            doTimesDAO dtdao = new doTimesDAO();
            List<Double> timesList = dtdao.getTimes(userId);//最新の一件の実施時間のリスト

            if (timesList == null || timesList.size() < 3) {
                request.setAttribute("error", "時間データの取得に失敗しました。");
                request.getRequestDispatcher("/WEB-INF/jsp/resultWeek.jsp").forward(request, response);
                return;
            }

            
            double extime = timesList.get(0);   // 運動
            double sttime = timesList.get(1);   // 勉強
            double sltime = timesList.get(2);   // 睡眠
            
            double lastdaydo = extime + sttime + sltime;
            
            // 目標時間の取得
            goalsDAO goalsdao = new goalsDAO();
            goalsDTO goalsdto = goalsdao.selectGoal(userId);

            if (goalsdto == null) {
                request.setAttribute("error", "目標データが登録されていません。");
                request.getRequestDispatcher("/WEB-INF/jsp/resultWeek.jsp").forward(request, response);
                return;
            }

            double goalExercise = goalsdto.getExercise_goal();
            double goalStudy = goalsdto.getStudy_goal();
            double goalSleep = goalsdto.getSleep_goal();

            // 過去のレベル履歴を取得
            //resultsDAO resultsdao = new resultsDAO();
            //List<Double> levelList = resultsdao.getAllLevel(userId);

            // レベルとフィードバック計算
            calc cc = new calc();
            doTimesDAO ddao = new doTimesDAO();
	        double doTimes = lastdaydo + ddao.getDoTimes2(userId);//6日目までの値を取る
	        System.out.println(doTimes);
	        double goals = (goalExercise + goalStudy + goalSleep) * 7;
	        double level = Math.round((doTimes / goals) * 100) * 10) / 10;
            System.out.println("weeklevelは" + level);
            String yourLastFeed = cc.buildWeekFeedback(level);

            // セッションに格納してJSPへ
            
            session.setAttribute("level", level);
            session.setAttribute("feedback", yourLastFeed);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "予期せぬエラーが発生しました。");
        }

        request.getRequestDispatcher("/WEB-INF/jsp/resultWeek.jsp").forward(request, response);
	}
}
