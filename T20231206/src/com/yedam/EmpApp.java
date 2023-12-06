package com.yedam;

import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmpDAO exe = new EmpDAO();
		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회 6.종료");
			System.out.print("메뉴 선택>> ");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회 6.종료");
				System.out.print("사번입력>> ");
				String memnum_ = sc.nextLine();
				System.out.print("이름입력>> ");
				String memname_ = sc.nextLine();
				System.out.print("전화번호입력>> ");
				String memtel_ = sc.nextLine();
				System.out.print("입사일입력>> ");
				String jday_ = sc.nextLine();
				System.out.print("급여입력>> ");
				int income_ = Integer.parseInt(sc.nextLine());
				Employee mem = new Employee(memnum_, memname_, memtel_, jday_, income_);
				if (exe.addMember(mem)) {
					System.out.println("등록 완료");
				} else {
					System.out.println("오류 발생");
				}
				break;
			case "2":
				System.out.println("1.등록 2.목록 3.수정 4.삭제 5.조회 6.종료");
				System.out.println("사번     \t이름   \t전화번호");
				for (Employee mem2 : exe.memberList()) {
					if (mem2 != null) {
						mem2.showInfo();
					}
				}
				break;
			case "3":
				System.out.println("사번 급여>> ");
				memnum_ = sc.nextLine();
				income_ = Integer.parseInt(sc.nextLine());
				if (exe.modifyIncome(memnum_, income_)) {
					System.out.println("수정 완료");
				} else {
					System.out.println("사번을 찾을 수 없습니다");
				}
				break;
			case "4":
				System.out.println("사번>> ");
				memnum_ = sc.nextLine();
				if (exe.removeMember(memnum_)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("사번을 찾을 수 없습니다");
				}
				break;
			case "5":
				System.out.println("입사일>> ");
				jday_ = sc.nextLine();
				Employee mem3 = exe.searchMember(jday_);
				if (mem3 != null) {
					mem3.showInfo();
				} else {
					System.out.println("정보가 존재하지 않습니다");
				}
				break;
			case "6":
				System.out.println("시스템 종료");
				run = false;
				break;
			default:
				System.out.println("메뉴 번호를 입력해주세요.");
			}
		} // end of while.
	}
}
