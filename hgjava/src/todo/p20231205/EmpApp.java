package todo.p20231205;

import java.util.*;

public class EmpApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmpExe exe = new EmpExe();
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회 6.종료");
			System.out.print("메뉴 선택 : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				addMember();
				break;
			case 2:
				getMemberList();
				break;
			case 3:
				modifyInc();
				break;
			case 4:
				removeMember();
				break;
			case 5:
				getMember();
				break;
			case 6:
				systemOff();
				run = false;
			default:
				System.out.println("잘못된 값입니다");
				run = false;
			}
		}//end of while.
	}
}
