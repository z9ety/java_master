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
	static int myPR = 1;
	static boolean main = true, myPage = true, bidCh = true;
	static Account user = null;
	static ArrayList<Board> boardList = bexe.getBoardList();

	public static void main(String[] args) {
		while (main) {
			main();
		}
	}// end of main.

	static String menu(String sc) { // 항시 메뉴 선택 기능
		switch (sc) {
		case "메인페이지":
			main = false; // 이전의 while문을 종료
			myPage = false;
			main = true; // 아래 while문을 새로 실행하기위해 다시 지정
			while (main) {
				main();
			}
			break;
		case "회원가입":
			main = false;
			myPage = false;
			main = true;
			while (main) {
				account();
			}
			break;
		case "자유게시판":
			main = false;
			myPage = false;
			main = true;
			while (main) {
				fBoard();
			}
			break;
		case "로그인":
			if (user == null) {
				main = false;
				myPage = false;
				main = true;
				while (main) {
					login();
				}
			}
			break;
		case "마이페이지":
			if (user != null) {
				main = false;
				myPage = false;
				main = true;
				while (main) {
					myPage();
				}
			}
			break;
		case "로그아웃":
			if (user != null) {
				main = false;
				myPage = false;
				main = true;
				while (main) {
					logout();
				}
			}
			break;
		case "x":
			System.out.println("테스트 종료");
			main = false;
			myPage = false;
		} // end of switch.
		return sc;
	}

	static void main() {
		if (user == null) {
			System.out.printf("%s  %s  %s  %s", "[메인페이지]", "[회원가입]", "[자유게시판]", "[로그인]");
		} else {
			System.out.printf("%s  %s  %s  %s  %s  %s님 환영합니다", "[메인페이지]", "[회원가입]", "[자유게시판]", "[로그아웃]", "[마이페이지]",
					user.getUser_nick());
		}
		System.out.printf(
				"\n\n%50s\n\n=================================================================================================\n",
				"메인 페이지");
		System.out.println("메뉴를 입력하세요");
		menu(sc.nextLine());
	}

	static void account() {
		if (user == null) {
			System.out.printf("%s  %s  %s  %s", "[메인페이지]", "[회원가입]", "[자유게시판]", "[로그인]");
		} else {
			System.out.printf("%s  %s  %s  %s  %s  %s 님 환영합니다", "[메인페이지]", "[회원가입]", "[자유게시판]", "[로그아웃]", "[마이페이지]",
					user.getUser_nick());
		}
		System.out.printf("\n\n%20s\n\n======================================\n", "회원가입");
		System.out.print("    아이디 : ");
		String acid = menu(sc.nextLine());
		System.out.print("    비밀번호 : ");
		String acpw = menu(sc.nextLine());
		System.out.print("    닉네임 : ");
		String acnick = menu(sc.nextLine());
		Account newid = new Account(acid, acpw, acnick);
		if (bexe.addUser(newid)) {
			accs.add(newid);
			System.out.println("가입 완료");
			System.out.println("메뉴를 입력하세요");
			menu(sc.nextLine());
		} else {
			System.out.println("가입 실패 : 이미 존재하는 아이디입니다");
		}

	}

	static void login() {
		System.out.printf("%s  %s  %s  %s", "[메인페이지]", "[회원가입]", "[자유게시판]", "[로그인]");
		System.out.printf("\n\n%20s\n\n======================================\n", "로그인");
		System.out.print("\n    아이디 : ");
		String id = menu(sc.nextLine());
		System.out.print("\n    비밀번호 : ");
		String password = menu(sc.nextLine());
		String nick = "";
		user = new Account(id, password, nick);
		if (bexe.checkUser(user)) {
			System.out.println("로그인 성공");
			main = false;
			myPage = false;
			main = true;
			while (main) {
				main();
			}
		} else {
			System.out.println("로그인 실패 : 아이디 혹은 비밀번호가 틀립니다.");
		}
	}

	static void logout() {
		user = null;
		System.out.println("로그아웃 되었습니다");
		main = false;
		myPage = false;
		main = true;
		while (main) {
			main();
		}
	}

	static void myPageHead() {
		System.out.printf("%s  %s  %s  %s  %s  %s님 환영합니다", "[메인페이지]", "[회원가입]", "[자유게시판]", "[로그아웃]", "[마이페이지]",
				user.getUser_nick());
		System.out.printf(
				"\n\n%62s\n\n==========================================================================================================================\n",
				"마이페이지");
	}

	static void myPage() {
		myPageHead();
		System.out.println("\n\n        [개인정보]");
		System.out.printf("%40s마이페이지에서는 개인정보 확인 및 수정, 게시내역을 볼 수 있습니다.", "");
		System.out.println("\n        [게시내역]");
		System.out.printf("%40s좌측 메뉴를 입력해주세요", "");
		System.out.println("\n        [회원탈퇴]");
		menu(myMenu(sc.nextLine()));
	}

	static String myMenu(String sc) {
		switch (sc) {
		case "개인정보":
			main = false;
			myPage = false;
			main = true;
			while (main) {
				myPageHead();
				userInfo();
			}
			break;
		case "게시내역":
			myPR = 1;
			main = false;
			myPage = false;
			main = true;
			while (main) {
				myPageHead();
				boardRecord();
			}
			break;
		case "회원탈퇴":
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
		System.out.println("\n\n       <[개인정보]>");
		System.out.printf("%66s<개인정보>", "");
		System.out.println("\n        [게시내역]");
		System.out.printf("%40s아이디 : %s", "", user.getUser_id());
		System.out.println("\n        [회원탈퇴]");
		System.out.printf("%40s비밀번호 : ", "");
		for (int i = 1; i <= user.getUser_pw().length(); i++) {
			System.out.print("*");
		}
		System.out.println("\n");
		System.out.printf("%40s닉네임 : %s", "", user.getUser_nick());
		System.out.printf("\n\n%66s[정보수정]\n", "");
		String modiinfo = menu(myMenu(sc.nextLine()));
		myPage = true;
		while (myPage) {
			if (modiinfo.equals("정보수정")) {
				System.out.printf("\n%40s본인확인을 위해 아이디와 비밀번호를 입력해주세요\n", "");
				System.out.printf("\n%40s아이디 : ", "");
				String id = menu(myMenu(sc.nextLine()));
				System.out.printf("\n%40s비밀번호 : ", "");
				String pw = menu(myMenu(sc.nextLine()));
				if (user.getUser_id().equals(id) && user.getUser_pw().equals(pw)) {
					System.out.println("인증 완료");
					System.out.printf("\n%40s<정보수정>", "");
					System.out.printf("\n\n%40s수정할 정보를 입력해주세요\n", "");
					System.out.printf("\n%40s", "");
					String modsel = menu(myMenu(sc.nextLine()));
					;
					System.out.printf("%40s: ", "");
					String modiSt = menu(myMenu(sc.nextLine()));
					;
					switch (modsel) {
					case "아이디":
						if (bexe.modifyID(user.getUser_id(), modiSt)) {
							System.out.println("수정 완료");
							user.setUser_id(modiSt);
							myPage = false;
						} else {
							System.out.println("오류 발생");
						}
						break;
					case "비밀번호":
						if (bexe.modifyPW(user.getUser_pw(), modiSt)) {
							System.out.println("수정 완료");
							user.setUser_pw(modiSt);
							myPage = false;
						} else {
							System.out.println("오류 발생");
						}
						break;
					case "닉네임":
						if (bexe.modifyNN(user.getUser_nick(), modiSt)) {
							System.out.println("수정 완료");
							user.setUser_nick(modiSt);
							myPage = false;
						} else {
							System.out.println("오류 발생");
						}
					}
				} else {
					System.out.println("인증에 실패하셨습니다 다시 시도해주세요");
				}
			}
		}
	}

	static void boardRecord() {
		System.out.println("\n\n        [개인정보]");
		System.out.printf("%69s<게시내역>", "");
		System.out.println("\n       <[게시내역]>");
		System.out.printf("\n        [회원탈퇴]%15s번호%3s|%3s분류%3s\t|%3s제목%20s\t|%3s작성일%9s\t|%3s조회\n", "", "", "", "", "",
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
			System.out.printf("\n%65s등록된 글이 없습니다\n", "");
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
		System.out.println("\n\n        [개인정보]");
		System.out.printf("%66s<회원탈퇴>", "");
		System.out.println("\n        [게시내역]");
		System.out.printf("%40s본인확인을 위해 아이디와 비밀번호를 입력해주세요", "");
		System.out.printf("\n       <[회원탈퇴]>", "");
		System.out.printf("\n%40s아이디 : ", "");
		String id = menu(myMenu(sc.nextLine()));
		System.out.printf("\n%40s비밀번호 : ", "");
		String pw = menu(myMenu(sc.nextLine()));
		if (user.getUser_id().equals(id) && user.getUser_pw().equals(pw)) {
			System.out.println("정말로 탈퇴하시겠습니까? [네]/[아니오]");
			String yn = menu(myMenu(sc.nextLine()));
			switch (yn) {
			case "네":
				bexe.deleteAccount(user.getUser_id());
				user = null;
				System.out.println("회원탈퇴 되었습니다");
				main = false;
				myPage = false;
				main = true;
				while (main) {
					main();
				}
				break;
			case "아니오":
				System.out.println("취소되었습니다");
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
		System.out.printf("%s  %s  %s  %s", "[메인페이지]", "[회원가입]", "[자유게시판]", "[로그인]");
		System.out.printf("\n%7s\n\n", "자유게시판");
		System.out.println(
				"==========================================================================================================================\n");
		System.out.printf("  번호\t  |%3s분류%3s\t|%3s제목%37s\t|%3s작성자%7s\t|%3s작성일%9s\t|%3s조회\n", "", "", "", "", "", "", "",
				"", "");
		for (int L = (page * 10) - 10; L < boardList.size(); L++) {
			if (boardList.get(L) != null && L < page * 10) {
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------");
				boardList.get(L).showInfo();
			}
		}
		if (boardList.size() == 0) {
			System.out.println("등록된 글이 없습니다");
		}
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("  %-55s<%d>\n", "[글쓰기]", page);
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
		case "글쓰기":
			if (user == null) {
				System.out.println("로그인이 필요합니다");
				break;
			} else {
				main = false;
				main = true;
				while (main) {
					board_Output();
					System.out.print("%15[분류]\n[1]질문 [2]잡담 [3]건의사항 [4]기타 \n :");
					String idWord = menu(sc.nextLine());
					board_idSel(idWord);
					if (idWord.equals("질문") || idWord.equals("잡담") || idWord.equals("건의사항") || idWord.equals("기타")) {
						System.out.print("[내용] : ");
						String inside = menu(sc.nextLine());
						System.out.printf("[확인]  [취소]\n", idWord, title, inside);
						String inside_submit = menu(sc.nextLine());
						switch (inside_submit) {
						case "확인":
							int no = boardList.size() + 1;
							Date nowDate = new Date();
							SimpleDateFormat dForm = new SimpleDateFormat("yy-MM-dd");
							String date = dForm.format(nowDate);
							Board addB = new Board(no, idWord, title, inside, user.getUser_nick(), date, 0);
							if (bexe.addBoard(addB)) {
								boards.add(addB);
								System.out.println("등록 완료");
							} else {
								System.out.println("등록 실패");
							}
							break;
						case "취소":

							break;
						}
					}
				}
			}
		}
	}// end of fBoard.

	static String board_idSel(String bi) {
		switch (bi) {
		case "1":
			return "질문";
		case "2":
			return "잡담";
		case "3":
			return "건의사항";
		case "4":
			return "기타";
		}
		return null;
	}

	static String board_title(String bt) {

	}

	static void board_Output() {
		System.out.printf("%s  %s  %s  %s", "[메인페이지]", "[회원가입]", "[자유게시판]", "[로그인]");
		System.out.printf("\n%7s\n\n", "자유게시판");
		System.out.println(
				"==========================================================================================================================\n");
		System.out.printf("%15s┌─────────────┐\n", "");
		System.out.printf("%15s│  <%s>│\n", "", "");
		System.out.printf("%15s└─────────────┘\n\n", "");
		System.out.printf(
				"%15s┌─────────┬──────────────────────────────────────────────────────────────────────────────────┐\n",
				"");
		System.out.printf("%15s│ %s│\n", "", "a");
		System.out.printf(
				"%15s└─────────┴──────────────────────────────────────────────────────────────────────────────────┘\n\n",
				"");
		System.out.printf(
				"%15s┌────────────────────────────────────────────────────────────────────────────────────────────────────┐\n",
				"");
		System.out.printf("%15s│%100s│\n", "", "a");
		System.out.printf("%15s│%100s│\n", "", "a");
		System.out.printf("%15s│%100s│\n", "", "a");
		System.out.printf("%15s│%100s│\n", "", "a");
		System.out.printf("%15s│%100s│\n", "", "a");
		System.out.printf("%15s│%100s│\n", "", "a");
		System.out.printf("%15s│%100s│\n", "", "a");
		System.out.printf("%15s│%100s│\n", "", "a");
		System.out.printf("%15s│%100s│\n", "", "a");
		System.out.printf("%15s│%100s│\n", "", "a");
		System.out.printf(
				"%15s└────────────────────────────────────────────────────────────────────────────────────────────────────┘\n\n",
				"");
	}
}// end of class.
