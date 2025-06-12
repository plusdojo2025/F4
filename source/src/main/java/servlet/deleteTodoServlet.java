package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.todoListsDAO;
@WebServlet("/deleteTodo")
public class deleteTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // パラメータの取得
        String todo_list_id = request.getParameter("todo_list_id");
        if (todo_list_id == null || todo_list_id.isEmpty()) {
            // パラメータが無い場合は400を返す
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        // パラメータを数値に(初期でStringで送られてくるため)
        int todoListId = Integer.parseInt(todo_list_id);

        // DAOを使って削除処理を実行し、影響行を取得
        int deletedCount = todoListsDAO.deleteToDo(todoListId);

        // 削除成功なら200、失敗なら500を返す
        if (deletedCount > 0) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // 削除できなかった場合
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
