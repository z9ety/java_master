package chap10;

public class ArrayExceptionExe {
	public static void main(String[] args) {

		// �迭�� ������ ��� ��ġ�� �� ����.
		int[] numAry = { 2, 5, 7 };
		try {

			for (int i = 0; i <= 3; i++) {
				System.out.println(numAry[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("������ ���� ���.");
		}
		System.out.println("end of prog.");
	}

}
