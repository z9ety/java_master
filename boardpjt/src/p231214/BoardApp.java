package p231214;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BoardApp {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Board> boards = new ArrayList<Board>();
	static ArrayList<Account> accs = new ArrayList<Account>();
	static BoardExe bexe = new BoardExe();
	static int page = 1;
	static int myPR = 1;
	static boolean main = true, myPage = true, inroof = true;
	static Account user = null;

	static Board addB = new Board(0, "", "", "", "", "", 0);

	public static void main(String[] args) {
		while (main) {
			main();
		}
	}// end of main.

	static String menu(String sc) { // �׽� �޴� ���� ���
		switch (sc) {
		case "����������":
			inside = null;
			myPage = false;
			inroof = false;
			main = false; // ������ while���� ����
			main = true; // �Ʒ� while���� ���� �����ϱ����� �ٽ� ����
			while (main) {
				main();
			}
			break;
		case "ȸ������":
			inside = null;
			myPage = false;
			inroof = false;
			main = false;
			main = true;
			while (main) {
				account();
			}
			break;
		case "�����Խ���":
			inside = null;
			myPage = false;
			inroof = false;
			main = false;
			main = true;
			while (main) {
				fBoard();
			}
			break;
		case "�α���":
			if (user == null) {
				main = false;
				main = true;
				while (main) {
					login();
				}
			}
			break;
		case "����������":
			if (user != null) {
				inside = null;
				myPage = false;
				inroof = false;
				main = false;
				main = true;
				while (main) {
					myPage();
				}
			}
			break;
		case "�α׾ƿ�":
			if (user != null) {
				inside = null;
				myPage = false;
				inroof = false;
				main = false;
				main = true;
				while (main) {
					logout();
				}
			}
			break;
		case "endsys;":
			System.out.println("�׽�Ʈ ����");
			myPage = false;
			inroof = false;
			main = false;
		} // end of switch.
		return sc;
	}

	static void main() {
		if (user == null) {
			System.out.printf("%s  %s  %s  %s", "[����������]", "[ȸ������]", "[�����Խ���]", "[�α���]");
		} else {
			System.out.printf("%s  %s  %s  %s  %s  %s�� ȯ���մϴ�", "[����������]", "[ȸ������]", "[�����Խ���]", "[�α׾ƿ�]", "[����������]",
					user.getUser_nick());
		}
		System.out.printf(
				"\n\n%50s\n\n=================================================================================================\n",
				"���� ������");
		System.out.println("�޴��� �Է��ϼ���");
		menu(sc.nextLine());
	}

	static void account() {
		if (user == null) {
			System.out.printf("%s  %s  %s  %s", "[����������]", "[ȸ������]", "[�����Խ���]", "[�α���]");
		} else {
			System.out.printf("%s  %s  %s  %s  %s  %s �� ȯ���մϴ�", "[����������]", "[ȸ������]", "[�����Խ���]", "[�α׾ƿ�]", "[����������]",
					user.getUser_nick());
		}
		System.out.printf("\n\n%20s\n\n======================================\n", "ȸ������");
		System.out.print("\n    ���̵� : ");
		String acid = menu(sc.nextLine());
		System.out.print("\n    ��й�ȣ : ");
		String acpw = menu(sc.nextLine());
		System.out.print("\n    �г��� : ");
		String acnick = menu(sc.nextLine());
		Account newid = new Account(acid, acpw, acnick);
		if (bexe.addUser(newid)) {
			accs.add(newid);
			System.out.println("���� �Ϸ�");
			System.out.println("�޴��� �Է��ϼ���");
			menu(sc.nextLine());
		} else {
			System.out.println("���� ���� : �̹� �����ϴ� ���̵��Դϴ�");
		}

	}

	static void login() {
		System.out.printf("%s  %s  %s  %s", "[����������]", "[ȸ������]", "[�����Խ���]", "[�α���]");
		System.out.printf("\n\n%20s\n\n======================================\n", "�α���");
		System.out.print("\n    ���̵� : ");
		String id = menu(sc.nextLine());
		System.out.print("\n    ��й�ȣ : ");
		String password = menu(sc.nextLine());
		String nick = "";
		user = new Account(id, password, nick);
		if (bexe.checkUser(user)) {
			System.out.println("�α��� ����");
			main = false;
			main = true;
			while (main) {
				main();
			}
		} else {
			System.out.println("�α��� ���� : ���̵� Ȥ�� ��й�ȣ�� Ʋ���ϴ�.");
		}
	}

	static void logout() {
		user = null;
		System.out.println("�α׾ƿ� �Ǿ����ϴ�");
		myPage = false;
		inroof = false;
		main = false;
		main = true;
		while (main) {
			main();
		}
	}

	static void myPageHead() {
		System.out.printf("%s  %s  %s  %s  %s  %s�� ȯ���մϴ�", "[����������]", "[ȸ������]", "[�����Խ���]", "[�α׾ƿ�]", "[����������]",
				user.getUser_nick());
		System.out.printf(
				"\n\n%62s\n\n==========================================================================================================================\n",
				"����������");
	}

	static void myPage() {
		myPageHead();
		System.out.println("\n\n        [��������]");
		System.out.printf("%40s���������������� �������� Ȯ�� �� ����, �Խó����� �� �� �ֽ��ϴ�.", "");
		System.out.println("\n        [�Խó���]");
		System.out.printf("%40s���� �޴��� �Է����ּ���", "");
		System.out.println("\n        [ȸ��Ż��]");
		menu(myMenu(sc.nextLine()));
	}

	static String myMenu(String sc) {
		switch (sc) {
		case "��������":
			main = false;
			myPage = false;
			main = true;
			while (main) {
				myPageHead();
				userInfo();
			}
			break;
		case "�Խó���":
			myPR = 1;
			main = false;
			myPage = false;
			main = true;
			while (main) {
				myPageHead();
				boardRecord();
			}
			break;
		case "ȸ��Ż��":
			main = false;
			myPage = false;
			main = true;
			while (main) {
				myPageHead();
				unAccount();
			}
		}
		return sc;
	}

	static void userInfo() {
		System.out.println("\n\n       <[��������]>");
		System.out.printf("%66s<��������>", "");
		System.out.println("\n        [�Խó���]");
		System.out.printf("%40s���̵� : %s", "", user.getUser_id());
		System.out.println("\n        [ȸ��Ż��]");
		System.out.printf("%40s��й�ȣ : ", "");
		for (int i = 1; i <= user.getUser_pw().length(); i++) {
			System.out.print("*");
		}
		System.out.println("\n");
		System.out.printf("%40s�г��� : %s", "", user.getUser_nick());
		System.out.printf("\n\n%66s[��������]\n", "");
		String modiinfo = menu(myMenu(sc.nextLine()));
		myPage = true;
		while (myPage) {
			if (modiinfo.equals("��������")) {
				System.out.printf("\n%40s����Ȯ���� ���� ���̵�� ��й�ȣ�� �Է����ּ���\n", "");
				System.out.printf("\n%40s���̵� : ", "");
				String id = menu(myMenu(sc.nextLine()));
				System.out.printf("\n%40s��й�ȣ : ", "");
				String pw = menu(myMenu(sc.nextLine()));
				if (user.getUser_id().equals(id) && user.getUser_pw().equals(pw)) {
					System.out.println("���� �Ϸ�");
					System.out.printf("\n%40s<��������>", "");
					System.out.printf("\n\n%40s������ ������ �Է����ּ���\n", "");
					System.out.printf("\n%40s", "");
					String modsel = menu(myMenu(sc.nextLine()));
					;
					System.out.printf("%40s: ", "");
					String modiSt = menu(myMenu(sc.nextLine()));
					;
					switch (modsel) {
					case "���̵�":
						if (bexe.modifyID(user.getUser_id(), modiSt)) {
							System.out.println("���� �Ϸ�");
							user.setUser_id(modiSt);
							myPage = false;
						} else {
							System.out.println("���� �߻�");
						}
						break;
					case "��й�ȣ":
						if (bexe.modifyPW(user.getUser_pw(), modiSt)) {
							System.out.println("���� �Ϸ�");
							user.setUser_pw(modiSt);
							myPage = false;
						} else {
							System.out.println("���� �߻�");
						}
						break;
					case "�г���":
						if (bexe.modifyNN(user.getUser_nick(), modiSt)) {
							System.out.println("���� �Ϸ�");
							user.setUser_nick(modiSt);
							myPage = false;
						} else {
							System.out.println("���� �߻�");
						}
					}
				} else {
					System.out.println("������ �����ϼ̽��ϴ� �ٽ� �õ����ּ���");
				}
			}
		}
	}

	static void boardRecord() {
		System.out.println("\n\n        [��������]");
		System.out.printf("%69s<�Խó���>", "");
		System.out.println("\n       <[�Խó���]>");
		System.out.printf("\n        [ȸ��Ż��]%15s��ȣ%3s|%3s�з�%3s\t|%3s����%20s\t|%3s�ۼ���%9s\t|%3s��ȸ\n", "", "", "", "", "",
				"", "", "", "", "", "", "");
		ArrayList<Board> recordList = bexe.getUserBoardRecord(user.getUser_nick());
		for (int L = (myPR * 10) - 10; L < recordList.size(); L++) {
			if (recordList.get(L) != null && L < myPR * 10) {
				System.out.printf(
						"%29s----------------------------------------------------------------------------------------\n",
						"");
				recordList.get(L).showReco();
			}
		}

		System.out.printf(
				"%29s----------------------------------------------------------------------------------------\n", "");
		if (recordList.size() == 0) {
			System.out.printf("\n%65s��ϵ� ���� �����ϴ�\n", "");
		}
		System.out.println("\n");
		System.out.printf("\n%71s<%d>\n", "", myPR);
		String recPage = menu(myMenu(sc.nextLine()));
		switch (recPage) {
		case ">":
			if (myPR * 10 < recordList.size())
				myPR++;
			break;
		case "<":
			if (myPR > 1)
				myPR--;
		}
	}

	static void unAccount() {
		System.out.println("\n\n        [��������]");
		System.out.printf("%66s<ȸ��Ż��>", "");
		System.out.println("\n        [�Խó���]");
		System.out.printf("%40s����Ȯ���� ���� ���̵�� ��й�ȣ�� �Է����ּ���", "");
		System.out.printf("\n       <[ȸ��Ż��]>", "");
		System.out.printf("\n%40s���̵� : ", "");
		String id = menu(myMenu(sc.nextLine()));
		System.out.printf("\n%40s��й�ȣ : ", "");
		String pw = menu(myMenu(sc.nextLine()));
		if (user.getUser_id().equals(id) && user.getUser_pw().equals(pw)) {
			System.out.println("������ Ż���Ͻðڽ��ϱ�? [��]/[�ƴϿ�]");
			String yn = menu(myMenu(sc.nextLine()));
			switch (yn) {
			case "��":
				bexe.deleteAccount(user.getUser_id());
				user = null;
				System.out.println("ȸ��Ż�� �Ǿ����ϴ�");
				main = false;
				myPage = false;
				main = true;
				while (main) {
					main();
				}
				break;
			case "�ƴϿ�":
				System.out.println("��ҵǾ����ϴ�");
				main = false;
				myPage = false;
				main = true;
				while (main) {
					myPage();
				}
			}
		}
	}

	static void fBoard() {
		ArrayList<Board> boardList = bexe.getBoardList();
		System.out.printf("%s  %s  %s  %s", "[����������]", "[ȸ������]", "[�����Խ���]", "[�α���]");
		System.out.printf("\n\n%61s\n\n", "�����Խ���");
		System.out.println(
				"==========================================================================================================================");
		System.out.printf("  ��ȣ\t  |%3s�з�%3s\t|%3s����%37s\t|%3s�ۼ���%7s\t|%3s�ۼ���%9s\t|%3s��ȸ\n", "", "", "", "", "", "", "",
				"", "");
		for (int L = (page * 10) - 10; L < boardList.size(); L++) {
			if (boardList.get(L) != null && L < page * 10) {
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------");
				boardList.get(L).showInfo();
			}
		}
		if (boardList.size() == 0) {
			System.out.printf("\n%52s��ϵ� ���� �����ϴ�\n\n", "");
		}
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("  %-55s<%d>\n", "[�۾���]", page);
		String sel = menu(sc.nextLine());
		switch (sel) {
		case ">":
			if (page * 10 <= boardList.size())
				page++;
			break;
		case "<":
			if (page > 1)
				page--;
			break;
		case "�۾���":
			if (user == null) {
				System.out.println("�α����� �ʿ��մϴ�");
				break;
			} else {
				main = false;
				main = true;
				while (main) {
					board_Output(addB.getBd_id(), addB.getBd_title(), inside);
					menu(insideMenu(sc.nextLine()));
				}
			}
		}
	}// end of fBoard.

	static String insideMenu(String sc) {
		switch (sc) {
		case "�з�":
			inroof = false;
			board_idSel(addB.getBd_id());
			break;
		case "����":
			inroof = false;
			board_title(addB.getBd_title());
			break;
		case "����":
			inroof = false;
			board_inside();
			break;
		case ";":
			inroof = false;
			main = false;
			main = true;
			Date nowDate = new Date();
			SimpleDateFormat dForm = new SimpleDateFormat("yy-MM-dd");
			String date = dForm.format(nowDate);
			String inside1 = "";
			for (int i = 0; i < inside.size(); i++) {
				inside1 += inside.get(i) + "\n";
			}
			addB.setBd_inside(inside1);
			addB.setBd_date(date);
			addB.setBd_writer(user.getUser_nick());
			addB.setBd_no(boards.size() + 1);
			if (bexe.addBoard(addB)) {
				boards.add(addB);
				System.out.println("��� �Ϸ�");
			} else {
				System.out.println("��� ����");
			}
			inside = null;
			while (main) {
				fBoard();
			}
			break;
		case "x":
			System.out.println("����Ͽ����ϴ�");
			inside = null;
			inroof = false;
			main = false;
			main = true;
			while (main) {
				fBoard();
			}
		}
		return sc;
	}

	static String board_idSel(String id) {
		System.out.print("%15[1]���� [2]��� [3]���ǻ��� [4]��Ÿ \n :");
		String idWord = menu(insideMenu(sc.nextLine()));
		switch (idWord) {
		case "1":
			return "����";
		case "2":
			return "���";
		case "3":
			return "���ǻ���";
		case "4":
			return "��Ÿ";
		}
		return "";
	}

	static String board_title(String bt) {
		System.out.print("[����] : ");
		String title = menu(insideMenu(sc.nextLine()));
		return title;
	}

	static ArrayList<String> inside = null;

	static void board_inside() {
		int inleng = 0;
		main = false;
		main = true;
		System.out.print("[����] : ");
		for (int i = 0; i < inside.size(); i++) {
			System.out.println(inside.get(i));
		}
		while (inroof) {
			String isroof = menu(insideMenu(sc.nextLine()));
			inleng += isroof.length();
			if (inleng < 1000) {
				inside.add(isroof);
			}
			if (inleng >= 1000) {
				System.out.println("������ 1000�ڸ� ���� �� �����ϴ�");
				inleng -= isroof.length();
			}
		}
	}

	static void board_Output(String id, String title, ArrayList<String> ins) {
		System.out.printf("%s  %s  %s  %s", "[����������]", "[ȸ������]", "[�����Խ���]", "[�α���]");
		System.out.printf("\n\n%61s\n\n", "�����Խ���");
		System.out.println(
				"==========================================================================================================================\n");
		System.out.printf("%60s<�۾���>\n\n", "");
		System.out.printf("%10s����������������������������������������\n", "");
		System.out.printf("%10s����[�з�] ��<%s>��\n", "", id);
		System.out.printf("%10s����������������������������������������\n\n", "");
		System.out.printf(
				"%10s��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n",
				"");
		System.out.printf("%10s�� ��[����]  ��%s��\n", "", title);
		System.out.printf(
				"%10s��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n\n",
				"");
		System.out.printf("%12s[����]\n", "");
		System.out.printf(
				"%10s������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n",
				"");
		if (inside != null) {
			for (int i = 0; i < inside.size(); i++) {
				System.out.printf("%10s��%100s��\n", "", inside.get(i));
			}
		}
		System.out.printf(
				"%10s������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������\n\n",
				"");
		System.out.printf("%55sȮ��[;]%3s���[x]\n\n", "", "");
	}
}// end of class.