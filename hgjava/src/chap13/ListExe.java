package chap13;

import java.util.ArrayList;
import java.util.List;

public class ListExe {
	public static void main(String[] args) {
		String[] strs = { "Mon", "Tue", "10" };
		strs[0] = null;
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}

		List<String> list = new ArrayList<String>();
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");

		list.remove("Apple"); // ����.
		list.set(0, "�ٳ���"); // ����.
		list.clear(); // ��ü ��� ����.

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// �÷����� ũ�� ����.
		for (int i = 0; i < 100; i++) {
			list.add("" + i);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// �̸�����.
		List<String> names = new ArrayList<String>();
		names.add("ȫ�浿"); // 0: ù��°.
		names.add("��浿"); // 1: �ι�°.
		names.add("��ö��"); // 2: ����°.

		String search = "�浿";
		int cnt = 0;
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).indexOf(search) != -1) {
				System.out.println(names.get(i));
				cnt++;
			}
		}
		System.out.printf("'%s'�� ��ġ�ϴ� �̸��� ���� ����� �� %d���Դϴ�.", search, cnt);
	}
}
