package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.usersDTO;

public class usersDAO {
    // 引数で指定されたmailPwでログイン成功ならtrueを返す
    /* public boolean isLoginOK(usersDTO mailPw) {
        Connection conn = null;
        boolean loginResult = false;

        try {
            // データベースに接続する
            Connection conn = dbConnectionDAO.getConnection();

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
        }catch (ClassNotFoundException e) {
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
    } */
    // 引数userInfoで指定されたユーザー情報を登録し、成功したらtrueを返す
    public boolean insert(usersDTO userRegist) {
        Connection conn = null;
        boolean result = false;

        try {
            // データベースに接続する
            conn = dbConnectionDAO.getConnection();

            // SQL文を準備する
            String sql = "INSERT INTO users VALUES (0, ?, ?, ?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            if (userRegist.getUser_name() != null) {
				pStmt.setString(1, userRegist.getUser_name());
			} else {
				pStmt.setString(1, "");
			}
            if (userRegist.getMail() != null) {
				pStmt.setString(2, userRegist.getMail());
			} else {
				pStmt.setString(2, "");
			}
            if (userRegist.getPw() != null) {
				pStmt.setString(3, userRegist.getPw());
			} else {
				pStmt.setString(3, "");
			}
            // SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
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

		// 結果を返す
		return result;
    }

    public usersDTO login(String mail, String pw) {
        Connection conn = null;
        PreparedStatement pStmt = null;
        ResultSet rs = null;
        usersDTO user = null;  // 最初はnullで初期化

        try {
            conn = dbConnectionDAO.getConnection();

            String sql = "SELECT id, user_name, mail, pw FROM users WHERE mail=? AND pw=?";
            pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, mail);
            pStmt.setString(2, pw);

            rs = pStmt.executeQuery();

            if (rs.next()) {
                user = new usersDTO(
                    rs.getInt("id"),
                    rs.getString("user_name"),
                    rs.getString("mail"),
                    rs.getString("pw")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
              // 例外時はnullを返す
        } finally {
            // ResultSet, PreparedStatement, Connection を忘れずに閉じる
            try {
                if (rs != null) rs.close();
                if (pStmt != null) pStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }


}











