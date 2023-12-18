package p231214;

import lombok.Data;

@Data
public class Account {
	private String user_id;
	private String user_pw;
	private String user_nick;

	Account() {

	}

	Account(String id, String pw) {
		this.user_id = id;
		this.user_pw = pw;
	}

	Account(String id, String pw, String nick) {
		this.user_id = id;
		this.user_pw = pw;
		this.user_nick = nick;
	}
}
