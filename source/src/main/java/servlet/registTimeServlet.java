package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.doTimesDAO;
import dto.doTimesDTO;
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
		// TODO Auto-generated method stub	
		//実施時間の登録画面へフォアード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Integer id = (Integer)session.getAttribute("id");
        
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
        	
        }else {
        	
        }
	}

}
