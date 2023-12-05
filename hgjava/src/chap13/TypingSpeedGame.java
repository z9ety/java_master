package chap13;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TypingSpeedGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = "Tens of thousands of internally displaced Palestinians ";
//				+ "have arrived in Gaza's southernmost governorate of Rafah over the past two days, the United Nations' humanitarian agency said Tuesday";
		String[] words = word.split(" ");
		List<String> list = new ArrayList<>();
		for (String str : words) {
			list.add(str);
		}
		Date Date = new Date();

		;
		boolean run = true;
		while (run) {
			for (String str : list) {
				System.out.println(str);
			}
			System.out.println(list.size());
			String typ = sc.nextLine();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(typ) && list.size() != 0
						&& (System.currentTimeMillis() - Date.getTime()) / 1000 < 35) {
					list.remove(typ);
				}

			}
			if ((System.currentTimeMillis() - Date.getTime()) / 1000 >= 35) {
				System.out.println("시간초과");
				run = false;
			} else if (list.size() == 0) {
				System.out.println("성공");
				System.out.println("걸린 시간 : " + (System.currentTimeMillis() - Date.getTime()) / 1000);
				run = false;
			}

			// 사용자 입력값과 컬렉션의 값과 비교해서 같은 단어 있으면 삭제.
			// 시작시점 ~ 종료시점 걸린시간을 초단위로 계산.
			// 완료하는데 35초가 걸림.
		} // end of while.
		System.out.println("end of prog.");
	}
}
