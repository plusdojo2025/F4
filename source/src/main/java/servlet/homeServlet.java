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
    public homeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				//名前を取得セッションからとる
				usersDTO user = new usersDTO();
				String name= user.getUser_name();
				
				//名前を格納
		        request.setAttribute("name",name);
		        
		        //ユーザーのIDの取得
		        request.setCharacterEncoding("UTF-8");
		        	HttpSession session = request.getSession();
		        	Integer userId = (Integer)(session.getAttribute("user_id"));
		 
		        //実施時間を格納する変数の宣言
		        	 Double exercise_do;
		        	 Double  study_do;
		        	 Double  sleep_do;
		        	 
		        if(userId != null) {
			        //目標の取得
			        goalsDAO gDao = new goalsDAO();
			        goalsDTO goal = gDao.selectGoal(userId);
			        
			        exercise_do = goal.getExercise_goal();
			        study_do = goal.getExercise_goal();
			        sleep_do = goal.getExercise_goal();
		        }else {
		        	//ユーザーのIDを取得できなかった時の処理
		        	exercise_do = (double)0;
		        	study_do = (double)0;
		        	sleep_do = (double)0;
		        }
		        

		        
		        //目標の格納
		        request.setAttribute("exercise_do", exercise_do);
		        request.setAttribute("study_do", study_do);
		        request.setAttribute("sleep_do", sleep_do);
		        
		        //ホーム画面にフォアード
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		        dispatcher.forward(request, response);
		        
  
		        
	}

}
