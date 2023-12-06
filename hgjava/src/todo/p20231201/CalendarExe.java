package todo.p20231201;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {

		Calendar today = Calendar.getInstance();
		// 10월 달력 작성.
//		today.getActualMaximum(Calendar.DATE);
		int month = 11;
		today.set(Calendar.MONTH, month);
		today.set(Calendar.DATE, 1);
		String[] weeks = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Set" };
		for (String day : weeks) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		// 빈공백 생성.
		for (int i = 1; i <= today.get(Calendar.DAY_OF_WEEK) - 1; i++) {
			System.out.printf("%4s", "");
		}
		for (int i = 1; i <= today.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%4d", i);
			if (i % 7 == 8 - today.get(Calendar.DAY_OF_WEEK)) {
				System.out.println();
			}
		}
		System.out.println("\n== the end ==");
	}
}
