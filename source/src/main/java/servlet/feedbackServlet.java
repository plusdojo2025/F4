package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.goalsDAO;
import dao.resultsDAO;
import dto.goalsDTO;
import dto.usersDTO;
import model.calc;

@WebServlet("/feedback")
public class feedbackServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false); // falseで既存セッションのみ取得

        if (session != null) {
            usersDTO user = (usersDTO) session.getAttribute("userinfo");
            if (user != null) {
                int userId = user.getId();

                try {
                    double doExercise = Double.parseDouble(request.getParameter("doex"));
                    double doStudy = Double.parseDouble(request.getParameter("dost"));
                    double doSleep = Double.parseDouble(request.getParameter("dosl"));

                    goalsDAO goalsdao = new goalsDAO();
                    resultsDAO resultsdao = new resultsDAO();

                    goalsDTO goalsdto = goalsdao.selectGoal(userId);//sessionで取得したIDでユーザに応じたゴールDTOを作る
                    double goalExercise = goalsdto.getExercise_goal();
                    double goalStudy = goalsdto.getStudy_goal();
                    double goalSleep = goalsdto.getSleep_goal();

                    calc cc = new calc();
                    List<Double> dayLevelList = cc.dayLevelCheck(
                        doExercise, doStudy, doSleep,
                        goalExercise, goalStudy, goalSleep
                    );
                    String sleepfeed = cc.sleepCheck(doSleep);
                    String yourFeed = cc.buildDayFeedback(dayLevelList, sleepfeed);

                    request.setAttribute("level", dayLevelList.get(0));//進捗率取得して　リクエストスコープにセット
                    request.setAttribute("feedback", yourFeed);

                    resultsdao.setResults(userId, dayLevelList.get(0), yourFeed);

                } catch (NumberFormatException e) {
                    request.setAttribute("error", "入力された値が不正です。");
                }

            } else {
                response.sendRedirect("login.jsp");
                return;
            }
        } else {
            response.sendRedirect("login.jsp");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("resultDay.jsp");
        dispatcher.forward(request, response);
    }
}
