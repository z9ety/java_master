package chap7;

// Friend��� + ȸ��, �μ�
public class CompFriend extends Friend {
	private String company;
	private String dept;

	public CompFriend() {
	}

	public CompFriend(String name, String phone, String company, String dept) {
		super(name, phone);
		this.company = company;
		this.dept = dept;
	}

	public String showInfo() {
		return "�̸��� " + super.getName() + " ����ó�� " + getPhone() + " ȸ��� " + company + " �μ��� " + dept;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
}
