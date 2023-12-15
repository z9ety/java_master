package p231214;

import lombok.Data;

@Data
public class Account {
	private String user_id;
	private String user_pw;

	Account() {

	}

	Account(String id, String pw) {
		this.user_id = id;
		this.user_pw = pw;
	}
}
