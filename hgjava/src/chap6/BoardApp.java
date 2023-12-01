package chap6;

import java.util.Scanner;

//M(odel) V(iew) C(ontrol)
public class BoardApp {
//	public static BoardExe exe = new BoardExe();
	// 데이터마다 다른 정보를 담을 필요가 없는 클래스는 static멤버 선언.
	private Scanner sc = new Scanner(System.in);
	private String id = null;

	// 싱글톤 방식의 인스턴스 생성.
	private static BoardApp instance = new BoardApp();

	// 생성자.
	private BoardApp() {

	}

	public static BoardApp getInstance() {
		return instance;
	}

	private void boardAdd() {
		System.out.print("제목 : ");
		String title_ = sc.nextLine();
		System.out.print("내용 : ");
		String txt_ = sc.nextLine();
		System.out.print("작성일시 : ");
		String day_ = sc.nextLine();
		Board board = new Board(BoardExe.getSequence(), title_, id, txt_, day_);
		if (BoardExe.addBoard(board)) {
			System.out.println("등록 성공!");
		} else {
			System.out.println("등록 실패!");
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
			System.out.print("글번호 입력>>> ");
			try {
				no = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력.");
			}
		}
		Board result = BoardExe.getBoard(no);
		if (result != null) {
			System.out.println(result.showDetailInfo());
		} else {
			System.out.println("조회된 내용이 없습니다");
		}
	}

	private void boardEdit() {
		System.out.println("수정할 글번호>>> ");
		int no = Integer.parseInt(sc.nextLine());
		if (!BoardExe.checkResponsibility(id, no)) {
			System.out.println("권한없음");
			// continue;
			return;
		}
		System.out.println("수정한 글내용>>> ");
		String txt_ = sc.nextLine();
		if (BoardExe.modBoard(no, txt_)) {
			System.out.println("변경 성공!");
		} else {
			System.out.println("처리 실패!");
		}
	}

	private void boardDel() {
		System.out.println("삭제할 글번호>>> ");
		int no = Integer.parseInt(sc.nextLine());
		if (!BoardExe.checkResponsibility(id, no)) {
			System.out.println("삭제권한없음");
			// continue;
			return;
		}
		if (BoardExe.remBoard(no)) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

	public void start() {
		boolean run = true;
//		Board[] arr = new Board[100];
//		int num_ = 0;
		//////////////////////////////////
		UserExe uexe = new UserExe();
		while (true) {
			System.out.print("id를 입력>>> ");
			id = sc.nextLine();
			System.out.print("pw를 입력>>> ");
			String pw = sc.nextLine();
			User user = uexe.logIn(id, pw);
			if (user != null) {
				System.out.println(user.getUserName() + "님 환영합니다.");
				break;
			} else {
				System.out.println("id, pw 확인하세요");
			}
		} // 로그인 처리.
			/////////////////////////////////
			// 초기값 생성.
		BoardExe.initData();

		while (run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.수정 5.삭제 6.종료");
//			System.out.println("1.등록 2.목록 3.상세조회 4.종료");
			System.out.print("선택 > ");
			//////////////////////////
			int sel = 0;
			try {
				sel = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("정확한 메뉴를 선택하세요.");
				continue;
			}
			//////////////////////////
			switch (sel) {
			case 1: // 글등록.
				boardAdd();
				break;
//				System.out.print("제목 : ");
//				String title_ = sc.nextLine();
//				System.out.print("작성자 : ");
//				String writer_ = sc.nextLine();
//				System.out.print("내용 : ");
//				String txt_ = sc.nextLine();
//				System.out.print("작성일시 : ");
//				String day_ = sc.nextLine();
//				num_ += 1;
//				Board at = new Board(num_,title_,writer_,txt_,day_);
//				for(int i=0; i<arr.length; i++) {
//					if(arr[i] == null) {
//						arr[i] = at;
//						System.out.println("등록되었습니다.");
//						break;
//					}
//				}
//				break;
			case 2: // 목록보기 -> 페이지보기.
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
//				System.out.println("상세조회할 게시물 번호를 입력해주세요 > ");
//				int join = Integer.parseInt(sc.nextLine());
//				for(int i=0; i<arr.length; i++) {
//					if(arr[i] != null && arr[i].getNum() == join) {
//						arr[i].showInfo2();
//					}
//				}
//				break;
			case 4: // 수정.
				boardEdit();
				break;
//				System.out.println("프로그램을 종료합니다.");
//				run = false;
			case 5:
				boardDel();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}
		}
	}// end main

	private void showList(Board[] boardAry, int page) {
		// 페이징처리.
		Board[] pageAry = BoardExe.pageList(boardAry, page);
		System.out.println("글번호 제목 작성자 작성일시");
		System.out.println("=========================");
		for (Board brd : pageAry) {
			if (brd != null) {
				System.out.println(brd.showInfo());
			}
		}
		// 전체페이지 계산하고 출력.
		int cnt = BoardExe.getBoardCount();
		int totalpage = (int) Math.ceil(cnt / 5.0);
		for (int i = 1; i <= totalpage; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n페이지를 선택하세요>> 종료:0 입력.");
	}
}// end class
