package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.usersDTO;
import dao.usersDAO;


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
	    //System.out.println("✅ registGoalServlet にアクセスがありました");
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registGoal.jsp");
	    dispatcher.forward(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	        request.setCharacterEncoding("UTF-8");
	        HttpSession session = request.getSession();
	        
	        usersDTO userdto = (usersDTO)session.getAttribute("userInfo");
	        int userId = userdto.getId();
	        System.out.println(userId);
/*
	        if (userId >= 1) {
	            double exercise_goal = Double.parseDouble(request.getParameter("exercise"));
	            double study_goal = Double.parseDouble(request.getParameter("study"));
	            double sleep_goal = Double.parseDouble(request.getParameter("sleep"));

	            goalsDTO goal = new goalsDTO(0, userId, exercise_goal, study_goal, sleep_goal);
	            goalsDAO dao = new goalsDAO();
	            if(dao.insertGoal(goal)) {
	            	response.sendRedirect(request.getContextPath() + "/homeServlet");
	            }
	        } 
	        else {
	        	System.out.println("登録エラー");
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registGoal.jsp");
	        	dispatcher.forward(request, response);
	        }
	        */
    }
}

