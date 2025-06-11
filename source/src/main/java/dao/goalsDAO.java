package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.goalsDTO;


public class goalsDAO {

	// 目標を登録
	public void insertGoal(goalsDTO goal) {
		try {
			// データベースに接続する
			Connection conn = dbConnectionDAO.getConnection();
			
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
	public List<goalsDTO> selectGoal(int userId) {
		List<goalsDTO> goalList = new ArrayList<>();
		try {
			// データベースに接続する
			Connection conn = dbConnectionDAO.getConnection();
				
			// INSET文を準備する
			String sql = "SELECT * FROM goals WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, userId);
            ResultSet rs = pStmt.executeQuery();

			
			while (rs.next()) {
				
				goalsDTO goal = new goalsDTO(
						rs.getInt("goals_id"),
						rs.getInt("id"),
						rs.getDouble("exercise_goal"),
						rs.getDouble("study_goal"),
						rs.getDouble("sleep_goal")
						);
				
				goalList.add(goal);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return goalList;
	}
}


