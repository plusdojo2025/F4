package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/logout")
public class logoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッションスコープを破棄する
		HttpSession session = request.getSession();
        // 全部消える
		session.invalidate();

		// ログインページにリダイレクトする
		response.sendRedirect(request.getContextPath() + "/login");
    }
}