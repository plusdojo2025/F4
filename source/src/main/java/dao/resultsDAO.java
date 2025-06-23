package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class resultsDAO {

    // 進捗率とフィードバックを保存
    public void setResults(int userId, double level, String feedback) {
        String sql = "INSERT INTO results (id, day_toward, feedback) VALUES (?, ?, ?)";

        try (Connection conn = dbConnectionDAO.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            

            ps.setInt(1, userId);
            ps.setDouble(2, level);
            ps.setString(3, feedback);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    public List<Double> getAllLevel(int userId){
        List<Double> levelList = new ArrayList<>();
        String sql = "SELECT day_toward FROM results WHERE id = ? ORDER BY results_id ASC LIMIT 6";//１～６日までの達成度取得

        try (Connection conn = dbConnectionDAO.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                levelList.add(rs.getDouble("day_toward"));//データベースのカラム名を参照
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return levelList;
    }

    //-----------------------------------------------データのレコードを全て消す処理--------------------------------------
    public void deleteAllResult(int userId){
        String sql = "DELETE FROM results WHERE id = ?";//次の目標登録ボタンでuserIdを得る

        try (Connection conn = dbConnectionDAO.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public double getNewLevel(int userId) {
    	double level =0.0;
    	String sql = "SELECT day_toward FROM results WHERE id = ? ORDER BY result_id DESC LIMIT 1";
    	try (Connection conn = dbConnectionDAO.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

               ps.setInt(1, userId);
               ResultSet rs = ps.executeQuery();

               if(rs.next()){
            	   level = rs.getDouble("day_toward");
               }
               
           }catch(SQLException e){
               e.printStackTrace();
           }
           return level;
    }
    
    public String getNewFeedback(int userId) {
    	String feed ="";
    	String sql = "SELECT feedback FROM results WHERE id = ? ORDER BY result_id DESC LIMIT 1";
    	try (Connection conn = dbConnectionDAO.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

               ps.setInt(1, userId);
               ResultSet rs = ps.executeQuery();

               if(rs.next()){
            	   feed = rs.getString("feedback");
               }
               
           }catch(SQLException e){
               e.printStackTrace();
           }
           return feed;
    }
    

}
