package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				
				//名前を取得
				usersDTO user = new usersDTO();
				String name= user.getUser_name();
				
				//名前を格納
		        request.setAttribute("name",name);
		        
		        //目標の取得
		        goalsDTO goal = new goalsDTO();
		        Double exercise = goal.getExercise_goal();
		        Double study = goal.getStudy_goal();
		        Double sleep = goal.getSleep_goal();
		        
		        //目標の格納
		        request.setAttribute("exercise", exercise);
		        request.setAttribute("study", study);
		        request.setAttribute("sleep", sleep);
		        
		        //ホーム画面にフォアード
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		        dispatcher.forward(request, response);
		        
  
		        
	}

}
