package chap11.object;

import java.util.HashSet;

public class HashSetExe {
	public static void main(String[] args) {
		// �迭 -> �÷���(List, Set, Map)
		HashSet<String> set = new HashSet<String>();
		set.add("Hong");
		set.add("Hwang");
		set.add("Park");
		set.add("Hong");
//		set.add(new Member("Hong",20));

		for (Object name : set) {
			System.out.println(name);
		}

		HashSet<Member> members = new HashSet<Member>();
		members.add(new Member("ȫ�浿", 20));
		members.add(new Member("��浿", 21));
		members.add(new Member("�ڱ浿", 22));
		members.add(new Member("ȫ�浿", 20));
		for (Member mem : members) {
			System.out.println(mem.toString());
		}
	}
}
