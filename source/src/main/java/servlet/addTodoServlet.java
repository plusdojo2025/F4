package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.todoListsDAO;
import dto.todoListsDTO;

@WebServlet("/addTodo")
public class addTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();//セッション取得
        Integer userId = (Integer) session.getAttribute("user_id");//ログイン時にキーとペアでsession.setAttribute()した時のキーを使う

        if (userId != null) {
            String listContent = request.getParameter("list_content");//jspより取得

            todoListsDTO todo = new todoListsDTO(userId, listContent);//ToDoリストDTOがたの箱に詰める
            todoListsDAO dao = new todoListsDAO();//dao呼びだし
            dao.insertToDo(todo);//インサート関数呼び出し
        }

        response.sendRedirect("todo.jsp"); // 画面を再読み込み（一覧へ戻る）
    }
}

