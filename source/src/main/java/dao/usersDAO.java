package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.usersDTO;

public class usersDAO {
    // 引数で指定されたmailPwでログイン成功ならtrueを返す
    public boolean isLoginOK(usersDTO mailPw) {
     
    	Connection conn = null;
        boolean loginResult = false;

        try {
            // データベースに接続する
            conn = dbConnectionDAO.getConnection();

            // SELECT文を準備する
            String sql = "SELECT count(*) FROM users WHERE mail=? AND pw=?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, mailPw.getMail());
			pStmt.setString(2, mailPw.getPw());

            // SELECT文を実行し、結果票を取得する
            ResultSet rs = pStmt.executeQuery();

            // マールアドレスとパスワードが一致するユーザーがいれば結果をtrueにする
            rs.next();
            if (rs.getInt("count(*)") == 1) {
                loginResult = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            loginResult = false;
        } finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

        // 結果を返す
		return loginResult;
    }
}
