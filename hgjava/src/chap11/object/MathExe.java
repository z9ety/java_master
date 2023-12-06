package chap11.object;

public class MathExe {

	public static void main(String[] args) {
		long result = (long) Math.round(-1.2);
		System.out.println("round: " + result);

		// 61 ~ 100��.
		System.out.println(Math.random());
		for (int i = 1; i <= 10; i++) {
			int r = 61 + (int) (Math.random() * 40); // 0 <= x < 10
			System.out.printf("%d ", r);
		}
		// 1 ~ 6 ��.
		// �ߺ����� ���� ���� �迭�� ����.

		int[] numbers = new int[6];
		// while������
		boolean run = true;
		while (run) {
			int r = 1 + (int) (Math.random() * 6);
			for (int i = 0; i < numbers.length; i++) {
				if (numbers.equals(r) != true) {
					numbers[i] = r;
					break;
				}
			}
			if (numbers.equals(null)) {
				run = false;
			}
		} // end of while.
		System.out.println(numbers);
		// for������
//		for (int i = 0; i < numbers.length; i++) {
//			boolean exist = false;
//			int no = 1 + (int) (Math.random() * 6);
//			if (numbers.equals(no) != true) {
//				numbers[i] = no;
//				System.out.print(numbers[i] + " ");
	}// end of main.
}
