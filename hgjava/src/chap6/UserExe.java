package chap6;

public class UserExe {
	private User[] users;
	
	public UserExe() {
		users = new User[] {new User("user01","1111","ȫ�浿"),new User("user02","2222","��ö��"),new User("user03","3333","�ھ�")};
	}// ������.
	
	//public(��Ű���� ��밡��) > default(��Ű���������� ���) > private(Ŭ������������ ���) 
	public User logIn(String id, String pw) {
		for(int i=0; i<users.length; i++) {
			if(users[i] != null && users[i].getUserId().equals(id) && users[i].getPasswd().equals(pw)) {
				return users[i];
			}
		}
		return null;
	}//end of login.
}
