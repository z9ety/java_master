package chap8;

import java.util.Scanner;

public class MainExe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DatabaseService svc = new OracleService(); // new MySQLService();

		boolean run = true;
		while (run) {
			System.out.println("1.��� 2.���� 3.���� 4.����");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				svc.add();
				break;
			case 2:
				svc.modify();
				break;
			case 3:
				svc.remove();
				break;
			}
		}
		System.out.println("end of prog.");
	}
}
