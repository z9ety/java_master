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
		case "메인페이지":
			main();
			break;
		case "회원가입":
			account();
			break;
		case "로그인":
			login();
			break;
		case "마이페이지":
			myPage();
			break;
		case "자유게시판":
			fBoard();
			break;
		}
	}

	static void main() {
		System.out.printf("%s  %s  %s  %s  %s", "[메인페이지]", "[회원가입]", "[로그인]", "[마이페이지]", "[자유게시판]");
		System.out.printf("\n\n%20s\n\n=============================================\n", "메인 페이지");
		menu();
	}

	static void account() {
		System.out.printf("%s  %s  %s  %s  %s", "[메인페이지]", "[회원가입]", "[로그인]", "[마이페이지]", "[자유게시판]");
		System.out.printf("\n\n%20s\n\n=======================================\n", "회원가입");
		System.out.print("아이디 : ");
		menu(acid);
		System.out.print("비밀번호 : ");
		String acpw = sc.nextLine();
		Account newid = new Account(acid, acpw);
		if (bexe.addUser(newid)) {
			accs.add(newid);
			System.out.println("가입 완료");
		} else {
			System.out.println("가입 실패");
			menu();
		}
	}

	static void login() {
		System.out.printf("%s  %s  %s  %s", "[회원가입]", "[로그인]", "[마이페이지]", "[자유게시판]");
		System.out.printf("\n\n%20s\n\n=======================================\n", "로그인");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.println("로그인 성공");
		System.out.println("로그인 실패 : 아이디 혹은 비밀번호가 틀립니다.");
		switch (sc.nextLine()) {
		case "회원가입":
			account();
			break;
		case "로그인":
			login();
			break;
		case "마이페이지":
			myPage();
			break;
		case "자유게시판":
			fBoard();
			break;
		}
	}

	static void myPage() {
		System.out.printf("%s  %s  %s  %s", "[회원가입]", "[로그인]", "[마이페이지]", "[자유게시판]");
		System.out.printf("\n\n%20s\n\n=======================================\n", "메인 페이지");
		switch (sc.nextLine()) {
		case "회원가입":
			account();
			break;
		case "로그인":
			login();
			break;
		case "마이페이지":
			myPage();
			break;
		case "자유게시판":
			fBoard();
			break;
		}
	}

	static void fBoard() {
		System.out.printf("%s  %s  %s  %s", "[회원가입]", "[로그인]", "[마이페이지]", "[자유게시판]");
		System.out.printf("\n%7s\n\n", "자유게시판");
		System.out.printf("  번호\t  |%3s분류%3s\t|%3s제목%37s\t|%3s작성자%7s\t|%3s작성일%9s\t|%3s조회\n", "", "", "", "", "", "", "",
				"", "");
		ArrayList<Board> boardList = bexe.getBoardList();
		for (int L = (page * 10) - 10; L < boardList.size(); L++) {
			if (boardList.get(L) != null && L < page * 10) {
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------");
				boardList.get(L).showInfo();
			}
//		else if (boardList.isEmpty(bexe) == true) {
//		System.out.println("등록된 글이 없습니다");
//	}
		}
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("  %-55s<%d>\n", "[글쓰기]", page);
		String sel = sc.nextLine();
		switch (sel) {
		case ">":
			page++;
			break;
		case "<":
			page--;
			break;
		case "글쓰기":
			boolean inid = true, subch = true;
			String idWord = "";
			while (inid) {
				System.out.print("분류를 선택하세요\n 1.질문 2.잡담 3.건의사항 4.기타 : ");
				String board_id = sc.nextLine();
				switch (board_id) {
				case "1":
					idWord = "질문";
					inid = false;
					break;
				case "2":
					idWord = "잡담";
					inid = false;
					break;
				case "3":
					idWord = "건의사항";
					inid = false;
					break;
				case "4":
					idWord = "기타";
					inid = false;
					break;
				default:
					System.out.println("잘못된 값입니다");
				}
			}
			System.out.printf("분류 : [%s]\n제목 : ", idWord);
			String title = sc.nextLine();
			System.out.printf("분류 : [%s]\t제목 : %s\n내용 : ", idWord, title);
			String inside = sc.nextLine();
			while (subch) {
				System.out.printf("분류 : [%s]\t제목 : %s\n내용 : %s\n\n\n  [확인]  [취소]\n", idWord, title, inside);
				String inside_submit = sc.nextLine();
				switch (inside_submit) {
				case "확인":
					int no = boardList.size() + 1;
					Date nowDate = new Date();
					SimpleDateFormat dForm = new SimpleDateFormat("yy-MM-dd");
					String date = dForm.format(nowDate);
					Board addB = new Board(no, idWord, title, inside, id, date, 0);
					if (bexe.addBoard(addB)) {
						boards.add(addB);
						System.out.println("등록 완료");
					} else {
						System.out.println("등록 실패");
					}
					break;
				case "취소":
					subch = false;
					break;
				default:
					System.out.println("'확인'이나 '취소'를 입력하시면 됩니다");
				}
			}
			break;
		case "x":
			System.out.println("테스트 종료.");
			fBoard = false;
			break;
		default:

		}
		switch (sc.nextLine()) {
		case "회원가입":
			account();
			break;
		case "로그인":
			login();
			break;
		case "마이페이지":
			myPage();
			break;
		case "자유게시판":
			fBoard();
			break;
		}
	}
}
