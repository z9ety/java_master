package todo.p20231127;

import lombok.Data;

@Data
public class Friend {
	private String name;
	private String tel;
	private String blood;

	public Friend(String name, String tel, String blood) {
		this.name = name;
		this.tel = tel;
		this.blood = blood;
	}
}
