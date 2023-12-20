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
	static ArrayList<String> inside = new ArrayList<String>();

	public static void main(String[] args) {
//		user = new Account("ㅁㅁㅁ", "123", "관리자");
		while (main) {
			mainp();
//			fBoard();
		}
	}// end of main.

	static String menu(String sc) { // 항시 메뉴 선택 기능
		switch (sc) {
		case "메인페이지":
			inside = new ArrayList<String>();
			myPage = false;
			inroof = false;
			main = false; // 이전의 while문을 종료
			main = true; // 아래 while문을 새로 실행하기위해 다시 지정
			while (main) {
				mainp();
			}
			break;
		case "회원가입":
			inside = new ArrayList<String>();
			myPage = false;
			inroof = false;
			main = false;
			main = true;
			while (main) {
				account();
			}
			break;
		case "자유게시판":
			inside = new ArrayList<String>();
			myPage = false;
			inroof = false;
			main = false;
			main = true;
			while (main) {
				fBoard();
			}
			break;
		case "로그인":
			if (user == null) {
				main = false;
				main = true;
				while (main) {
					login();
				}
			}
			break;
		case "마이페이지":
			if (user != null) {
				inside = new ArrayList<String>();
				myPage = false;
				inroof = false;
				main = false;
				main = true;
				while (main) {
					myPage();
				}
			}
			break;
		case "로그아웃":
			if (user != null) {
				inside = new ArrayList<String>();
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
			System.out.println("테스트 종료");
			myPage = false;
			inroof = false;
			main = false;
		} // end of switch.
		return sc;
	}

	static void mainp() {
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
			System.out.printf("%s  %s  %s  %s  %s  %s님 환영합니다", "[메인페이지]", "[회원가입]", "[자유게시판]", "[로그아웃]", "[마이페이지]",
					user.getUser_nick());
		}
		System.out.printf("\n\n%20s\n\n======================================\n", "회원가입");
		System.out.print("\n    아이디 : ");
		String acid = menu(sc.nextLine());
		System.out.print("\n    비밀번호 : ");
		String acpw = menu(sc.nextLine());
		System.out.print("\n    닉네임 : ");
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
		user = new Account(id, password, "");
		if (bexe.checkUser(user)) {
			System.out.println("로그인 성공");
			main = false;
			main = true;
			while (main) {
				mainp();
			}
		} else {
			System.out.println("로그인 실패 : 아이디 혹은 비밀번호가 틀립니다.");
		}
	}

	static void logout() {
		user = null;
		System.out.println("로그아웃 되었습니다");
		myPage = false;
		inroof = false;
		main = false;
		main = true;
		while (main) {
			mainp();
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
					mainp();
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
		ArrayList<Board> boardList = bexe.getBoardList();
		if (user == null) {
			System.out.printf("%s  %s  %s  %s", "[메인페이지]", "[회원가입]", "[자유게시판]", "[로그인]");
		} else {
			System.out.printf("%s  %s  %s  %s  %s  %s님 환영합니다", "[메인페이지]", "[회원가입]", "[자유게시판]", "[로그아웃]", "[마이페이지]",
					user.getUser_nick());
		}
		System.out.printf("\n\n%61s\n\n", "자유게시판");
		System.out.println(
				"==========================================================================================================================");
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
			System.out.printf("\n%52s등록된 글이 없습니다\n\n", "");
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
					board_Output(addB.getBd_id(), addB.getBd_title(), addB.getBd_inside());
					menu(insideMenu(sc.nextLine()));
				}
			}
		default:
