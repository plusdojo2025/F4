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
import dto.usersDTO;

@WebServlet("/addTodo")
public class addTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
    	
    	// セッションからユーザー情報を取得
        HttpSession session = request.getSession(false); // false → セッションが無ければ null を返す
        usersDTO loginUser = (usersDTO) session.getAttribute("userinfo");

        String list_content = request.getParameter("todoText");//<input name="todoText"> に入力されたテキストを取得。
        int userId = loginUser.getId(); // セッションからユーザーIDを取得
        
        // 空だったら登録させないようにした！
        if (list_content != null && !list_content.isEmpty()) {
            todoListsDTO dto = new todoListsDTO(userId, list_content);

            // todoListsDAOのinsertToDoに渡して任せた、
            todoListsDAO.insertToDo(dto);
        }

        // 戻り値を返さない場合はステータスだけ返す（どっちでもいい一応あるとjsで成功などの判断ができるようになるよーー）
        response.setStatus(HttpServletResponse.SC_OK);
    }
}

