package chap10;

public class NullExceptionExe {
	public static void main(String[] args) {

		// Null ���� ������ ��� [����]
		String name = "Hong";

		name = "null";
		String menu = "2";
		int[] numary = { 1, 2 };

		// ����ó��.
		try {
			name = "";
			System.out.println(name.toString());
			int num = Integer.parseInt(menu);
			System.out.println("�Է°��� " + num);
			System.out.println(numary[3]);

		} catch (NullPointerException | NumberFormatException e) {
			System.out.println("Null���ܹ߻�.");
//			e.printStackTrace();
//		} catch (NumberFormatException ne) {
//			System.out.println("���ڰ��� �Է��ϼ���.");
		} catch (Exception ee) {
			System.out.println("�� �� ���� ����.");
		}

		System.out.println("end of prog");

	}
}
