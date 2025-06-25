package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dto.doTimesDTO;

public class doTimesDAO {

    // 実施時間の登録
    public boolean insert(doTimesDTO time) {
        Connection conn = null;
        boolean result = false;

        try {
            // データベースと接続
            conn = dbConnectionDAO.getConnection();
            // SQL文を準備する
            String sql = "INSERT INTO do_times (id, date, exercise_do, study_do, sleep_do)"
            		+ " VALUES (?, CURDATE(), ?, ?, ?)"
            		+ " ON DUPLICATE KEY UPDATE"
            		+ " exercise_do = VALUES(exercise_do),"
            		+ " study_do = VALUES(study_do),"
            		+ " sleep_do = VALUES(sleep_do)";

            PreparedStatement pStmt = conn.prepareStatement(sql);
            // SQL文を完成させる
            pStmt.setInt(1, time.getId());
            pStmt.setDouble(2, time.getExercise_do());
            pStmt.setDouble(3, time.getStudy_do());
            pStmt.setDouble(4, time.getSleep_do());
            // SQL文を実行する
            int rs = pStmt.executeUpdate();
            // 結果を確認
            if (rs >= 1) {
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
    public boolean delete(int id) {
        Connection conn = null;
        boolean result = false;

        try {
            conn = dbConnectionDAO.getConnection();
            String sql = "DELETE FROM do_times WHERE id = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, id);
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
    
    public double getDoTimes(int id) {
    	Connection conn = null;
    	double allDoTimes = 0;
    	try {
    		conn = dbConnectionDAO.getConnection();
    		String sql = "SELECT exercise_do, study_do, sleep_do FROM do_times WHERE id=?";
    		PreparedStatement pStmt = conn.prepareStatement(sql);
    		pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            if(rs != null) {
	            while(rs.next()) {
	            	double exdo = rs.getDouble("exercise_do");
	            	double stdo = rs.getDouble("study_do");
	            	double sldo = rs.getDouble("sleep_do");
	            	allDoTimes += (exdo + stdo + sldo);
	            }
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
    	
    	return allDoTimes;
    }
    
    public List<Double> getTimes(int userId) {//最新の一件
    	Connection conn = null;
    	List<Double> timesList = new ArrayList<Double>();
    	try {
	    	conn = dbConnectionDAO.getConnection();
	    	String sql = "SELECT exercise_do, study_do, sleep_do FROM do_times WHERE id=? ORDER BY date DESC LIMIT 1";
	    	PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, userId);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
	            timesList.add(rs.getDouble("exercise_do"));
	            timesList.add(rs.getDouble("study_do"));
	            timesList.add(rs.getDouble("sleep_do"));
	        } else {
	            // データがなかった場合に 0.0 を追加
	            timesList.add(0.0);
	            timesList.add(0.0);
	            timesList.add(0.0);
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
    	return timesList;
    }
    
    public int countDotimes(int userId) {//
        String sql = "SELECT COUNT(*) FROM do_times WHERE id = ?";
        int count = 0;

        try (Connection conn = dbConnectionDAO.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    count = rs.getInt(1);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
    
    public double getDoTimes2(int id) {//最初の実施時間登録から６日目までで登録されたdo_timesテーブルの値を出す
    	Connection conn = null;
    	double weekDoTimes = 0;
    	try {
    		conn = dbConnectionDAO.getConnection();
    		String sql = "SELECT exercise_do, study_do, sleep_do FROM do_times WHERE id=?"
    				+ " AND date BETWEEN"
    				+ " (SELECT MIN(date) FROM do_times WHERE id = ?)"
    				+ " AND (SELECT DATE_ADD(MIN(date), INTERVAL 5 DAY)"
    				+ " FROM do_times WHERE id = ?)";
    		PreparedStatement pStmt = conn.prepareStatement(sql);
    		
    		pStmt.setInt(1, id);
    		pStmt.setInt(2, id);
    		pStmt.setInt(3, id);
    		
            ResultSet rs = pStmt.executeQuery();
            
            while(rs.next()) {
            	double exdo = rs.getDouble("exercise_do");
            	double stdo = rs.getDouble("study_do");
            	double sldo = rs.getDouble("sleep_do");
            	weekDoTimes += (exdo + stdo + sldo);
            }
            
    	}catch(SQLException e){
    		System.out.println(e.getMessage());
    	}finally{
    		if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    	return weekDoTimes;
    }
    
    public LocalDate getFirstDate(int id) {
    	Connection conn = null;
        LocalDate firstdate = null;
        try {
            conn = dbConnectionDAO.getConnection();
            String sql = "SELECT date FROM do_times WHERE id = ? ORDER BY date ASC LIMIT 1";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            
            if (rs.next()) {
            	Date sqldate = rs.getDate("date");
            	firstdate = sqldate.toLocalDate();
            }else {
            	firstdate = null;
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

        return firstdate;
    }
    public LocalDate getLastTimes(int id) {//最新の一件のdateをみる
    	Connection conn = null;
        LocalDate lastdate = null;
        try {
            conn = dbConnectionDAO.getConnection();
            String sql = "SELECT date FROM do_times WHERE id = ? ORDER BY date DESC LIMIT 1";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, id);
            ResultSet rs = pStmt.executeQuery();
            
            if (rs.next()) {
            	Date sqldate = rs.getDate("date");
            	lastdate = sqldate.toLocalDate();
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

        return lastdate;
    }
    public List<Double> getTwoRecords(int userId) {//最新の一件
    	Connection conn = null;
    	List<Double> dorecords = new ArrayList<Double>();
    	
    	try {
	    	conn = dbConnectionDAO.getConnection();
	    	String sql = "SELECT exercise_do, study_do, sleep_do FROM do_times WHERE id=? ORDER BY date DESC LIMIT 2";
	    	PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, userId);
			ResultSet rs = pStmt.executeQuery();
			double exdo = 0;
			double stdo = 0;
			double sldo = 0;
			while (rs.next()) {
				exdo = rs.getDouble("exercise_do");
				stdo = rs.getDouble("study_do");
				sldo = rs.getDouble("sleep_do");
			   dorecords.add(exdo);
			   dorecords.add(stdo);
			   dorecords.add(sldo);
	        }
			if (dorecords.size() <= 3) {
				dorecords.add(exdo);
				dorecords.add(stdo);
				dorecords.add(sldo);
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
    	return dorecords;
    }
    public boolean doCheck(int userId) {//最新の一件
    	Connection conn = null;
    	boolean check = false;
    	try {
	    	conn = dbConnectionDAO.getConnection();
	    	String sql = "SELECT exercise_do, study_do, sleep_do FROM do_times WHERE id=? ORDER BY date DESC LIMIT 1";
	    	PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, userId);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
	            check = true;
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
    	return check;
    }
}