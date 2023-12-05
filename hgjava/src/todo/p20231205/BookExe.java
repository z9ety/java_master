package todo.p20231205;

import java.util.*;

public class BookExe {
	private ArrayList<Book> books;

	BookExe() {
		books = new ArrayList<Book>();
		books.add(new Book(1, "이것이 자바다", "신용권", 25000));
		books.add(new Book(3, "자바 기초", "김재원", 20000));
		books.add(new Book(1, "자바마스트", "박재민", 15000));
	}

//	private Book[] books;

//	BookExe() {
//		books = new Book[100];
//		books[0] = new Book(1, "이것이 자바다", "신용권", 25000);
//		books[1] = new Book(3, "\t자바 기초", "\t김재원\t", 20000);
//		books[2] = new Book(1, "\t자바마스트", "\t박재민\t", 15000);
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
