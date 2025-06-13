package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.doTimesDAO;
import dao.resultsDAO;
import dto.doTimesDTO;
import dto.usersDTO;
/**
 * Servlet implementation class registTimeServlet
 */
@WebServlet("/registTimeServlet")
public class registTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションからユーザー情報を取得する
        request.setCharacterEncoding("UTF-8");
        usersDTO user = (usersDTO) request.getSession().getAttribute("user");
        
        // userオブジェクトからユーザーIDを取得し、Integer型の変数idに代入
        int id = user.getId();
        
        //resultDAOクラスのインスタンスを作成
		resultsDAO rdao = new resultsDAO();
		
		//指定したユーザーIDに対して、resultsテーブルに登録されているデータの件数を取得
	    int count = rdao.countResult(id);
	        
	    if(count == 0) {
	    	//評価のデータベースが0の時デフォルト画面にフォアード
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/resultDefault.jsp");
			dispatcher.forward(request, response);
	     }
	    
		//実施時間の登録画面へフォアード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //セッションからユーザー情報を取得する
		request.setCharacterEncoding("UTF-8");
        usersDTO user = (usersDTO) request.getSession().getAttribute("user");
        // userオブジェクトからユーザーIDを取得し、Integer型の変数idに代入
        Integer id = (Integer)user.getId();
        
        //resultDAOクラスのインスタンスを作成
		resultsDAO rdao = new resultsDAO();
		//指定したユーザーIDに対して、resultsテーブルに登録されているデータの件数を取得
	    int count = rdao.countResult(id);
		
	    //それぞれの実施時間を宣言する
        Double exercise_do = (double)0;			//運動時間
        Double study_do = (double)0;			//勉強時間
        Double sleep_do = (double)0;			//睡眠時間
        
        if(id != null) {
        	//jspから入力したデータを受け取る
        	exercise_do = Double.parseDouble(request.getParameter("exercise_do"));
            study_do = Double.parseDouble(request.getParameter("study_do"));
            sleep_do = Double.parseDouble(request.getParameter("sleep_do"));
        }
        
        doTimesDAO dTDao = new doTimesDAO();
        
        doTimesDTO dTDto = new doTimesDTO(id, exercise_do, study_do, sleep_do);
        
        boolean result = dTDao.insert(dTDto);
        if(result == true) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/resultDay.jsp");
			dispatcher.forward(request, response);
        }else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
        }
        if(count >= 7) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/resultWeek.jsp");
			dispatcher.forward(request, response);
        }
	}

}
