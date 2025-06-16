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

@WebServlet("/weekfeedback")
public class weekFeedbackServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);

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

                    goalsDTO goalsdto = goalsdao.selectGoal(userId);
                    double goalExercise = goalsdto.getExercise_goal();
                    double goalStudy = goalsdto.getStudy_goal();
                    double goalSleep = goalsdto.getSleep_goal();

                    List<Double> levelList = resultsdao.getAllLevel(userId);

                    calc cc = new calc();
                    double weekLevel = cc.weekLevelCheck(
                        doExercise, doStudy, doSleep,
                        goalExercise, goalStudy, goalSleep,
                        levelList
                    );
                    String yourLastFeed = cc.buildWeekFeedback(weekLevel);

                    request.setAttribute("level", weekLevel);
                    request.setAttribute("feedback", yourLastFeed);

                } catch (NumberFormatException e) {
                    request.setAttribute("error", "数値の取得に失敗しました。");//
                }

            } else {
                response.sendRedirect("login.jsp");
                return;
            }
        } else {
            response.sendRedirect("login.jsp");
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("resultWeek.jsp");
        dispatcher.forward(request, response);
    }
}
