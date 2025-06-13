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
    public registTimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
        request.setCharacterEncoding("UTF-8");
        usersDTO user = (usersDTO) request.getSession().getAttribute("user");
        Integer id = (Integer)user.getId();
        
		resultsDAO rdao = new resultsDAO();
	    int count = rdao.countResult(id);
	        
	    if(count == 0) {
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
        
		request.setCharacterEncoding("UTF-8");
        usersDTO user = (usersDTO) request.getSession().getAttribute("user");
        Integer id = (Integer)user.getId();
        
		resultsDAO rdao = new resultsDAO();
	    int count = rdao.countResult(id);
		
        Double exercise_do = (double)0;
        Double study_do = (double)0;
        Double sleep_do = (double)0;
        
        if(id != null) {
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
