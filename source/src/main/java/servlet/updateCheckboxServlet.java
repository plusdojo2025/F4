package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.todoListsDAO;

@WebServlet("/updateCheckbox")
public class updateCheckboxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int todo_list_id = Integer.parseInt(request.getParameter("todo_list_id"));//jspよりリストidを取得

        todoListsDAO dao = new todoListsDAO();

        // 現在の状態を取得
        boolean currentStatus = dao.getCheckboxStatus(todo_list_id);//チェックボックスの状態判定処理を呼び出し

        // 状態を反転
        boolean newStatus = !currentStatus;

        // 状態を更新
        dao.updateCheckbox(todo_list_id, newStatus);

        response.sendRedirect("todo.jsp");
    }
}
