package todo.p20231214;

import java.util.*;

public class BookApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Book> books = new ArrayList<Book>();
		BookExe dexe = new BookExe();
		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.종료");
			System.out.println("============================");
			System.out.print("선택 : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				System.out.print("도서코드입력>> ");
				String bookCo_ = sc.nextLine();
				System.out.print("도서명입력>> ");
				String bookName_ = sc.nextLine();
				System.out.print("저자입력>> ");
				String writer_ = sc.nextLine();
				System.out.print("출판사입력>> ");
				String maker_ = sc.nextLine();
				System.out.print("가격입력>> ");
				int price_ = Integer.parseInt(sc.nextLine());
				Book adb = new Book(bookCo_, bookName_, writer_, maker_, price_);
				if (dexe.addBook(adb)) {
					books.add(adb);
					System.out.println("저장되었습니다");
				} else {
					System.out.println("저장 실패");
				}
				break;
			case 2:
				ArrayList<Book> bookList = dexe.getBookList();
				for (int i = 0; i < bookList.size(); i++) {
					bookList.get(i).showInfo();
				}
				break;
			case 3:
				System.out.print("수정할 도서코드입력>> ");
				bookCo_ = sc.nextLine();
				System.out.print("가격입력>> ");
				price_ = Integer.parseInt(sc.nextLine());
				if (dexe.modifyBookPrice(bookCo_, price_)) {
					System.out.println("수정되었습니다");
				} else {
					System.out.println("오류 발생");
				}
				break;
			case 4:
				System.out.print("삭제할 도서코드입력>> ");
				bookCo_ = sc.nextLine();
				if (dexe.removeBook(bookCo_)) {
					System.out.println("삭제되었습니다");
				} else {
					System.out.println("삭제 실패");
				}
				break;
			case 5:
				System.out.println("종료합니다");
				run = false;
				break;
			default:
				System.out.println("잘못된 입력입니다");
			}

		} // end of while.
	}

}
