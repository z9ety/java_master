package todo.p20231205;

import lombok.Data;

@Data
public class Member {
	private int no;
	private String name;
	private String tel;
	private String day;
	private int inc;

	Member(int no_, String name_, String tel_, String day_, int inc_) {
		this.no = no_;
		this.name = name_;
		this.tel = tel_;
		this.day = day_;
		this.inc = inc_;
	}

}
