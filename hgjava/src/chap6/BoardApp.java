package chap6;

import java.util.Scanner;

public class BoardApp {
	public static BoardExe exe = new BoardExe();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
//		Board[] arr = new Board[100];
//		int num_ = 0;
		//////////////////////////////////
		String id = null;
		UserExe uexe = new UserExe();
		while(true) {
			System.out.print("id�� �Է�>>> ");
			id = sc.nextLine();
			System.out.print("pw�� �Է�>>> ");
			String pw = sc.nextLine();
			User user = uexe.logIn(id, pw);
			if(user != null) {
				System.out.println(user.getUserName() + "�� ȯ���մϴ�.");
				break;
			}
			else {
				System.out.println("id, pw Ȯ���ϼ���");
			}
		}// �α��� ó��.
		/////////////////////////////////
		// �ʱⰪ ����.
		exe.initData();
		
		while(run) {
			System.out.println("1.��� 2.��� 3.����ȸ 4.���� 5.���� 6.����");
//			System.out.println("1.��� 2.��� 3.����ȸ 4.����");
			System.out.print("���� > ");
			int sel = Integer.parseInt(sc.nextLine());
			
			switch(sel) {
			case 1:
				System.out.print("���� : ");
				String title_ = sc.nextLine();
				System.out.print("���� : ");
				String txt_ = sc.nextLine();
				System.out.print("�ۼ��Ͻ� : ");
				String day_ = sc.nextLine();
				
				Board board = new Board(exe.getSequence(), title_, id, txt_, day_);
				if(exe.addBoard(board)) {
					System.out.println("��� ����!");
				}
				else {
					System.out.println("��� ����!");
				}
				break;
//				System.out.print("���� : ");
//				String title_ = sc.nextLine();
//				System.out.print("�ۼ��� : ");
//				String writer_ = sc.nextLine();
//				System.out.print("���� : ");
//				String txt_ = sc.nextLine();
//				System.out.print("�ۼ��Ͻ� : ");
//				String day_ = sc.nextLine();
//				num_ += 1;
//				Board at = new Board(num_,title_,writer_,txt_,day_);
//				for(int i=0; i<arr.length; i++) {
//					if(arr[i] == null) {
//						arr[i] = at;
//						System.out.println("��ϵǾ����ϴ�.");
//						break;
//					}
//				}
//				break;
			case 2: //��Ϻ��� -> ����������.
				Board[] boardAry = exe.boardList();
				showList(boardAry, 1);
				while(true) {
					int page = Integer.parseInt(sc.nextLine());
					if(page == 0) {
						break;
					}
					showList(boardAry, page);
				}
				break;
//				System.out.println("------------------------------");
//				for(int i=0; i<arr.length; i++) {
//					if(arr[i] != null) {
//						arr[i].showInfo();
//					}
//				}
//				System.out.println("------------------------------");
//				break;
			case 3:
				System.out.print("�۹�ȣ �Է�>>> ");
				int no =Integer.parseInt(sc.nextLine());
				Board result = exe.getBoard(no);
				if(result != null) {
					System.out.println(result.showDetailInfo());
				}
				else {
					System.out.println("��ȸ�� ������ �����ϴ�");
				}
				break;
//				System.out.println("����ȸ�� �Խù� ��ȣ�� �Է����ּ��� > ");
//				int join = Integer.parseInt(sc.nextLine());
//				for(int i=0; i<arr.length; i++) {
//					if(arr[i] != null && arr[i].getNum() == join) {
//						arr[i].showInfo2();
//					}
//				}
//				break;
			case 4: // ����.
				System.out.println("������ �۹�ȣ>>> ");		
				no = Integer.parseInt(sc.nextLine());
				if(!exe.checkResponsibility(id, no)) {
					System.out.println("���Ѿ���");
					continue;
				}
				System.out.println("������ �۳���>>> ");	
				txt_ = sc.nextLine();
				if(exe.modBoard(no, txt_)) {
					System.out.println("���� ����!");
				}
				else {
					System.out.println("ó�� ����!");
				}
				break;
//				System.out.println("���α׷��� �����մϴ�.");
//				run = false;
			case 5:
				System.out.println("������ �۹�ȣ>>> ");
				no = Integer.parseInt(sc.nextLine());
				if(!exe.checkResponsibility(id, no)) {
					System.out.println("�������Ѿ���");
					continue;
				}
				if(exe.remBoard(no)) {
					System.out.println("���� ����");
				}
				else {
					System.out.println("���� ����");
				}
			case 6:
				System.out.println("���α׷��� �����մϴ�.");
				run = false;
			}
		}
	}//end main
	
	public static void showList(Board[] boardAry, int page) {
		// ����¡ó��.
		Board[] pageAry = exe.pageList(boardAry, page);
		System.out.println("�۹�ȣ ���� �ۼ��� �ۼ��Ͻ�");
		System.out.println("=========================");
		for(Board brd : pageAry) {
			if(brd != null) {
				System.out.println(brd.showInfo());
			}
		}
		// ��ü������ ����ϰ� ���.
		int cnt = exe.getBoardCount();
		int totalpage = (int)Math.ceil(cnt/5.0);
		for(int i=1; i<=totalpage; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n�������� �����ϼ���>> ����:0 �Է�.");
	}
}//end class
