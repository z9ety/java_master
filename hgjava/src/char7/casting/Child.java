package char7.casting;

public class Child extends Parent {
	private String phone;

	@Override
	String showInfo() {
		return super.showInfo() + " - " + phone;
	}
}
