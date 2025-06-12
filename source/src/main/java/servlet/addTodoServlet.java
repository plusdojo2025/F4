package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.todoListsDAO;
import dto.todoListsDTO;

@WebServlet("/addTodo")
public class addTodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF-8");
//        HttpSession session = request.getSession();//セッション取得
//        Integer userId = (Integer) session.getAttribute("user_id");//ログイン時にキーとペアでsession.setAttribute()した時のキーを使う
//
//        if (userId != null) {
//            String listContent = request.getParameter("list_content");//jspより取得
//
//            todoListsDTO todo = new todoListsDTO(userId, listContent);//ToDoリストDTOがたの箱に詰める
//            todoListsDAO dao = new todoListsDAO();//dao呼びだし
//            dao.insertToDo(todo);//インサート関数呼び出し
//        }
//
//        response.sendRedirect("todoList.jsp"); // 画面を再読み込み（一覧へ戻る）
    	
    	//仮でユーザーidを1にして実行上はセッション使ってたから一応コメントアウトしたよ！
    	request.setCharacterEncoding("UTF-8");

        String list_content = request.getParameter("todoText");//<input name="todoText"> に入力されたテキストを取得。
        int id = 1; // 仮のユーザーID

        // 空だったら登録させないようにした！
        if (list_content != null && !list_content.isEmpty()) {
            todoListsDTO dto = new todoListsDTO(id, list_content);

            // todoListsDAOのinsertToDoに渡して任せた、
            todoListsDAO.insertToDo(dto);
        }

        // 戻り値を返さない場合はステータスだけ返す（どっちでもいい一応あるとjsで成功などの判断ができるようになるよーー）
        response.setStatus(HttpServletResponse.SC_OK);
    }
}

