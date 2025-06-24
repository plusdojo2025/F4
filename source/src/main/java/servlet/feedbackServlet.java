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
import dto.goalsDTO;
import dto.usersDTO;
import model.calc;

@WebServlet("/feedback")
public class feedbackServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);

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
            double extime = timesList.get(0);
            double sttime = timesList.get(1);
            double sltime = timesList.get(2);

            goalsDAO goalsdao = new goalsDAO();
            resultsDAO resultsdao = new resultsDAO();
            goalsDTO goalsdto = goalsdao.selectGoal(userId);

            double goalExercise = goalsdto.getExercise_goal();
            double goalStudy = goalsdto.getStudy_goal();
            double goalSleep = goalsdto.getSleep_goal();

            List<Double> dayLevelList = cc.dayLevelCheck(
                extime, sttime, sltime,
                goalExercise, goalStudy, goalSleep
            );
            String sleepfeed = cc.sleepCheck(sltime);
            String yourFeed = cc.buildDayFeedback(dayLevelList, sleepfeed);

            // 最新の進捗率と異なる、または初記録の場合にのみ保存
            Double latestLevel = resultsdao.getNewLevel(userId);
            if (latestLevel == null || Math.abs(latestLevel - dayLevelList.get(0)) > 0.001) {
                resultsdao.setResults(userId, dayLevelList.get(0), yourFeed);
            }

            String yourNewFeed = resultsdao.getNewFeedback(userId);

            session.setAttribute("extime", extime);
            session.setAttribute("sttime", sttime);
            session.setAttribute("sltime", sltime);
            session.setAttribute("level", dayLevelList.get(0));
            session.setAttribute("feedback", yourNewFeed);

            request.getRequestDispatcher("/WEB-INF/jsp/resultDay.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "予期せぬエラーが発生しました。");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
    }
}
