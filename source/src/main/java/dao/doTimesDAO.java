package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.doTimesDTO;

public class doTimesDAO {

    // 実施時間の登録
    public static boolean insert(doTimesDTO time) {
        Connection conn = null;
        boolean result = false;

        try {
            // データベースと接続
            conn = dbConnectionDAO.getConnection();
            // SQL文を準備する
            String sql = "INSERT INTO do_times (do_time_id, id, exercise_do, study_do, sleep_do) VALUES (0, ?, ?, ?, ?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            // SQL文を完成させる
            pStmt.setInt(1, time.getId());
            pStmt.setDouble(2, time.getExercise_do());
            pStmt.setDouble(3, time.getStudy_do());
            pStmt.setDouble(4, time.getSleep_do());
            // SQL文を実行する
            int rs = pStmt.executeUpdate();
            // 結果を確認
            if (rs == 1) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // データベースを切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    // 実施時間の削除
    public boolean delete(doTimesDTO time) {
        Connection conn = null;
        boolean result = false;

        try {
            conn = dbConnectionDAO.getConnection();
            String sql = "DELETE FROM do_times WHERE id = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, time.getId());
            int rs = pStmt.executeUpdate();
            if (rs == 1) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // データベースを切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
