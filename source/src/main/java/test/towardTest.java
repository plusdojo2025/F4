package test;

import java.util.Scanner;



public class towardTest {

	public static boolean isAdult(int age) {
		final int ADLUT_AGE = 18;
		return age >= ADLUT_AGE;
	}

	// メインメソッド
	public static void main(String[] args) {
		// キー入力の準備処理
		Scanner scn = new Scanner(System.in);
		
		double oneday = 24;
		
		double gex = 2;
		double gst = 3;
		double gsl = 7;

		// 時間をキー入力する
		System.out.print("運動時間-->");
		double ex = scn.nextInt();
		System.out.print("勉強時間-->");
		double st = scn.nextInt();
		System.out.print("睡眠時間-->");
		double sl = scn.nextInt();
		
		if (gsl > 8) {
			gsl = 8;
		}

		// 判定結果を表示する
		if (ex+st+sl <= oneday) {
			if (sl > 8) {
				double num = sl - 8;
				sl -= num * 4;
			}
			double gTime = gex + gst + gsl;
			double dTime = ex + st + sl;
			
			double time = dTime / gTime * 100;
			System.out.println(time);
		}
		else {
			System.out.println("エラーです");
		}

		// キー入力の終了処理
		scn.close();
	}

}
