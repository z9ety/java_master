package chap10;

public class ExceptionExe {
	public static void main(String[] args) {
		test(); // 던지는 위치
		System.out.println("end of prog.");
	}

	public static void test() // throws로 던져서 일괄처리 가능
	{
		// 일반예외 : 예외를 처리.
		try {
			Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
