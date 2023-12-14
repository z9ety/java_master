package remind6;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		StudentExe exe = new StudentExe();
		StudentDAO dao = new StudentDAO();
		while (run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(scn.nextLine()); // "1"

			switch (menu) {

			case 1: // 추가.
				System.out.print("학생번호입력>> ");
				String no = scn.nextLine();
				System.out.print("학생이름입력>> ");
				String name = scn.nextLine();
				System.out.print("영어점수입력>> ");
				int eng = Integer.parseInt(scn.nextLine());
				System.out.print("수학점수입력>> ");
				int mat = Integer.parseInt(scn.nextLine());
				Student std = new Student(no, name, eng, mat);
				// students 배열에 한건 저장.
				if (dao.addStudent(std)) {
					System.out.println("저장되었습니다.");
				} else {
					System.out.println("저장 중 오류.");
				}
				break;

			case 2: // 목록보기.
				Student[] stdAry = dao.getStudentList();
				for (Student stdnt : stdAry) {
					if (stdnt != null) {
						stdnt.showInfo();
					}
				} // Student[] 타입

				break;
			case 3: // 단건조회.
				System.out.println("조회할 학생번호 입력>>>>");
				no = scn.nextLine();
				Student stnt = dao.getStudent(no);
				if (stnt != null) {
					stnt.showInfo();
				} else {
					System.out.println("존재하지 않는 정보.");
				}
				break;
			case 4: // 수정.
				System.out.println("수정할 학생번호 입력>>>>");
				no = scn.nextLine();
				System.out.print("영어점수수정>> ");
				eng = Integer.parseInt(scn.nextLine());
				System.out.print("수학점수수정>> ");
				mat = Integer.parseInt(scn.nextLine());
				if (dao.modifyStudent(no, eng, mat)) {
					System.out.println("수정 완료");
				} else {
					System.out.println("찾을 수 없습니다");
				}
				break;
			case 5:///
				System.out.println("삭제할 학생이름 입력>>>>");
				name = scn.nextLine();
				if (dao.removeStudent(name)) {
					System.out.println("삭제 완료.");
				} else {
					System.out.println("삭제 실패.");
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}
		} // end of while.
		System.out.println("end of prog.");
	}// end main
}// end class
