package char7.abstracts;

// �߻�Ŭ����.
public abstract class Animal {
	private String name;

	public Animal() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	//�߻�޼ҵ�.
	public abstract void sound();
}
