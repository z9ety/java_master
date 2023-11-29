package chap05;

import java.util.Scanner;

public class StudentApp2 {
	static Scanner scn = new Scanner(System.in);
	static Student[] students = null;
	
	public static void addStudent() {
		System.out.println("�л� ���� �Է� >> ");
		for(int i = 0; i < students.length; i++) {
			Student student = new Student();
			System.out.printf("[%d]�� �л� �̸� �Է� >> ", i);
			student.name = scn.nextLine();
			System.out.printf("[%d]�� �л� ���� �Է� >> ", i);
			student.score = Integer.parseInt(scn.nextLine());
			System.out.printf("[%d]�� �л� ���� �Է� >> ", i);
			student.gender = scn.nextLine();
			students[i] = student;
		}
	} // end of addStudent()
	
	public static void analysis() {
		System.out.println("�м� >> ");
		int sumOfMen = 0, countOfMen = 0;
		int sumOfWomen = 0, countOfWomen = 0;
		
		for(Student stdnt : students) {
			if(stdnt.gender.equals("��")) {
				sumOfMen += stdnt.score;
				countOfMen++;
			}
			else if(stdnt.gender.equals("��")) {
				sumOfWomen += stdnt.score;
				countOfWomen++;
			}
		}
		System.out.println("���л��� ��� : " + (double)sumOfMen / countOfMen);
		System.out.println("���л��� ��� : " + (double)sumOfWomen / countOfWomen);
	} // end of analysis()
	
	public static void searchStudent() {
		System.out.print("�л� ��ȸ >> ");
		String name = scn.nextLine();
		boolean exist = false;
		for(Student stdnt : students) {
			if(name.equals(stdnt.name)) {
				System.out.printf("�̸��� %s, ������ %d, ������ %s\n", stdnt.name, stdnt.score, stdnt.gender);
				exist = true;
			}
		}				
		if(!exist) System.out.println("ã�� �̸��� �����ϴ�.");
	} // end of searchStudent()
	
	public static void modify() {
		//�̸� �Է� - ������ ���� ���� �Է�
		System.out.print("��ȸ�� �̸� �Է� >> ");
		String name = scn.nextLine();
		boolean exist = false;
		for (int i = 0; i < students.length; i++) {
			if(name.equals(students[i].name)) {
				System.out.print("���� ���� �Է� >> ");
				students[i].score = Integer.parseInt(scn.nextLine());
				exist = true;
			}
		}
		if(!exist) System.out.println("ã�� �̸��� �����ϴ�.");
	} // end of modify()

	public static void main(String[] args) {

		boolean run = true;
		
		int studentNum = 0;
		
		while(run) {
			System.out.println("---------------------------------------------------------------------");
			System.out.println("| 1.�л� �� | 2.�л� ���� �Է� | 3.��ȸ | 4.�м� | 5.���� | 6. ���� |");
			System.out.println("---------------------------------------------------------------------");
			System.out.print("���ڸ� �Է��ϼ��� >> ");
			int menu = Integer.parseInt(scn.nextLine());	// 3 enter
			
			switch(menu) {
			case 1:
				System.out.print("�л� �� �Է� >> ");
				studentNum = Integer.parseInt(scn.nextLine());	// "3" (���ڿ�) => 3 (int) �� ��ȯ
				students = new Student[studentNum];
				break;
			case 2:
				addStudent();
				break;
			case 3:
				searchStudent();
				break;
			case 4:
				analysis();
				break;
			case 5:
				modify();
				break;
			case 6:
				System.out.println("���� >> ");
				run = false;
				break;				
			}	// end of switch
		}	// end of while
		scn.close();
	}

}
