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
				System.out.println("�ð��ʰ�");
				run = false;
			} else if (list.size() == 0) {
				System.out.println("����");
				System.out.println("�ɸ� �ð� : " + (System.currentTimeMillis() - Date.getTime()) / 1000);
				run = false;
			}

			// ����� �Է°��� �÷����� ���� ���ؼ� ���� �ܾ� ������ ����.
			// ���۽��� ~ ������� �ɸ��ð��� �ʴ����� ���.
			// �Ϸ��ϴµ� 35�ʰ� �ɸ�.
		} // end of while.
		System.out.println("end of prog.");
	}
}
