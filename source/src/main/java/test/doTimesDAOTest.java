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
		int count = dao.countDotimes(12);
		System.out.println(count);
		
		//古い日付取得のテスト
		System.out.println("--------------古い日付取得のテスト--------------------");
		LocalDate result = dao.getFirstDate(12);
		if(result != null) {
			System.out.println(result);
			
		}else {
			System.out.println("失敗");
		}
		
		System.out.println("---------- getTwoRecords() のテスト ----------");
        List<Double> records = dao.getTwoRecords(12);
        if (records.size() == 6) {
            System.out.println("getTwoRecords テスト：成功");
            System.out.println("最新の記録: " + records.get(0) + ", " + records.get(1) + ", " + records.get(2));
            System.out.println("その前の記録: " + records.get(3) + ", " + records.get(4) + ", " + records.get(5));
        } else {
            System.out.println("getTwoRecords テスト：失敗（取得数：" + records.size() + "）");
        }

	
	
	
	
	}

}
