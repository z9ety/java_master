package todo.p20231205;

import java.util.*;

public class BookExe {
	private ArrayList<Book> books;

	BookExe() {
		books = new ArrayList<Book>();
		books.add(new Book(1, "�̰��� �ڹٴ�", "�ſ��", 25000));
		books.add(new Book(3, "�ڹ� ����", "�����", 20000));
		books.add(new Book(1, "�ڹٸ���Ʈ", "�����", 15000));
	}

//	private Book[] books;

//	BookExe() {
//		books = new Book[100];
//		books[0] = new Book(1, "�̰��� �ڹٴ�", "�ſ��", 25000);
//		books[1] = new Book(3, "\t�ڹ� ����", "\t�����\t", 20000);
//		books[2] = new Book(1, "\t�ڹٸ���Ʈ", "\t�����\t", 15000);
//	}

//	boolean addBook(Book book) {
//		for (int i = 0; i < books.length; i++) {
//			if (books[i] == null) {
//				books[i] = book;
//				return true;
//			}
//		}
//		return false;
//	}
}
