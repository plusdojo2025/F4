package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.todoListsDTO;

public class todoListsDAO {

    // 1. リストを追加
    public static void insertToDo(todoListsDTO todo) {
        String sql = "INSERT INTO todo_lists (id, list_content) VALUES (?, ?)";

        try (Connection conn = dbConnectionDAO.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, todo.getId());
            ps.setString(2, todo.getList_content());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 2. リストを削除
    public static int deleteToDo(int todo_list_id) {
        String sql = "DELETE FROM todo_lists WHERE todo_list_id = ?";
        int rowsAffected = 0;

        try (Connection conn = dbConnectionDAO.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, todo_list_id);
            rowsAffected = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }


    // 3. 指定ユーザーのToDoリストを取得
    public static List<todoListsDTO> getToDoListByUserId(int userId) {
        List<todoListsDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM todo_lists WHERE id = ?";

        try (Connection conn = dbConnectionDAO.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                todoListsDTO dto = new todoListsDTO(
                    rs.getInt("id"),
                    rs.getString("list_content")
                );
                dto.setTodo_list_id(rs.getInt("todo_list_id"));
                dto.setCheckbox(rs.getBoolean("checkbox"));
                list.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 4. チェック状態を更新
    public void updateCheckbox(int todo_list_id, boolean newStatus) {
        String sql = "UPDATE todo_lists SET checkbox = ? WHERE todo_list_id = ?";

        try (Connection conn = dbConnectionDAO.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setBoolean(1, newStatus);
            ps.setInt(2, todo_list_id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean getCheckboxStatus(int todo_list_id) {
    boolean status = false;
    try (Connection conn = dbConnectionDAO.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT checkbox FROM todo_lists WHERE todo_list_id = ?")) {
        stmt.setInt(1, todo_list_id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            status = rs.getBoolean("checkbox");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return status;
}

}
