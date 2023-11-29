package chap6;

import java.util.Scanner;

public class BoardApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board[] arr = new Board[100];
		boolean run = true;
		int num_ = 0;
		while(run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.종료");
			System.out.print("선택 > ");
			int sel = Integer.parseInt(sc.nextLine());
			
			switch(sel) {
			case 1:
				System.out.print("제목 : ");
				String title_ = sc.nextLine();
				System.out.print("작성자 : ");
				String writer_ = sc.nextLine();
				System.out.print("내용 : ");
				String txt_ = sc.nextLine();
				System.out.print("작성일시 : ");
				String day_ = sc.nextLine();
				num_ += 1;
				Board at = new Board(num_,title_,writer_,txt_,day_);
				for(int i=0; i<arr.length; i++) {
					if(arr[i] == null) {
						arr[i] = at;
						System.out.println("등록되었습니다.");
						break;
					}
				}
				break;
			case 2:
				System.out.println("------------------------------");
				for(int i=0; i<arr.length; i++) {
					if(arr[i] != null) {
						arr[i].showInfo();
					}
				}
				System.out.println("------------------------------");
				break;
			case 3:
				System.out.println("상세조회할 게시물 번호를 입력해주세요 > ");
				int join = Integer.parseInt(sc.nextLine());
				for(int i=0; i<arr.length; i++) {
					if(arr[i] != null && arr[i].getNum() == join) {
						arr[i].showInfo2();
					}
				}
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}
		}
	}//end main
}//end class
