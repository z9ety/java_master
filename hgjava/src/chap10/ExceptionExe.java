package chap10;

public class ExceptionExe {
	public static void main(String[] args) {
		test(); // ������ ��ġ
		System.out.println("end of prog.");
	}

	public static void test() // throws�� ������ �ϰ�ó�� ����
	{
		// �Ϲݿ��� : ���ܸ� ó��.
		try {
			Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
