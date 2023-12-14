package todo.p20231214;

import java.util.*;

public class BookApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Book> books = new ArrayList<Book>();
		BookExe dexe = new BookExe();
		boolean run = true;
		while (run) {
			System.out.println("1.��� 2.��� 3.���� 4.���� 5.����");
			System.out.println("============================");
			System.out.print("���� : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				System.out.print("�����ڵ��Է�>> ");
				String bookCo_ = sc.nextLine();
				System.out.print("�������Է�>> ");
				String bookName_ = sc.nextLine();
				System.out.print("�����Է�>> ");
				String writer_ = sc.nextLine();
				System.out.print("���ǻ��Է�>> ");
				String maker_ = sc.nextLine();
				System.out.print("�����Է�>> ");
				int price_ = Integer.parseInt(sc.nextLine());
				Book adb = new Book(bookCo_, bookName_, writer_, maker_, price_);
				if (dexe.addBook(adb)) {
					books.add(adb);
					System.out.println("����Ǿ����ϴ�");
				} else {
					System.out.println("���� ����");
				}
				break;
			case 2:
				ArrayList<Book> bookList = dexe.getBookList();
				for (int i = 0; i < bookList.size(); i++) {
					bookList.get(i).showInfo();
				}
				break;
			case 3:
				System.out.print("������ �����ڵ��Է�>> ");
				bookCo_ = sc.nextLine();
				System.out.print("�����Է�>> ");
				price_ = Integer.parseInt(sc.nextLine());
				if (dexe.modifyBookPrice(bookCo_, price_)) {
					System.out.println("�����Ǿ����ϴ�");
				} else {
					System.out.println("���� �߻�");
				}
				break;
			case 4:
				System.out.print("������ �����ڵ��Է�>> ");
				bookCo_ = sc.nextLine();
				if (dexe.removeBook(bookCo_)) {
					System.out.println("�����Ǿ����ϴ�");
				} else {
					System.out.println("���� ����");
				}
				break;
			case 5:
				System.out.println("�����մϴ�");
				run = false;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�");
			}

		} // end of while.
	}

}
