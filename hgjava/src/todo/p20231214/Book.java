package todo.p20231214;

import lombok.Data;

@Data
public class Book {
	private String bookCo;
	private String bookName;
	private String writer;
	private String maker;
	private int price;
	
	Book(){
		
	}

	Book(String bookCo, String bookName, String writer, String maker, int price) {
		this.bookCo = bookCo;
		this.bookName = bookName;
		this.writer = writer;
		this.maker = maker;
		this.price = price;
	}

	Book(String bookCo, String bookName, String writer, int price) {
		this.bookCo = bookCo;
		this.bookName = bookName;
		this.writer = writer;
		this.price = price;
	}
	
	void showInfo() {
	System.out.printf("%s   \t %-10s\t %-10s\t %d\n", bookCo, bookName, writer, price);
	}
}
