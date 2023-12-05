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
//		boolean run = true;
//		while (run) {
//			int r = 1 + (int) (Math.random() * 6);
//			for (int num : numbers) {
//				if (num != r) {
//					num = r;
//				} else {
//					break;
//				}
//			}
//			if () {
//				break;
//			}
//		} // end of while.
//		System.out.println(numbers);

		// for������
		for (int i = 0; i < numbers.length; i++) {
			boolean exist = false;
			int no = 1 + (int) (Math.random() * 6);
			for (int search : numbers) {
				if (search != no) {
					numbers[i] = no;
					System.out.print(numbers[i] + " ");
				}
			}
			if (numbers[i] == 0) {
				continue;
			}
		}
	}// end of main.
}