//				for(int i=0; i<boardList.size();i++) {
//					if(boardList.get(i).getBd_no() == sel) {
//						
//					}
//					
//				}
		}
	}// end of fBoard.

	static String insideMenu(String scn) {
		switch (scn) {
		case "분류":
			inroof = false;
			System.out.printf("%10s[1]질문 [2]잡담 [3]건의사항 [4]기타 : ", "", "");
			String idWord = menu(insideMenu(sc.nextLine()));
			switch (idWord) {
			case "1":
				scn = "질문";
				break;
			case "2":
				scn = "잡담";
				break;
			case "3":
				scn = "건의사항";
				break;
			case "4":
				scn = "기타";
			}
			addB.setBd_id(scn);
			break;
		case "제목":
			inroof = false;
			System.out.printf("%10s[제목] : ", "");
			String title = menu(insideMenu(sc.nextLine()));
			addB.setBd_title(title);
			break;
		case "내용":
			inroof = false;
			int inleng = 0;
			if (inside != null) {
				for (int i = 0; i < inside.size(); i++) {
					System.out.println(inside.get(i));
				}
			}
			main = false;
			main = true;
			System.out.printf("%10s[내용] : ", "");
			inroof = true;
			while (inroof) {
				String isroof = menu(insideMenu(sc.nextLine()));
				System.out.printf("%15s　　", "");
				inleng += isroof.length();
				if (inleng < 1000) {
					inside.add(isroof);
				}
				if (inleng >= 1000) {
					System.out.println("내용은 1000자를 넘을 수 없습니다");
					inleng -= isroof.length();
				}
			}
			break;
		case ";":
			inroof = false;
			main = false;
			main = true;
			Date nowDate = new Date();
			SimpleDateFormat dForm = new SimpleDateFormat("yy-MM-dd");
			String date = dForm.format(nowDate);
			String inside1 = "";
			ArrayList<Board> boardList = bexe.getBoardList();
			for (int i = 0; i < inside.size(); i++) {
				inside1 += inside.get(i) + "\n";
			}
			addB.setBd_inside(inside1);
			addB.setBd_date(date);
			addB.setBd_writer(user.getUser_nick());
			addB.setBd_no(boardList.size() + 1);
			if (bexe.addBoard(addB) && addB != null) {
				boards.add(addB);
				System.out.println("등록 완료");
			} else {
				System.out.println("등록 실패");
			}
			inside = new ArrayList<String>();
			addB = new Board(0, "", "", "", "", "", 0);
			while (main) {
				fBoard();
			}
			break;
		case "x":
			System.out.println("취소하였습니다");
			inside = new ArrayList<String>();
			;
			inroof = false;
			main = false;
			main = true;
			while (main) {
				fBoard();
			}
		}
		return scn;
	}

	static void board_Output(String id, String title, String ins) {
		String iblank = "　".repeat((id.length() - 1) / 2);
		String ispace = " ".repeat(4 - (id.length()));
			System.out.printf("%s  %s  %s  %s  %s  %s님 환영합니다", "[메인페이지]", "[회원가입]", "[자유게시판]", "[로그아웃]", "[마이페이지]",
					user.getUser_nick());
		System.out.printf("\n\n%61s\n\n", "자유게시판");
		System.out.println(
				"==========================================================================================================================\n");
		System.out.printf("%60s<글쓰기>\n\n", "");
		System.out.printf("%10s┌───────┬─────────────┐\n", "");
		if (id == "") {
			System.out.printf("%10s│　[분류] │%13s│\n", "", "");
		} else {
			System.out.printf("%10s│　[분류] │%s│\n", "", ispace + "　" + "<" + id + ">" + iblank + ispace + " ");
		}
		System.out.printf("%10s└───────┴─────────────┘\n\n", "");
		System.out.printf(
				"%10s┌─────────┬──────────────────────────────────────────────────────────────────────────────────┐\n",
				"");
		if (title == "") {
			System.out.printf("%10s│ 　[제목]  │%82s│\n", "", "");
		} else {
			System.out.printf("%10s│ 　[제목]  │%s│\n", "", title);
		}
		System.out.printf(
				"%10s└─────────┴──────────────────────────────────────────────────────────────────────────────────┘\n\n",
				"");
		System.out.printf("%12s[내용]\n", "");
		System.out.printf(
				"%10s┌────────────────────────────────────────────────────────────────────────────────────────────────────┐\n",
				"");
		if (inside.size() != 0) {
			for (int i = 0; i < inside.size(); i++) {
				System.out.printf("%10s│ %s│\n", "", inside.get(i));
			}
		} else {
			System.out.printf("%10s│%100s│\n", "", "");
			System.out.printf("%10s│%100s│\n", "", "");
			System.out.printf("%10s│%100s│\n", "", "");
			System.out.printf("%10s│%100s│\n", "", "");
			System.out.printf("%10s│%100s│\n", "", "");
		}
		System.out.printf(
				"%10s└────────────────────────────────────────────────────────────────────────────────────────────────────┘\n\n",
				"");
		System.out.printf("%55s확인[;]%3s취소[x]\n\n", "", "");
	}
}// end of class.
