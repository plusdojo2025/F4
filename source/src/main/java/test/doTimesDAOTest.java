package test;

import dao.doTimesDAO;
import dto.doTimesDTO;

public class doTimesDAOTest {

	public static void main(String[] args) {
		
		//doTimesDAO dTDao = new doTimesDAO();
        //doTimesDTO dTDto = new doTimesDTO();
        doTimesDAO dao = new doTimesDAO();
		
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		doTimesDTO timeInfo = new doTimesDTO(0, 1, 2, 3, 7);
		if (dao.insert(timeInfo)) {
			System.out.println("登録成功！");
			
		} else {
			System.out.println("登録失敗！");
		}
		
		
	}

}
