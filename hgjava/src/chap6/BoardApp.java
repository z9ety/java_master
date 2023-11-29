package chap6;

import java.util.Scanner;

public class BoardApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board[] arr = new Board[100];
		boolean run = true;
		int num_ = 0;
		while(run) {
			System.out.println("1.��� 2.��� 3.����ȸ 4.����");
			System.out.print("���� > ");
			int sel = Integer.parseInt(sc.nextLine());
			
			switch(sel) {
			case 1:
				System.out.print("���� : ");
				String title_ = sc.nextLine();
				System.out.print("�ۼ��� : ");
				String writer_ = sc.nextLine();
				System.out.print("���� : ");
				String txt_ = sc.nextLine();
				System.out.print("�ۼ��Ͻ� : ");
				String day_ = sc.nextLine();
				num_ += 1;
				Board at = new Board(num_,title_,writer_,txt_,day_);
				for(int i=0; i<arr.length; i++) {
					if(arr[i] == null) {
						arr[i] = at;
						System.out.println("��ϵǾ����ϴ�.");
						break;
					}
				}
				break;
			case 2:
				System.out.println("------------------------------");
				for(int i=0; i<arr.length; i++) {
					if(arr[i] != null) {
						arr[i].showInfo();
					}
				}
				System.out.println("------------------------------");
				break;
			case 3:
				System.out.println("����ȸ�� �Խù� ��ȣ�� �Է����ּ��� > ");
				int join = Integer.parseInt(sc.nextLine());
				for(int i=0; i<arr.length; i++) {
					if(arr[i] != null && arr[i].getNum() == join) {
						arr[i].showInfo2();
					}
				}
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				run = false;
			}
		}
	}//end main
}//end class
