package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListExe3 {
//	public static int getSequence() {
//		int seqNo = 1;
//		int maxNo = 0;
//		for(int i=0; i<members.length; i++) {
//			if(members.get(i) != null && members.get(i).getMemberNo()>maxNo) {
//				maxNo = members.get(i).getMemberNo(); 
//			}
//	}
	public static void main(String[] args) {

		// 회원등록(회원번호, 이름, 포인트)
		// 1.등록 2.이름조회 3.포인트변경 4.삭제 5.종료.\
		List<Member> members = new ArrayList<>();

		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int no = 0;
		while (run) {
			for (int i = 1; i <= members.size(); i++) {
				if (members.get(i).getMemberName().indexOf(members.get(i).getMemberName()) != 1) {

				}
			}
			System.out.println("1.회원등록 2.이름조회 3.포인트변경 4.삭제 5.종료");
			System.out.println("선택 : ");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				System.out.println("이름을 입력하십시오");
				String name = sc.nextLine();
				no += 1;
				members.add(new Member(no, name, 0));
				System.out.println("등록되었습니다.");
				break;
			case "2":
				System.out.println("이름 검색 : ");
				String search = sc.nextLine();
				for (int i = 0; i < members.size(); i++) {
					if (members.get(i).getMemberName().indexOf(search) != -1) {
						System.out.printf("M-00%d %6s %8d", members.get(i).getMemberNo(),
								members.get(i).getMemberName(), members.get(i).getPoint());
					} else {
						System.out.println("해당 정보가 없습니다.");
					}
				}
				break;
			case "3":

				break;
			case "4":
				break;
			case "5":
				System.out.println("시스템 종료.");
				run = false;
			default:
				System.out.println("잘못된 값입니다.");
			}
		}
		System.out.println("end of prog.");
	}// end of main.
}
