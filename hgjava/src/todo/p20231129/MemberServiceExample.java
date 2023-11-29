package todo.p20231129;

public class MemberServiceExample {
	public static void main(String[] args) {
	MemberService memserv = new MemberService();
	boolean result = memserv.login("hong","12345");
		if(result) {
			System.out.println("로그인 되었습니다.");
			memserv.logout("hong");
		}
		else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}//end main
}
