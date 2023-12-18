package p231214;

import java.sql.SQLIntegrityConstraintViolationException;
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
	static boolean main = true, account = true, login = true, myPage = true, fBoard = true;
	static Account user = null;

	public static void main(String[] args) {
		while (main) {
			main();
		}
	}// end of main.

	static String menu(String sc) { // �׽� �޴� ���� ���
		switch (sc) {
		case "����������":
			main = false; // ������ while���� ����
			myPage = false;
			main = true; // �Ʒ� while���� ���� �����ϱ����� �ٽ� ����
			while (main) {
				main();
			}
			break;
		case "ȸ������":
			main = false;
			myPage = false;
			main = true;
			while (main) {
				account();
			}
			break;
		case "�����Խ���":
			main = false;
			myPage = false;
			main = true;
			while (main) {
				fBoard();
			}
			break;
		case "�α���":
			if (user == null) {
				main = false;
				myPage = false;
				main = true;
				while (main) {
					login();
				}
			}
			break;
		case "����������":
			if (user != null) {
				main = false;
				myPage = false;
				main = true;
				while (main) {
					myPage();
				}
			}
			break;
		case "�α׾ƿ�":
			if (user != null) {
				main = false;
				myPage = false;
				main = true;
				while (main) {
					logout();
				}
			}
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
		System.out.print("    ���̵� : ");
		String acid = menu(sc.nextLine());
		System.out.print("    ��й�ȣ : ");
		String acpw = menu(sc.nextLine());
		System.out.print("    �г��� : ");
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
		System.out.print("    ���̵� : ");
		String id = menu(sc.nextLine());
		System.out.print("    ��й�ȣ : ");
		String password = menu(sc.nextLine());
		String nick = "";
		user = new Account(id, password, nick);
		if (bexe.checkUser(user)) {
			System.out.println("�α��� ����");
			main = false;
			myPage = false;
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
		main = false;
		myPage = false;
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
		;
		myPage = true;
		while (myPage) {
			if (modiinfo.equals("��������")) {
				System.out.printf("\n%40s����Ȯ���� ���� ���̵�� ��й�ȣ�� �Է����ּ���\n", "");
				System.out.printf("\n%40s���̵� : ", "");
				String id = menu(myMenu(sc.nextLine()));
				;
				System.out.printf("\n%40s��й�ȣ : ", "");
				String pw = menu(myMenu(sc.nextLine()));
				;
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
		int myPR = 1;
		System.out.println("\n        [��������]");
		System.out.printf("%66s<�Խó���>", "");
		System.out.println("\n       <[�Խó���]>");
		System.out.printf("%25s��ȣ\t  |%3s�з�%3s\t|%3s����%20s\t|%3s�ۼ���%9s\t|%3s��ȸ", "", "", "", "", "", "", "", "", "",
				"");
		System.out.printf(
				"\n        [ȸ��Ż��]%10s---------------------------------------------------------------------------------------------------",
				"");
		System.out.printf("%68s<%d>", "", myPR);
		String modiinfo = menu(myMenu(sc.nextLine()));
		;
	}

	static void unAccount() {

	}

	static void fBoard() {
		System.out.printf("%s  %s  %s  %s", "[����������]", "[ȸ������]", "[�����Խ���]", "[�α���]");
		System.out.printf("\n%7s\n\n", "�����Խ���");
		System.out.printf("  ��ȣ\t  |%3s�з�%3s\t|%3s����%37s\t|%3s�ۼ���%7s\t|%3s�ۼ���%9s\t|%3s��ȸ\n", "", "", "", "", "", "", "",
				"", "");
		ArrayList<Board> boardList = bexe.getBoardList();
		for (int L = (page * 10) - 10; L < boardList.size(); L++) {
			if (boardList.get(L) != null && L < page * 10) {
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------");
				boardList.get(L).showInfo();
			}
//		else if (boardList.isEmpty(bexe) == true) {
//		System.out.println("��ϵ� ���� �����ϴ�");
//	}
		}
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("  %-55s<%d>\n", "[�۾���]", page);
		String sel = sc.nextLine();
		switch (sel) {
		case ">":
			page++;
			break;
		case "<":
			page--;
			break;
		case "�۾���":
			boolean inid = true, subch = true;
			String idWord = "";
			while (inid) {
				System.out.print("�з��� �����ϼ���\n 1.���� 2.��� 3.���ǻ��� 4.��Ÿ : ");
				String board_id = sc.nextLine();
				switch (board_id) {
				case "1":
					idWord = "����";
					inid = false;
					break;
				case "2":
					idWord = "���";
					inid = false;
					break;
				case "3":
					idWord = "���ǻ���";
					inid = false;
					break;
				case "4":
					idWord = "��Ÿ";
					inid = false;
					break;
				default:
					System.out.println("�߸��� ���Դϴ�");
				}
			}
			System.out.printf("�з� : [%s]\n���� : ", idWord);
			String title = sc.nextLine();
			System.out.printf("�з� : [%s]\t���� : %s\n���� : ", idWord, title);
			String inside = sc.nextLine();
			while (subch) {
				System.out.printf("�з� : [%s]\t���� : %s\n���� : %s\n\n\n  [Ȯ��]  [���]\n", idWord, title, inside);
				String inside_submit = sc.nextLine();
				switch (inside_submit) {
				case "Ȯ��":
					int no = boardList.size() + 1;
					Date nowDate = new Date();
					SimpleDateFormat dForm = new SimpleDateFormat("yy-MM-dd");
					String date = dForm.format(nowDate);
					Board addB = new Board(no, idWord, title, inside, id, date, 0);
					if (bexe.addBoard(addB)) {
						boards.add(addB);
						System.out.println("��� �Ϸ�");
					} else {
						System.out.println("��� ����");
					}
					break;
				case "���":
					subch = false;
					break;
				default:
					System.out.println("'Ȯ��'�̳� '���'�� �Է��Ͻø� �˴ϴ�");
				}
			}
			break;
		case "x":
			System.out.println("�׽�Ʈ ����.");
			fBoard = false;
			break;
		default:

		}
	}
}
