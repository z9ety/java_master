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
	private int bd_page;

	Board() {

	}

	Board(String id, String title, String writer) {
		this.bd_id = id;
		this.bd_title = title;
		this.bd_writer = writer;
	}

	void showInfo() {
		System.out.printf("%s   \t %-10s\t %-10s\t %d\n", //
				bd_no, bd_id, bd_title, bd_writer, bd_date, bd_joins, bd_page);
	}
}
