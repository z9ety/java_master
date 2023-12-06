package com.yedam;

import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmpDAO exe = new EmpDAO();
		boolean run = true;
		while (run) {
			System.out.println("1.��� 2.��� 3.���� 4.���� 5.��ȸ 6.����");
			System.out.print("�޴� ����>> ");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				System.out.println("1.��� 2.��� 3.���� 4.���� 5.��ȸ 6.����");
				System.out.print("����Է�>> ");
				String memnum_ = sc.nextLine();
				System.out.print("�̸��Է�>> ");
				String memname_ = sc.nextLine();
				System.out.print("��ȭ��ȣ�Է�>> ");
				String memtel_ = sc.nextLine();
				System.out.print("�Ի����Է�>> ");
				String jday_ = sc.nextLine();
				System.out.print("�޿��Է�>> ");
				int income_ = Integer.parseInt(sc.nextLine());
				Employee mem = new Employee(memnum_, memname_, memtel_, jday_, income_);
				if (exe.addMember(mem)) {
					System.out.println("��� �Ϸ�");
				} else {
					System.out.println("���� �߻�");
				}
				break;
			case "2":
				System.out.println("1.��� 2.��� 3.���� 4.���� 5.��ȸ 6.����");
				System.out.println("���     \t�̸�   \t��ȭ��ȣ");
				for (Employee mem2 : exe.memberList()) {
					if (mem2 != null) {
						mem2.showInfo();
					}
				}
				break;
			case "3":
				System.out.println("��� �޿�>> ");
				memnum_ = sc.nextLine();
				income_ = Integer.parseInt(sc.nextLine());
				if (exe.modifyIncome(memnum_, income_)) {
					System.out.println("���� �Ϸ�");
				} else {
					System.out.println("����� ã�� �� �����ϴ�");
				}
				break;
			case "4":
				System.out.println("���>> ");
				memnum_ = sc.nextLine();
				if (exe.removeMember(memnum_)) {
					System.out.println("���� �Ϸ�");
				} else {
					System.out.println("����� ã�� �� �����ϴ�");
				}
				break;
			case "5":
				System.out.println("�Ի���>> ");
				jday_ = sc.nextLine();
				Employee mem3 = exe.searchMember(jday_);
				if (mem3 != null) {
					mem3.showInfo();
				} else {
					System.out.println("������ �������� �ʽ��ϴ�");
				}
				break;
			case "6":
				System.out.println("�ý��� ����");
				run = false;
				break;
			default:
				System.out.println("�޴� ��ȣ�� �Է����ּ���.");
			}
		} // end of while.
	}
}
