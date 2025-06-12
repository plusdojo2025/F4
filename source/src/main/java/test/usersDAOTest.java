package test;

import dao.usersDAO;
import dto.usersDTO;

public class usersDAOTest {
	/*
	public static void main(String[] args) {
		testIsLoginOK1(); // ユーザーが見つかる場合のテスト
		testIsLoginOK2(); // ユーザーが見つからない場合のテスト
	}
	
	// ユーザーが見つかる場合のテスト
	public static void testIsLoginOK1() {
		usersDAO dao = new usersDAO();
		usersDTO dto = dao.login("tanaka.taro@example.jp", "taro1234");
		if (dto != null) {
			System.out.println("testIsLoginOK1：テストが成功しました");
		} else {
			System.out.println("testIsLoginOK1：テストが失敗しました");
		}
	}

	// ユーザーが見つからない場合のテスト
	public static void testIsLoginOK2() {
		usersDAO dao = new usersDAO();
		usersDTO dto = dao.login("tanaka@fsfsaf.jp", "taro1234");
		if (dto == null) {
			System.out.println("testIsLoginOK2：テストが成功しました");
		} else {
			System.out.println("testIsLoginOK2：テストが失敗しました");
		}
	} */
	public static void main(String[] args) {
		usersDAO dao = new usersDAO();
		
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		usersDTO userInfo = new usersDTO(0, "takeshi", "take@icloud.com", "taketakeshi");
		if (dao.insert(userInfo)) {
			System.out.println("登録成功！");
			
		} else {
			System.out.println("登録失敗！");
		}
	}
}
