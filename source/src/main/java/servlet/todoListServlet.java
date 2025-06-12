package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.todoListsDAO;
import dto.todoListsDTO;

@WebServlet("/todoList")
public class todoListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private todoListsDAO todoListDAO;
    
//    表示ですよーーー！
//    これはただ表示するだけですよー！
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int id = 1;
    	List<todoListsDTO> todoList = todoListsDAO.getToDoListByUserId(id);
    	request.setAttribute("todoList", todoList);
        // JSP にフォワード
        request.getRequestDispatcher("/WEB-INF/jsp/todoList.jsp").forward(request, response);
    }
}
