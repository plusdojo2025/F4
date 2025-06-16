package test;

import dao.goalsDAO;
import dto.goalsDTO;

public class goalsDAOTest {

	public static void main(String[] args) {
		goalsDAO dao = new goalsDAO();
		
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		goalsDTO goalInfo = new goalsDTO(0, 1, 2, 3, 7);
		if (dao.insertGoal(goalInfo)) {
			System.out.println("登録成功！");
			
		} else {
			System.out.println("登録失敗！");
		}
		
		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		goalsDTO goalSelect = new goalsDTO();
		goalSelect = dao.selectGoal(1);
		if (goalSelect == null) {
			System.out.println("null");
		} else {
			System.out.println("OK:" + goalSelect);
		}
		
		


		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.deleteGoal(1)) {
			System.out.println("削除成功！");
			
		} else {
			System.out.println("削除失敗！");
		}
		
	}

}
