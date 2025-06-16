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
import dto.usersDTO;

@WebServlet("/registTimeServlet")
public class registTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession(false);
        if(session == null) {
        	System.out.println("セッションnull");        }
        usersDTO userdto = (usersDTO) session.getAttribute("userinfo");
        int id = userdto.getId();
        System.out.println("userId:"+id);
        
        double exercise_do = Double.parseDouble(request.getParameter("exercise"));
        double study_do = Double.parseDouble(request.getParameter("study"));
        double sleep_do = Double.parseDouble(request.getParameter("sleep"));

        doTimesDTO doTime = new doTimesDTO(id, exercise_do, study_do, sleep_do);
        doTimesDAO.insert(doTime);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//実施時間の登録画面へフォアード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registTime.jsp");
	    dispatcher.forward(request, response);
	}
	
}
