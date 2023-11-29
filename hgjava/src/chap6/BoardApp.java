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
			System.out.print("id를 입력>>> ");
			id = sc.nextLine();
			System.out.print("pw를 입력>>> ");
			String pw = sc.nextLine();
			User user = uexe.logIn(id, pw);
			if(user != null) {
				System.out.println(user.getUserName() + "님 환영합니다.");
				break;
			}
			else {
				System.out.println("id, pw 확인하세요");
			}
		}// 로그인 처리.
		/////////////////////////////////
		// 초기값 생성.
		exe.initData();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.수정 5.삭제 6.종료");
//			System.out.println("1.등록 2.목록 3.상세조회 4.종료");
			System.out.print("선택 > ");
			int sel = Integer.parseInt(sc.nextLine());
			
			switch(sel) {
			case 1:
				System.out.print("제목 : ");
				String title_ = sc.nextLine();
				System.out.print("내용 : ");
				String txt_ = sc.nextLine();
				System.out.print("작성일시 : ");
				String day_ = sc.nextLine();
				
				Board board = new Board(exe.getSequence(), title_, id, txt_, day_);
				if(exe.addBoard(board)) {
					System.out.println("등록 성공!");
				}
				else {
					System.out.println("등록 실패!");
				}
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
			case 2: //목록보기 -> 페이지보기.
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
				System.out.print("글번호 입력>>> ");
				int no =Integer.parseInt(sc.nextLine());
				Board result = exe.getBoard(no);
				if(result != null) {
					System.out.println(result.showDetailInfo());
				}
				else {
					System.out.println("조회된 내용이 없습니다");
				}
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
				System.out.println("수정할 글번호>>> ");		
				no = Integer.parseInt(sc.nextLine());
				if(!exe.checkResponsibility(id, no)) {
					System.out.println("권한없음");
					continue;
				}
				System.out.println("수정한 글내용>>> ");	
				txt_ = sc.nextLine();
				if(exe.modBoard(no, txt_)) {
					System.out.println("변경 성공!");
				}
				else {
					System.out.println("처리 실패!");
				}
				break;
//				System.out.println("프로그램을 종료합니다.");
//				run = false;
			case 5:
				System.out.println("삭제할 글번호>>> ");
				no = Integer.parseInt(sc.nextLine());
				if(!exe.checkResponsibility(id, no)) {
					System.out.println("삭제권한없음");
					continue;
				}
				if(exe.remBoard(no)) {
					System.out.println("삭제 성공");
				}
				else {
					System.out.println("삭제 실패");
				}
			case 6:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}
		}
	}//end main
	
	public static void showList(Board[] boardAry, int page) {
		// 페이징처리.
		Board[] pageAry = exe.pageList(boardAry, page);
		System.out.println("글번호 제목 작성자 작성일시");
		System.out.println("=========================");
		for(Board brd : pageAry) {
			if(brd != null) {
				System.out.println(brd.showInfo());
			}
		}
		// 전체페이지 계산하고 출력.
		int cnt = exe.getBoardCount();
		int totalpage = (int)Math.ceil(cnt/5.0);
		for(int i=1; i<=totalpage; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n페이지를 선택하세요>> 종료:0 입력.");
	}
}//end class
