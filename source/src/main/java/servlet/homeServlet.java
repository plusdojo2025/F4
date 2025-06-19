package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.doTimesDAO;
import dao.goalsDAO;
import dto.goalsDTO;
import dto.usersDTO;

/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/home")
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
		// ログイン失敗
		if (user == null) {
			System.out.println("ログイン情報がセッションにありません。ログイン画面へリダイレクトします。");
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		//目標時間を格納する変数の宣言
		 double exercise_goal;
		 double study_goal;
		 double sleep_goal;
		
		
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
	        exercise_goal = goal.getExercise_goal();
	        study_goal = goal.getStudy_goal();
	        sleep_goal = goal.getSleep_goal();
	        
	        //実施時間の取得
	        doTimesDAO ddao = new doTimesDAO();
	        double doTimes = ddao.getDoTimes(userId);
	        double goals = (exercise_goal + study_goal + sleep_goal) * 7;
	        double level = Math.round((doTimes / goals * 100) * 10) / 10;
	        
	        //実施時間の進捗を格納
	        request.setAttribute("goals", goals);
	        request.setAttribute("level", level);
	        
	        //目標の格納
	        request.setAttribute("exercise_goal", exercise_goal);
	        request.setAttribute("study_goal", study_goal);
	        request.setAttribute("sleep_goal", sleep_goal);
	        
	        //ホーム画面にフォアード
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
	        dispatcher.forward(request, response);
		}
		        
	}

}
