package servlet;

import java.io.IOException;
import java.time.LocalDate;

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


/**
 * Servlet implementation class registGoalServlet
 */
@WebServlet("/registGoal")
public class registGoalServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
	    usersDTO userdto = (usersDTO) session.getAttribute("userinfo");
	    int id = userdto.getId();
	    goalsDAO gdao = new goalsDAO();
	    doTimesDAO dtdao = new doTimesDAO();
	    resultsDAO rdao = new resultsDAO();
	    calc cc = new calc();
	    
	    LocalDate firstdate = dtdao.getFirstDate(id);
	    if (firstdate != null) {
	        LocalDate lastdate = dtdao.getLastTimes(id);
	        LocalDate nowdate = LocalDate.now();
	        long date = cc.judgeDate(firstdate, nowdate);
	        long lastinsert = cc.judgeDate(lastdate, nowdate);
	        
	        System.out.println(date + "ですよ");
	        if (date >= 6 && lastinsert == 0) {
	            gdao.deleteGoal(id);
	            dtdao.delete(id);
	            rdao.deleteAllResult(id);
	        }
	        System.out.println("✅ registGoalServlet にアクセスがありました");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registGoal.jsp");
	        dispatcher.forward(request, response);
	    }
		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	        request.setCharacterEncoding("UTF-8");
	        HttpSession session = request.getSession(false);
	        
	        usersDTO userdto = (usersDTO) session.getAttribute("userinfo");
	        
	        if (userdto == null) {
				System.out.println("ログイン情報がセッションにありません。ログイン画面へリダイレクトします。");
				response.sendRedirect(request.getContextPath() + "/login");
				return;
			}
	        
	        int userId = userdto.getId();
	        System.out.println("userId:"+userId);

	        if (userId >= 1) {//←要変更
	            double exercise_goal = Double.parseDouble(request.getParameter("exercise"));
	            double study_goal = Double.parseDouble(request.getParameter("study"));
	            double sleep_goal = Double.parseDouble(request.getParameter("sleep"));

	            goalsDTO goal = new goalsDTO(0, userId, exercise_goal, study_goal, sleep_goal);
	            goalsDAO dao = new goalsDAO();
	            try {
		            if(dao.insertGoal(goal)) {
		            	response.sendRedirect(request.getContextPath() + "/home");//homeservletのdoGetが呼ばれる
		            	System.out.println(request.getContextPath());
		            	
		            }
		            else 
		            {
			        	System.out.println("a登録エラー");
			        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registGoal.jsp");
			        	dispatcher.forward(request, response);
			        }
	            } catch (Exception e){
	            	String er = e.getMessage();
	            	session.setAttribute("error", er);
	            	response.sendRedirect("");
	            }
	        } 
	        else 
	        {
	        	System.out.println("yu-zaIDみつからない");
	        	response.sendRedirect(request.getContextPath() + "/login");
	        }
	        
    }
}

