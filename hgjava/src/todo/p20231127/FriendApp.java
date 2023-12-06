package todo.p20231127;

import java.util.Scanner;

public class FriendApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Friend[] friends = new Friend[100];
		friends[0] = new Friend("박길동", "010-1234-5678", "A");
		friends[1] = new Friend("김길동", "010-2222-4444", "O");
		friends[2] = new Friend("홍길동", "010-5656-5566", "B");
		boolean run = true;
		while (run) {
			System.out.println("1.친구수 2.입력 3.목록 4.수정 5.종료");
			System.out.print("메뉴 선택>> ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				int fsum = 0;
				for (int i = 0; i < friends.length; i++) {
					if (friends[i] != null) {
						fsum++;
					}
				}
				System.out.println("친구수는 " + fsum + "명입니다.");
				break;
			case 2:
				System.out.print("이름입력>> ");
				String name_ = sc.nextLine();
				System.out.print("연락처입력>> ");
				String tel_ = sc.nextLine();
				System.out.print("혈액형입력>> ");
				String blood_ = sc.nextLine();
				for (int i = 0; i < friends.length; i++) {
					if (friends[i] == null) {
						friends[i] = new Friend(name_, tel_, blood_);
						System.out.println("입력 완료");
						break;

					}
				}
				break;
			case 3:
				System.out.println("이름   \t연락처           \t혈액형");
				for (int i = 0; i < friends.length; i++) {
					if (friends[i] != null) {
						System.out.printf("%-5s\t%-15s\t%s\n", friends[i].getName(), friends[i].getTel(),
								friends[i].getBlood());
					}
				}
				break;
			case 4:
				System.out.print("혈액형을 수정할 친구 이름을 입력>> ");
				name_ = sc.nextLine();
				System.out.print("혈액형입력>> ");
				blood_ = sc.nextLine();
				for (int i = 0; i < friends.length; i++) {
					if (friends[i].getName().equals(name_)) {
						friends[i].setBlood(blood_);
						System.out.println("수정 완료");
					}
				}
				break;
			case 5:
				System.out.println("시스템 종료");
				run = false;
				break;
			default:
				System.out.println("메뉴 번호를 입력해주세요");
			}
		}
	}

}
