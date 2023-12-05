package chap13;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExe2 {
	public static void main(String[] args) {
		Map<Member, String> map;
		map = new HashMap<>();

		map.put(new Member(1, "ȫ�浿", 100), "��⵵ 100����");
		map.put(new Member(2, "��μ�", 90), "����� 200����");
		map.put(new Member(3, "�ھ�", 80), "������ 300����");
		map.put(new Member(4, "ȫ�浿", 100), "��⵵ 100����");

		// 1) key�� set ����.
		Set<Member> set = map.keySet();
		for (Member member : set) {
			System.out.println("key:" + member + ", value:" + map.get(set));
		}
		// 2) key, value => set�� ����.
		Set<Entry<Member, String>> entry = map.entrySet();
		for (Entry<Member, String> ent : entry) {
			System.out.println("key:" + ent.getkey() + ", Val:" + ent.getValue());
		}
	}
}
