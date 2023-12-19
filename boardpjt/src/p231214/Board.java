package p231214;

import lombok.Data;

@Data
public class Board {
	private int bd_no;
	private String bd_id;
	private String bd_title;
	private String bd_writer;
	private String bd_date;
	private int bd_joins;
	private String bd_inside;

	Board() {

	}

	Board(int no, String id, String title, String writer, String date, int joins) {
		this.bd_no = no;
		this.bd_id = id;
		this.bd_title = title;
		this.bd_writer = writer;
		this.bd_date = date;
		this.bd_joins = joins;
	}

	Board(int no, String id, String title, String inside, String writer, String date, int joins) {
		this.bd_no = no;
		this.bd_id = id;
		this.bd_title = title;
		this.bd_inside = inside;
		this.bd_writer = writer;
		this.bd_date = date;
		this.bd_joins = joins;
	}

	void showInfo() {
		System.out.printf("  %-8d|   %-6s\t|   %-40s\t|   %-10s\t|   %-12s\t|   %-5d\n", // 번호\t
																							// |%3s분류%3s\t|%3s제목%37s\t|%3s작성자%7s\t|%3s작성일%9s\t|%3s조회
				bd_no, bd_id, bd_title, bd_writer, bd_date, bd_joins);
	}

	void showReco() {
		System.out.printf("%31s%-5d|   %-6s\t|   %-23s\t|   %-12s\t|   %-5d\n", // 번호\t
																				// |%3s분류%3s\t|%3s제목%20s\t|%3s작성일%9s\t|%3s조회
				"", bd_no, bd_id, bd_title, bd_date, bd_joins);
	}
}
