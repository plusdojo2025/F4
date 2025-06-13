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
		
		// insert()のテスト
		System.out.println("---------- delete()のテスト ----------");
		dao.deleteGoal(1);
		
	}

}
