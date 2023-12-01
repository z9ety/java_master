package chap5;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int studentsNum = 0;
		int[] scores = null;	//�ʱⰪ �����ؾ� .length ���� �ȶ�
		String[] names = null;
		
		while(run) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("| 1.�л� �� | 2.���� �Է� | 3.��� ��� | 4.�м� | 5.���� |");
			System.out.println("-----------------------------------------------------------");
			System.out.print("���ڸ� �Է��ϼ��� > ");
			int menu = scn.nextInt();	
			
			switch(menu) {
			case 1 : 
				System.out.print("�л� �� �Է� >> ");
				studentsNum = scn.nextInt();	//3 enter => 3�� �а� ���� ó�� ����
				scn.nextLine();
				scores = new int[studentsNum];
				names = new String[studentsNum];
				break;
			case 2 : 
				System.out.println("���� �Է� >> ");
				for(int i = 0; i < scores.length; i++) {
					System.out.printf("names[%d] >> ", i);
					names[i] = scn.nextLine();	//netInt���� ���� ó�� ���ϸ� ���⼭ ���� ó�� => �׳� �Ѿ��
					System.out.printf("scores[%d] >> ", i);
					scores[i] = scn.nextInt();
					scn.nextLine();
				}
				break;
			case 3 : 
				System.out.println("��� ��� >> ");
				for(int i = 0; i < scores.length; i++) {
					System.out.printf("�̸��� %s, ������ %d�� �Դϴ�.\n", names[i], scores[i]);
				}
				break;
			case 4 : 
				System.out.println("�м� >> ");
				int maxScore = scores[0];
				int sum = 0;
				String maxName = null;
				for(int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if(maxScore < scores[i]) {
						maxScore = scores[i];
						maxName = names[i];
					}
				}
				double avg = (double)sum / scores.length;
				
				System.out.printf("�ְ����� : %s�� ���� %d\n", maxName, maxScore);
				System.out.println("��� : " + avg);
				
				break;
			case 5 : 
				System.out.print("���� >> ");
				run = false;
				break;
				
			}	// end of switch
			
		}	// end of while
		scn.close();
		
	}

}
