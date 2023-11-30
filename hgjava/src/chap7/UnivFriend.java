package chap7;

//import lombok.Data;

// �ڽ�:UnivFriend -> Friend(�θ�)
//@Data
public class UnivFriend extends Friend {
	private String univ; // �а�.
	private String major; // ����.

	public UnivFriend() {
	}

	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);
		this.univ = univ;
		this.major = major;
	}

	@Override
	public String showInfo() {
		return "�̸��� " + super.getName() + " ����ó�� " + getPhone() + " �б��� " + univ + " ������ " + major;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
}
