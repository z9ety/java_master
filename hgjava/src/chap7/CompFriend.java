package chap7;

// Friend상속 + 회사, 부서
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
		return "이름은 " + super.getName() + " 연락처는 " + getPhone() + " 회사는 " + company + " 부서는 " + dept;
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
