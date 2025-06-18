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
import dao.usersDAO;
import dto.goalsDTO;
import dto.usersDTO;
// ?
//mport dto.LoginUser;
//import dto.Result;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(urlPatterns = {"", "/login"})
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// リクエストパラメータを取得する 
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");

		usersDAO udao = new usersDAO();
		usersDTO udto = udao.login(mail, pw);

		if (udto != null) {
		    goalsDAO gdao = new goalsDAO();
		    goalsDTO gdto = gdao.selectGoal(udto.getId());

		    HttpSession session = request.getSession();
		    session.setAttribute("userinfo", udto);

		    if (gdto != null) {//テスト必須
		        response.sendRedirect(request.getContextPath() + "/home");
		    } else {
		        response.sendRedirect(request.getContextPath() + "/registGoal");
		    }
		    
		} else {
		    request.setAttribute("errorMessage", "ユーザー名またはパスワードが間違っています。");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		    dispatcher.forward(request, response);
		}
	}




}