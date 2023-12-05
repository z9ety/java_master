package todo.p20231205;

import lombok.Data;

@Data
public class Book {
	private int bookCo;
	private String bookName;
	private String writer;
	private String maker;
	private int price;
	
	Book(){
		
	}

	public Book(int bookCo, String bookName, String writer, String maker, int price) {
		this.bookCo = bookCo;
		this.bookName = bookName;
		this.writer = writer;
		this.maker = maker;
		this.price = price;
	}

	public Book(int bookCo, String bookName, String writer, int price) {
		this.bookCo = bookCo;
		this.bookName = bookName;
		this.writer = writer;
		this.price = price;
	}
	
}
