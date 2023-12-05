package todo.p20231205;

import java.util.*;

public class BookApp2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Book> books = new ArrayList<Book>();
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
				books.add(new Book(bookCo_, bookName_, writer_, maker_, price_));
				System.out.println("����Ǿ����ϴ�");
				break;
			case 2:
				char code = 66;
				System.out.println("�����ڵ�     ������           ����        ����");
				for (int i = 0; i < books.size(); i++) {
					System.out.printf("%s%03d      %-10s %-10s %d\n", code, books.get(i).getBookCo(),
							books.get(i).getBookName(), books.get(i).getWriter(), books.get(i).getPrice());
					code += 1;
				}
				break;
			case 3:
				System.out.print("������ �����ڵ��Է�>> ");
				bookCo_ = Integer.parseInt(sc.nextLine());
				System.out.print("�����Է�>> ");
				price_ = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < books.size(); i++) {
					if (books.get(i).getBookCo() == bookCo_) {
						books.get(i).setPrice(price_);
					}
				}
				System.out.println("�����Ǿ����ϴ�");
				break;
			case 4:
				System.out.print("������ �����ڵ��Է�>> ");
				bookCo_ = Integer.parseInt(sc.nextLine());
				
				System.out.println("�����Ǿ����ϴ�");
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
