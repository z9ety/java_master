package chap7;

import java.util.Scanner;

public class FriendApp {
	static Scanner sc = new Scanner(System.in);
	static Friend[] storage = new Friend[10];

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("1.��� 2.��� 3.�󼼺��� 4.����");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1: // ���.
				addFriend();
				break;
			case 2: // ���.
				friendList();
				break;
			case 3: // ��.
				getFriend();
				break;
			default:
				System.out.println("�����մϴ�.");
				run = false;
			}
		}
	} // end of main.

	private static void addFriend() {
		System.out.println("1.ģ�� 2.�б� 3.ȸ�� ");
		int subMenu = Integer.parseInt(sc.nextLine());

		Friend friend = null;

		System.out.println("�̸�>>> ");
		String name = sc.nextLine();
		System.out.println("����ó>>> ");
		String phone = sc.nextLine();
		// �̸�,����ó
		if (subMenu == 1) {
			friend = new Friend(name, phone); // Friend�ν��Ͻ�.

		} else if (subMenu == 2) {
			// �̸�,����ó,�б�,����
			System.out.println("�б�>>> ");
			String univ = sc.nextLine();
			System.out.println("����>>> ");
			String major = sc.nextLine();
			friend = new UnivFriend(name, phone, univ, major);
		} else if (subMenu == 3) {
			// �̸�,����ó,ȸ��,�μ�
			System.out.println("ȸ��>>> ");
			String company = sc.nextLine();
			System.out.println("�μ�>>> ");
			String dept = sc.nextLine();
			friend = new CompFriend(name, phone, company, dept);
		}
		// �迭�� �߰�.
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == null) {
				storage[i] = friend;
				break;
			}
		}
		System.out.println("����Ϸ�");

	} // ���.

	private static void friendList() {
		for (Friend fnd : storage) {
			if (fnd != null) {
				System.out.println(fnd.showInfo());
			}
		}
	} // ���.

	private static void getFriend() {
		// �̸���ȸ, ����ó��ȸ
		System.out.println("1.�̸� 2.����ó");
		int subMenu = Integer.parseInt(sc.nextLine());
		String searchCond = "";
		if (subMenu == 1) {
			searchCond = sc.nextLine();
			for (Friend fnd : storage) {
				if (fnd != null && fnd.getName().equals(searchCond)) {
					System.out.println(fnd.showInfo());
				}
			}
		} else if (subMenu == 2) {
			searchCond = sc.nextLine();
			for (Friend fnd : storage) {
				if (fnd != null && fnd.getPhone().equals(searchCond)) {
					System.out.println(fnd.showInfo());
				}
			}
		} else {
			System.out.println("1 �Ǵ� 2 �����ϼ���.");
		}
	} // �ܰ���ȸ.

	void backup() {
		// Friend
		Friend parent = new Friend();
		parent.setName("ȫ�浿");
		parent.setPhone("010-1111");
		System.out.println(parent.toString());

		// UnivFriend
		UnivFriend child = new UnivFriend();
		child.setName("��ö��");
		child.setPhone("010-2222");
		child.setUniv("���̴��б�");
		child.setMajor("��ǻ�Ͱ��а�");
		System.out.println(child.showInfo());

		Friend[] friends = new Friend[10];
		friends[0] = parent;
		friends[1] = child;
	}
}
