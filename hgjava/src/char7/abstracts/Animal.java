package char7.abstracts;

// 추상클래스.
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
	
	//추상메소드.
	public abstract void sound();
}
