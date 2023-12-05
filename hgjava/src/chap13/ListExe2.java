package chap13;

import java.util.ArrayList;
import java.util.List;

public class ListExe2 {
	public static void main(String[] args) {
		List<Member> members = new ArrayList<>();
		members.add(new Member(1, "ȫ�浿", 1000));
		members.add(new Member(2, "��浿", 1500));
		members.add(new Member(3, "���μ�", 2000));
		String search = "�浿";
		int cnt = 0;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getMemberName().indexOf(search) != -1 && members.get(i).getPoint() >= 1500) {
				cnt++;
				members.remove(i);
			}
		}
		System.out.println(search + "��" + cnt + "���Դϴ�.");
		for (Member mem : members) {
			System.out.println(mem);
		}
	}
}
