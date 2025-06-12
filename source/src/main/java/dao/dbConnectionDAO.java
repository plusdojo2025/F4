package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnectionDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/f4?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
    	try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ドライバのロード
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBCドライバが見つかりません: " + e.getMessage());
            throw new SQLException("ドライバロード失敗", e);
        } catch (SQLException e) {
            System.err.println("DB接続失敗: " + e.getMessage());
            throw e; // 呼び出し元で再処理できるように再スロー
        }
    }
}
