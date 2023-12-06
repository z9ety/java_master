package todo.p20231127;

import java.util.Scanner;

public class FriendApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Friend[] friends = new Friend[100];
		friends[0] = new Friend("�ڱ浿", "010-1234-5678", "A");
		friends[1] = new Friend("��浿", "010-2222-4444", "O");
		friends[2] = new Friend("ȫ�浿", "010-5656-5566", "B");
		boolean run = true;
		while (run) {
			System.out.println("1.ģ���� 2.�Է� 3.��� 4.���� 5.����");
			System.out.print("�޴� ����>> ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				int fsum = 0;
				for (int i = 0; i < friends.length; i++) {
					if (friends[i] != null) {
						fsum++;
					}
				}
				System.out.println("ģ������ " + fsum + "���Դϴ�.");
				break;
			case 2:
				System.out.print("�̸��Է�>> ");
				String name_ = sc.nextLine();
				System.out.print("����ó�Է�>> ");
				String tel_ = sc.nextLine();
				System.out.print("�������Է�>> ");
				String blood_ = sc.nextLine();
				for (int i = 0; i < friends.length; i++) {
					if (friends[i] == null) {
						friends[i] = new Friend(name_, tel_, blood_);
						System.out.println("�Է� �Ϸ�");
						break;

					}
				}
				break;
			case 3:
				System.out.println("�̸�   \t����ó           \t������");
				for (int i = 0; i < friends.length; i++) {
					if (friends[i] != null) {
						System.out.printf("%-5s\t%-15s\t%s\n", friends[i].getName(), friends[i].getTel(),
								friends[i].getBlood());
					}
				}
				break;
			case 4:
				System.out.print("�������� ������ ģ�� �̸��� �Է�>> ");
				name_ = sc.nextLine();
				System.out.print("�������Է�>> ");
				blood_ = sc.nextLine();
				for (int i = 0; i < friends.length; i++) {
					if (friends[i].getName().equals(name_)) {
						friends[i].setBlood(blood_);
						System.out.println("���� �Ϸ�");
					}
				}
				break;
			case 5:
				System.out.println("�ý��� ����");
				run = false;
				break;
			default:
				System.out.println("�޴� ��ȣ�� �Է����ּ���");
			}
		}
	}

}
