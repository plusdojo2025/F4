package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.goalsDAO;
import dto.goalsDTO;


/**
 * Servlet implementation class registGoalServlet
 */
@WebServlet("/registGoalServlet")
public class registGoalServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    System.out.println("✅ registGoalServlet にアクセスがありました");
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registGoal.jsp");
	    dispatcher.forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	        request.setCharacterEncoding("UTF-8");
	        HttpSession session = request.getSession();
	        Integer userId = (Integer) session.getAttribute("user_id");

	        if (userId != null) {
	            double exercise_goal = Double.parseDouble(request.getParameter("exercise_goal"));
	            double study_goal = Double.parseDouble(request.getParameter("study_goal"));
	            double sleep_goal = Double.parseDouble(request.getParameter("sleep_goal"));

	            goalsDTO goal = new goalsDTO(0, userId, exercise_goal, study_goal, sleep_goal);
	            goalsDAO dao = new goalsDAO();
	            dao.insertGoal(goal);
	        }

	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registGoal.jsp");
			dispatcher.forward(request, response);
    }
}

