package chap11.object;

public class ObjectExe {
	public static void main(String[] args) {
		// equals.

		Object obj1 = new Object();
		Object obj2 = new Object();

		// ��ü�� �ּҰ��� ��.
		System.out.println(obj1.equals(obj2));

		String str1 = new String("Hello");
		String str2 = new String("hello");
		System.out.println(str1.equals(str2));

		Member mem1 = new Member("ȫ�浿", 20);// 20? 22? true false
		Member mem2 = new Member("ȫ�浿", 22);
		System.out.println(mem1.equals(mem2));

	}
}
