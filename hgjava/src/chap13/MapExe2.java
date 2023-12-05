package chap13;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExe2 {
	public static void main(String[] args) {
		Map<Member, String> map;
		map = new HashMap<>();

		map.put(new Member(1, "홍길동", 100), "경기도 100번지");
		map.put(new Member(2, "김민수", 90), "서울시 200번지");
		map.put(new Member(3, "박씨", 80), "대전시 300번지");
		map.put(new Member(4, "홍길동", 100), "경기도 100번지");

		// 1) key를 set 저장.
		Set<Member> set = map.keySet();
		for (Member member : set) {
			System.out.println("key:" + member + ", value:" + map.get(set));
		}
		// 2) key, value => set에 저장.
		Set<Entry<Member, String>> entry = map.entrySet();
		for (Entry<Member, String> ent : entry) {
			System.out.println("key:" + ent.getkey() + ", Val:" + ent.getValue());
		}
	}
}
