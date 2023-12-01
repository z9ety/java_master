package chap6;

import java.util.Scanner;

//M(odel) V(iew) C(ontrol)
public class BoardApp {
//	public static BoardExe exe = new BoardExe();
	// �����͸��� �ٸ� ������ ���� �ʿ䰡 ���� Ŭ������ static��� ����.
	private Scanner sc = new Scanner(System.in);
	private String id = null;

	// �̱��� ����� �ν��Ͻ� ����.
	private static BoardApp instance = new BoardApp();

	// ������.
	private BoardApp() {

	}

	public static BoardApp getInstance() {
		return instance;
	}

	private void boardAdd() {
		System.out.print("���� : ");
		String title_ = sc.nextLine();
		System.out.print("���� : ");
		String txt_ = sc.nextLine();
		System.out.print("�ۼ��Ͻ� : ");
		String day_ = sc.nextLine();
		Board board = new Board(BoardExe.getSequence(), title_, id, txt_, day_);
		if (BoardExe.addBoard(board)) {
			System.out.println("��� ����!");
		} else {
			System.out.println("��� ����!");
		}
	}

	private void boardList() {
		Board[] boardAry = BoardExe.boardList();
		showList(boardAry, 1);
		while (true) {
			int page = Integer.parseInt(sc.nextLine());
			if (page == 0) {
				break;
			}
			showList(boardAry, page);
		}
	}

	private void getBoard() {
		int no = 0;
		while (true) {
			System.out.print("�۹�ȣ �Է�>>> ");
			try {
				no = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("�߸��� �Է�.");
			}
		}
		Board result = BoardExe.getBoard(no);
		if (result != null) {
			System.out.println(result.showDetailInfo());
		} else {
			System.out.println("��ȸ�� ������ �����ϴ�");
		}
	}

	private void boardEdit() {
		System.out.println("������ �۹�ȣ>>> ");
		int no = Integer.parseInt(sc.nextLine());
		if (!BoardExe.checkResponsibility(id, no)) {
			System.out.println("���Ѿ���");
			// continue;
			return;
		}
		System.out.println("������ �۳���>>> ");
		String txt_ = sc.nextLine();
		if (BoardExe.modBoard(no, txt_)) {
			System.out.println("���� ����!");
		} else {
			System.out.println("ó�� ����!");
		}
	}

	private void boardDel() {
		System.out.println("������ �۹�ȣ>>> ");
		int no = Integer.parseInt(sc.nextLine());
		if (!BoardExe.checkResponsibility(id, no)) {
			System.out.println("�������Ѿ���");
			// continue;
			return;
		}
		if (BoardExe.remBoard(no)) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
	}

	public void start() {
		boolean run = true;
//		Board[] arr = new Board[100];
//		int num_ = 0;
		//////////////////////////////////
		UserExe uexe = new UserExe();
		while (true) {
			System.out.print("id�� �Է�>>> ");
			id = sc.nextLine();
			System.out.print("pw�� �Է�>>> ");
			String pw = sc.nextLine();
			User user = uexe.logIn(id, pw);
			if (user != null) {
				System.out.println(user.getUserName() + "�� ȯ���մϴ�.");
				break;
			} else {
				System.out.println("id, pw Ȯ���ϼ���");
			}
		} // �α��� ó��.
			/////////////////////////////////
			// �ʱⰪ ����.
		BoardExe.initData();

		while (run) {
			System.out.println("1.��� 2.��� 3.����ȸ 4.���� 5.���� 6.����");
//			System.out.println("1.��� 2.��� 3.����ȸ 4.����");
			System.out.print("���� > ");
			//////////////////////////
			int sel = 0;
			try {
				sel = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("��Ȯ�� �޴��� �����ϼ���.");
				continue;
			}
			//////////////////////////
			switch (sel) {
			case 1: // �۵��.
				boardAdd();
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
			case 2: // ��Ϻ��� -> ����������.
				boardList();
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
				getBoard();
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
				boardEdit();
				break;
//				System.out.println("���α׷��� �����մϴ�.");
//				run = false;
			case 5:
				boardDel();
				break;
			case 6:
				System.out.println("���α׷��� �����մϴ�.");
				run = false;
			}
		}
	}// end main

	private void showList(Board[] boardAry, int page) {
		// ����¡ó��.
		Board[] pageAry = BoardExe.pageList(boardAry, page);
		System.out.println("�۹�ȣ ���� �ۼ��� �ۼ��Ͻ�");
		System.out.println("=========================");
		for (Board brd : pageAry) {
			if (brd != null) {
				System.out.println(brd.showInfo());
			}
		}
		// ��ü������ ����ϰ� ���.
		int cnt = BoardExe.getBoardCount();
		int totalpage = (int) Math.ceil(cnt / 5.0);
		for (int i = 1; i <= totalpage; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n�������� �����ϼ���>> ����:0 �Է�.");
	}
}// end class
