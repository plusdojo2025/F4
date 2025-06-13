package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.goalsDTO;


public class goalsDAO {

	// 目標を登録
	public void insertGoal(goalsDTO goal) {
		Connection conn = null;
		try {
			// データベースに接続する
			conn = dbConnectionDAO.getConnection();
			
			// INSET文を準備する
			String sql = "INSERT INTO goals VALUES(0, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, goal.getId());
		    pStmt.setDouble(2, goal.getExercise_goal());
			pStmt.setDouble(3, goal.getStudy_goal());
			pStmt.setDouble(4, goal.getSleep_goal());

			// SQL文を実行する
			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	// ユーザーの目標を取得
	public goalsDTO selectGoal(int userId) {
		goalsDTO goal = new goalsDTO();
		Connection conn = null;
		try {
			// データベースに接続する
			
			conn = dbConnectionDAO.getConnection();
				
			// INSET文を準備する
			String sql = "SELECT * FROM goals WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, userId);
            ResultSet rs = pStmt.executeQuery();

			
			if (rs.next()) {
				
				goal = new goalsDTO(
						rs.getInt("goals_id"),
						rs.getInt("id"),
						rs.getDouble("exercise_goal"),
						rs.getDouble("study_goal"),
						rs.getDouble("sleep_goal")
						);
				
			} else {
				goal = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return goal;
	}
	
	public void deleteGoal(int userId){
        String sql = "DELETE FROM goals WHERE user_id = ?";
        Connection conn = null;

        try {
        	conn = dbConnectionDAO.getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
    }

}

