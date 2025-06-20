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

@WebServlet("/registTime")
public class registTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession(false);
        
        usersDTO userdto = (usersDTO) session.getAttribute("userinfo");
        if(userdto != null) {
            int id = userdto.getId();
            if(id >=1) {
            	System.out.println("userId:"+id);
                
                double exercise_do = Double.parseDouble(request.getParameter("exercise"));
                double study_do = Double.parseDouble(request.getParameter("study"));
                double sleep_do = Double.parseDouble(request.getParameter("sleep"));

                doTimesDTO doTime = new doTimesDTO(id, exercise_do, study_do, sleep_do);

                doTimesDAO.insert(doTime);
            }
            else {
            	response.sendRedirect(request.getContextPath() + "/login");
            }
        }else {
        	response.sendRedirect(request.getContextPath() + "/login");    
        }
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
	    usersDTO userdto = (usersDTO) session.getAttribute("userinfo");
	    int userId = userdto.getId();

	    boolean deleted = deleteTables.delete(userId);
	    if (deleted) {
	        System.out.println("古いデータを削除しました（userId: " + userId + "）");
	        request.setAttribute("message", "7日が経過しました。");
	    	request.setAttribute("message2", "新しい目標を決めましょう❣");

	        // 削除された場合はゴール再登録画面へ
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registGoal.jsp");
	        dispatcher.forward(request, response);
	        return;
	    }

	    // 削除されなかった場合は実施時間登録画面へ
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registTime.jsp");
	    dispatcher.forward(request, response);
	}
	
}
