package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExe {
	public static void main(String[] args) {
		// Ű: �� ������ ����
		Map<String, Integer> map = new HashMap<String, Integer>();

		// �߰�.
		map.put("ȫ�浿", 80);
		map.put("��浿", 85);
		map.put("������", 90);

		//
		Integer result = map.get("ȫ�浿");

		// ��ü���.
		Set<String> set = map.keySet();
		for(String key : set) {
			System.out.println("key: "+key+", value: "+map.get(key));
		}
	}
}
