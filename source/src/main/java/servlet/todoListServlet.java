package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.todoListsDAO;
import dto.todoListsDTO;
import dto.usersDTO;

@WebServlet("/todoList")
public class todoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッションからユーザー情報を取得
		HttpSession session = request.getSession(false); // false → セッションが無ければ null を返す
		usersDTO loginUser = (usersDTO) session.getAttribute("userinfo");

		if (loginUser == null) {
			System.out.println("ログイン情報がセッションにありません。ログイン画面へリダイレクトします。");
			response.sendRedirect(request.getContextPath() + "/loginServlet");
			return;
		}

		int userId = loginUser.getId(); // セッションからユーザーIDを取得
		//System.out.println("セッションから取得したユーザーID: " + userId);

		// ユーザーIDに対応するToDoリストを取得
		List<todoListsDTO> todoList = todoListsDAO.getToDoListByUserId(userId);
		request.setAttribute("todoList", todoList);

		// JSP にフォワード
		request.getRequestDispatcher("/WEB-INF/jsp/todoList.jsp").forward(request, response);
	}

}
