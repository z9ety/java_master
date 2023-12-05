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
			System.out.println("1.��� 2.��� 3.���� 4.���� 5.����");
			System.out.println("============================");
			System.out.print("���� : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				System.out.print("�����ڵ��Է�>> ");
//				try {
				int bookCo_ = Integer.parseInt(sc.nextLine());
//				} catch (Exception er) {
//					System.out.print("�߸��� ���Դϴ�");
//					break;
//				}
				System.out.print("�������Է�>> ");
				String bookName_ = sc.nextLine();
				System.out.print("�����Է�>> ");
				String writer_ = sc.nextLine();
				System.out.print("���ǻ��Է�>> ");
				String maker_ = sc.nextLine();
				System.out.print("�����Է�>> ");
//				try {
				int price_ = Integer.parseInt(sc.nextLine());
//				} catch (Exception er) {
//					System.out.print("�߸��� ���Դϴ�");
//					break;
//				}
				Book addB = new Book(bookCo_, bookName_, writer_, maker_, price_);
				if (exe.addBook(addB)) {
					System.out.println("����Ǿ����ϴ�");
				} else {
					System.out.println("���� �� ����.");
				}
				break;
			case 2:
//				char code = 66;
				System.out.println("�����ڵ�     ������           ����        ����");
				for (Book printB : exe.getBookList()) {
					if (printB != null) {
						printB.showInfo();
					}
				}
				break;
			case 3:
				System.out.print("������ �����ڵ��Է�>> ");
				bookCo_ = Integer.parseInt(sc.nextLine());
				Book searchB = exe.getBook(bookCo_);
				if (searchB != null) {
					searchB.showInfo();
				} else {
					System.out.println("�������� �ʴ� ����");
				}
				break;
			case 4:
				System.out.println("������ �����ڵ��Է�>>");
				bookCo_ = Integer.parseInt(sc.nextLine());
				if (exe.removeBook(bookCo_)) {
					System.out.println("�����Ǿ����ϴ�");
				} else {
					System.out.println("���� ����");
				}
				break;
			case 5:
				System.out.println("�����մϴ�");
				run = false;
			default:
				System.out.println("�߸��� �Է��Դϴ�");
			}

		} // end of while.
	}

}
