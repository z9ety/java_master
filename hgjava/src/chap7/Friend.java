package chap7;

//import lombok.Data;

//�θ�: �̸�, ����ó, showInfo()
//@Data
public class Friend {
	private String name;
	private String phone;

	// �⺻������.
	public Friend() {
		super();
	}

	///////////////////////
	public Friend(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	// �޼ҵ�.

	@Override
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + "]";
	}

	public String showInfo() {
		return "�̸��� " + name + " ����ó�� " + phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
