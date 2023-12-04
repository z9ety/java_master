package chap11.object;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
		// 1: YEAR, 2: MONTH / DAY_OF_WEEK: ��(1) ��(2)..
		Calendar cal = Calendar.getInstance();
		cal.set(1, 2022);
		cal.set(Calendar.MONTH, 4);
		cal.set(Calendar.DATE, 1);
		cal.set(2023, 3, 1);
		System.out.println("����: " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("����: " + cal.getActualMaximum(Calendar.DATE));

	}
}
