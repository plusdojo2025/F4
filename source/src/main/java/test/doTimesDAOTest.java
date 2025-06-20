package test;

import java.time.LocalDate;
import java.util.List;

import dao.doTimesDAO;
import dto.doTimesDTO;

public class doTimesDAOTest {

	public static void main(String[] args) {
		
		//doTimesDAO dTDao = new doTimesDAO();
        //doTimesDTO dTDto = new doTimesDTO();
        doTimesDAO dao = new doTimesDAO();
		
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		doTimesDTO timeInfo = new doTimesDTO(1, 2, 3, 7);
		if (dao.insert(timeInfo)) {
			System.out.println("登録成功！");
			
		} else {
			System.out.println("登録失敗！");
		}
		
		//最新の実施時間の取得のテスト
		System.out.println("---------- 最新の実施時間の取得のテスト ----------");
		List<Double> dotime = dao.getTimes(1);
		if(dotime != null) {
			for(double e: dotime) {
				System.out.println(e);
			}
		}
		else {
			System.out.println("失敗");
		}
		
		
		// insert()のテスト
		System.out.println("---------- countResult()のテスト ----------");
		int count = dao.countDotimes(1);
		System.out.println(count);
		
		//古い日付取得のテスト
		System.out.println("--------------古い日付取得のテスト--------------------");
		LocalDate result = dao.getFirstDate(1);
		if(result != null) {
			System.out.println(result);
			
		}else {
			System.out.println("失敗");
		}
	
	
	
	
	}
	
	
	
	
	
	
	
	
}
