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

        //jspからpostされたリストIDを受け取る
        int todo_list_id = Integer.parseInt(request.getParameter("todo_list_id"));
        todoListsDAO dao = new todoListsDAO();//dao呼び出し
        dao.deleteToDo(todo_list_id);//デリート処理呼び出し

        response.sendRedirect("todoList.jsp");//ページ更新
    }
}

