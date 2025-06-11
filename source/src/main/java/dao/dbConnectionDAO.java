package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnectionDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/your_db_name?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ドライバの読み込み
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
