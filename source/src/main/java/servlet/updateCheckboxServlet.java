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
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // パラメータ取得
        String idStr = request.getParameter("todoId");
        String checkedStr = request.getParameter("checked");
        
        // パラメータが欠けている場合は400
        if (idStr == null || checkedStr == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        // 数値・真偽値へ変換
        int todoId = Integer.parseInt(idStr);
        boolean checked = Boolean.parseBoolean(checkedStr);

        // DAOを使ってチェック状態を更新
        new todoListsDAO().updateCheckbox(todoId, checked);

        // 更新成功のレスポンスを返すよー
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
