package todo.p20231205;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Book[] books = new Book[100];
		BookExe exe = new BookExe();
		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.종료");
			System.out.println("============================");
			System.out.print("선택 : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				System.out.print("도서코드입력>> ");
//				try {
				int bookCo_ = Integer.parseInt(sc.nextLine());
//				} catch (Exception er) {
//					System.out.print("잘못된 값입니다");
//					break;
//				}
				System.out.print("도서명입력>> ");
				String bookName_ = sc.nextLine();
				System.out.print("저자입력>> ");
				String writer_ = sc.nextLine();
				System.out.print("출판사입력>> ");
				String maker_ = sc.nextLine();
				System.out.print("가격입력>> ");
//				try {
				int price_ = Integer.parseInt(sc.nextLine());
//				} catch (Exception er) {
//					System.out.print("잘못된 값입니다");
//					break;
//				}
				Book addB = new Book(bookCo_, bookName_, writer_, maker_, price_);
				if (exe.addBook(addB)) {
					System.out.println("저장되었습니다");
				} else {
					System.out.println("저장 중 오류.");
				}
				break;
			case 2:
//				char code = 66;
				System.out.println("도서코드     도서명           저자        가격");
				for (Book printB : exe.getBookList()) {
					if (printB != null) {
						printB.showInfo();
					}
				}
				break;
			case 3:
				System.out.print("수정할 도서코드입력>> ");
				bookCo_ = Integer.parseInt(sc.nextLine());
				Book searchB = exe.getBook(bookCo_);
				if (searchB != null) {
					searchB.showInfo();
				} else {
					System.out.println("존재하지 않는 정보");
				}
				break;
			case 4:
				System.out.println("삭제할 도서코드입력>>");
				bookCo_ = Integer.parseInt(sc.nextLine());
				if (exe.removeBook(bookCo_)) {
					System.out.println("삭제되었습니다");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			case 5:
				System.out.println("종료합니다");
				run = false;
			default:
				System.out.println("잘못된 입력입니다");
			}

		} // end of while.
	}

}
