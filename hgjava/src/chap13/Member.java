package chap13;

import lombok.Data;

@Data
public class Member {
	private int memberNo;
	private String memberName;
	private int point;

	public Member(int memberNo, String memberName, int point) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.point = point;
	}

	public Member(String memberName, int point) {
		this.memberName = memberName;
		this.point = point;
	}

	// hashCode, equals �����ϴ� ���� ���� ���� ��ü.
//	@Override
//	public int hashCode() {
//		return super.hashCode();
//	}

//	String getMemberName() {
//		return
//	}
//
//	int getPoint() {
//		
//	}
}
