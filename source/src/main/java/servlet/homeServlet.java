package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.goalsDAO;
import dto.goalsDTO;
import dto.usersDTO;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/homeServlet")
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		//セッションからユーザー情報を所得する
		usersDTO user = (usersDTO) request.getSession().getAttribute("userinfo");
		String name;
		int userId;
		
		//目標時間を格納する変数の宣言
		 double exercise_do;
		 double study_do;
		 double sleep_do;
		
		
		if(user!=null) {
			//名前を取得
	        name = user.getUser_name();
	        //ユーザーのIDの取得
	        userId = user.getId();
	        
	        //名前を格納
	        request.setAttribute("name",name);

	        //目標の取得
			 goalsDAO gDao = new goalsDAO();
			 goalsDTO goal = gDao.selectGoal(userId);
				        
			 exercise_do = goal.getExercise_goal();
			 study_do = goal.getStudy_goal();
			 sleep_do = goal.getSleep_goal();
			 
			        
			 //目標の格納
			 request.setAttribute("exercise_do", exercise_do);
			 request.setAttribute("study_do", study_do);
			 request.setAttribute("sleep_do", sleep_do);
			        
			 //ホーム画面にフォアード
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
			 dispatcher.forward(request, response);
		}
	/*	else {
			//ログインにリダイレクト
			response.sendRedirect("/F4/loginServlet.java");
			return;
		}*/
  
		        
	}

}
