package todo.p20231129;

public class MemberServiceExample {
	public static void main(String[] args) {
	MemberService memserv = new MemberService();
	boolean result = memserv.login("hong","12345");
		if(result) {
			System.out.println("�α��� �Ǿ����ϴ�.");
			memserv.logout("hong");
		}
		else {
			System.out.println("id �Ǵ� password�� �ùٸ��� �ʽ��ϴ�.");
		}
	}//end main
}
