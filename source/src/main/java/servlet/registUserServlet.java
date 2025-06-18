package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.usersDAO;
import dto.usersDTO;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/registUser")
public class registUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("username");
		String mail = request.getParameter("email");
		String pw = request.getParameter("password");
		
		// 登録処理を行う
		usersDAO udao = new usersDAO();
		if (udao.insert(new usersDTO(0, user_name, mail, pw))) {
			response.sendRedirect(request.getContextPath() + "/login");
		} 
		else {
			request.setAttribute("errorMessage", "このメールアドレスは使用されています。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registUser.jsp");
		    dispatcher.forward(request, response);
		}
	}
}
