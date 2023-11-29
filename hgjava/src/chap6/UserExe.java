package chap6;

public class UserExe {
	private User[] users;
	
	public UserExe() {
		users = new User[] {new User("user01","1111","홍길동"),new User("user02","2222","김철수"),new User("user03","3333","박씨")};
	}// 생성자.
	
	//public(패키지간 사용가능) > default(패키지내에서만 사용) > private(클래스내에서만 사용) 
	public User logIn(String id, String pw) {
		for(int i=0; i<users.length; i++) {
			if(users[i] != null && users[i].getUserId().equals(id) && users[i].getPasswd().equals(pw)) {
				return users[i];
			}
		}
		return null;
	}//end of login.
}
