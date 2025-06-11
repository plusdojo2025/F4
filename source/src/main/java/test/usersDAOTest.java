package test;

import dao.usersDAO;
import dto.usersDTO;

public class usersDAOTest {
	public static void main(String[] args) {
		testIsLoginOK1(); // ユーザーが見つかる場合のテスト
		testIsLoginOK2(); // ユーザーが見つからない場合のテスト
	}

	// ユーザーが見つかる場合のテスト
	public static void testIsLoginOK1() {
		usersDAO dao = new usersDAO();
		if (dao.isLoginOK(new usersDTO(0, "", "tanaka.taro@example.jp", "taro1234"))) {
			System.out.println("testIsLoginOK1：テストが成功しました");
		} else {
			System.out.println("testIsLoginOK1：テストが失敗しました");
		}
	}

	// ユーザーが見つからない場合のテスト
	public static void testIsLoginOK2() {
		usersDAO dao = new usersDAO();
		if (!dao.isLoginOK(new usersDTO(0, "", "mail", "pw"))) {
			System.out.println("testIsLoginOK2：テストが成功しました");
		} else {
			System.out.println("testIsLoginOK2：テストが失敗しました");
		}
	}
}
