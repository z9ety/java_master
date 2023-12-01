package todo.p20231201;

public class CalendarExe {
	public static void main(String[] args) {
		// 12월 달력 작성.
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Set" };
		for (String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		for (int i = 1; i<=5; i++) {
			System.out.printf("%4s","");
		}
		for (int i = 1; i <= 31; i++) {
			System.out.printf("%4d", i);
			if (i % 7 == 2) {
				System.out.println();
			}
		}
		System.out.println("\n== the end ==");
	}
}
