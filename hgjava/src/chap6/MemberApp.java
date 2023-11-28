package chap6;

public class MemberApp {
	public static void main(String[] args) {
		Member[] members = new Member[10];
		
		members[0] = new Member(1,"Hong","010-1111", "Men");
		members[1] = new Member(2,"Park","010-2222", "Women");
		members[2] = new Member(3,"Choi","010-3333", "Women");
		
		for(int i=0; i<members.length; i++) {
			if(members[i] != null && members[i].getGender().equals("Women")) {
			System.out.println(members[i].showAllInfo());
			}
		}
//		test1();
	}//end of main.
	static void test1() {
		Member mem1 = new Member(); // �ν��Ͻ� ����
		System.out.println(mem1);
//		mem1.memberNo = 10;
		mem1.setMemberNo(10);
//		mem1.memberName = "Hong";
		mem1.setMemberName("Hong");
//		mem1.phone = "010-1234-5678";
		mem1.setPhone("010-1234-5678");
//		mem1.gender = "Men";
		mem1.setGender("Men");
		
		mem1.showInfo();
		
		Member mem2 = new Member(11, "Hwang");
//		mem2.phone = "010-3333-4444";
		mem2.showInfo();
		
		Member mem3 = new Member(12, "Park", "010-5678-8765", "Women");
		mem3.showInfo(); // ��ȯ����: void
		String msg = mem3.showAllInfo(); // ��ȯ����: String
		System.out.println(msg);
	}//end of test1.
}
