package chap6;
// ȸ������ ��.
// ȸ����ȣ, ȸ���̸�, ����ó, ����
// public <-> private
public class Member {
	// �Ӽ�(�ʵ�)
	private int memberNo; //�ڹٿ����� �δܾ��̻��� ����: CamelCase.
	private String memberName;
	private String phone; //010-1234-5667
	private String gender; // Men or Women => M, W
	int age;
	
	// ������ : �ʵ��� �ʱⰪ�� ����.
	// �⺻������ �����Ϸ��� ����.
	Member(){
		
	}
	Member(int memberNo, String memberName){
		this.memberNo = memberNo;
		this.memberName = memberName;
	}
	
	public Member(int memberNo, String memberName, String phone, String gender) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.phone = phone;
		this.gender = gender;
	}
	//���(�޼ҵ�)
	void showInfo() {
		System.out.println("�̸��� " + memberName + "�̰� ����ó�� " + phone + " �Դϴ�.");
	}
	String showAllInfo() {
		String result = "�̸��� " + memberName + "�̰� ��ȣ�� " + memberNo + "�̰� ����ó�� "	 + phone + "�̰� ������ " + gender + "�Դϴ�.";
		return result;
	}
	//memberNo�� ���� �����ϴ� �޼ҵ�.
	void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	void setPhone(String phone) {
		this.phone = phone;
	}
	void setGender(String gender) {
		this.gender = gender;
	}
	
	// getter.
	int getMemberNo() {
		return memberNo;
	}
	String getMemberName() {
		return memberName;
	}
	String getPhone() {
		return phone;
	}
	String getGender() {
		return gender;
	}
}
