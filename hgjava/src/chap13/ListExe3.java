package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListExe3 {
//	public static int getSequence() {
//		int seqNo = 1;
//		int maxNo = 0;
//		for(int i=0; i<members.length; i++) {
//			if(members.get(i) != null && members.get(i).getMemberNo()>maxNo) {
//				maxNo = members.get(i).getMemberNo(); 
//			}
//	}
	public static void main(String[] args) {

		// ȸ�����(ȸ����ȣ, �̸�, ����Ʈ)
		// 1.��� 2.�̸���ȸ 3.����Ʈ���� 4.���� 5.����.\
		List<Member> members = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int no = 0;
		while (run) {
			for (int i = 1; i <= members.size(); i++) {
				if (members.get(i).getMemberName().indexOf(members.get(i).getMemberName()) != 1) {

				}
			}
			System.out.println("1.ȸ����� 2.�̸���ȸ 3.����Ʈ���� 4.���� 5.����");
			System.out.println("���� : ");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				System.out.println("�̸��� �Է��Ͻʽÿ�");
				String name = sc.nextLine();
				no += 1;
				members.add(new Member(no, name, 0));
				System.out.println("��ϵǾ����ϴ�.");
				break;
			case "2":
				System.out.println("�̸� �˻� : ");
				String search = sc.nextLine();
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getMemberName().indexOf(search) != -1) {
						System.out.printf("M-00%d %6s %8d", members.get(i).getMemberNo(),
								members.get(i).getMemberName(), members.get(i).getPoint());
					} else {
						System.out.println("�ش� ������ �����ϴ�.");
					}
				}
				break;
			case "3":

				break;
			case "4":
				break;
			case "5":
				System.out.println("�ý��� ����.");
				run = false;
			default:
				System.out.println("�߸��� ���Դϴ�.");
			}
		}
		System.out.println("end of prog.");
	}// end of main.
}
