package p231214;

import java.text.SimpleDateFormat;
import java.util.*;

public class BoardApp {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Board> boards = new ArrayList<Board>();
	static ArrayList<Account> accs = new ArrayList<Account>();
	static BoardExe bexe = new BoardExe();
	static int page = 1;
	static boolean main = true, account = true, login = true, myPage = true, fBoard = true;

	public static void main(String[] args) {
		while (main) {
			main();
		}
	}// end of main.

	static void menu(String sc) {
		switch (sc.nextLine()) {
		case "����������":
			main();
			break;
		case "ȸ������":
			account();
			break;
		case "�α���":
			login();
			break;
		case "����������":
			myPage();
			break;
		case "�����Խ���":
			fBoard();
			break;
		}
	}

	static void main() {
		System.out.printf("%s  %s  %s  %s  %s", "[����������]", "[ȸ������]", "[�α���]", "[����������]", "[�����Խ���]");
		System.out.printf("\n\n%20s\n\n=============================================\n", "���� ������");
		menu();
	}

	static void account() {
		System.out.printf("%s  %s  %s  %s  %s", "[����������]", "[ȸ������]", "[�α���]", "[����������]", "[�����Խ���]");
		System.out.printf("\n\n%20s\n\n=======================================\n", "ȸ������");
		System.out.print("���̵� : ");
		menu(acid);
		System.out.print("��й�ȣ : ");
		String acpw = sc.nextLine();
		Account newid = new Account(acid, acpw);
		if (bexe.addUser(newid)) {
			accs.add(newid);
			System.out.println("���� �Ϸ�");
		} else {
			System.out.println("���� ����");
			menu();
		}
	}

	static void login() {
		System.out.printf("%s  %s  %s  %s", "[ȸ������]", "[�α���]", "[����������]", "[�����Խ���]");
		System.out.printf("\n\n%20s\n\n=======================================\n", "�α���");
		System.out.print("���̵� : ");
		String id = sc.nextLine();
		System.out.print("��й�ȣ : ");
		String password = sc.nextLine();
		System.out.println("�α��� ����");
		System.out.println("�α��� ���� : ���̵� Ȥ�� ��й�ȣ�� Ʋ���ϴ�.");
		switch (sc.nextLine()) {
		case "ȸ������":
			account();
			break;
		case "�α���":
			login();
			break;
		case "����������":
			myPage();
			break;
		case "�����Խ���":
			fBoard();
			break;
		}
	}

	static void myPage() {
		System.out.printf("%s  %s  %s  %s", "[ȸ������]", "[�α���]", "[����������]", "[�����Խ���]");
		System.out.printf("\n\n%20s\n\n=======================================\n", "���� ������");
		switch (sc.nextLine()) {
		case "ȸ������":
			account();
			break;
		case "�α���":
			login();
			break;
		case "����������":
			myPage();
			break;
		case "�����Խ���":
			fBoard();
			break;
		}
	}

	static void fBoard() {
		System.out.printf("%s  %s  %s  %s", "[ȸ������]", "[�α���]", "[����������]", "[�����Խ���]");
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
		switch (sc.nextLine()) {
		case "ȸ������":
			account();
			break;
		case "�α���":
			login();
			break;
		case "����������":
			myPage();
			break;
		case "�����Խ���":
			fBoard();
			break;
		}
	}
}
