package chap13;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExe2 {
	public static void main(String[] args) {
		Map<Member, String> map;
		map = new HashMap<>();

		map.put(new Member("M001", "ȫ�浿", 100), "��⵵ 100����");
		map.put(new Member("M002", "��μ�", 90), "����� 200����");
		map.put(new Member("M003", "�ھ�", 80), "������ 300����");
		map.put(new Member("M004", "ȫ�浿", 100), "��⵵ 100����");

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
