package chap4;

import java.util.Scanner;

public class Exam160 {
	
	public static void main(String[] args) {
		//����2 : 3�� ��� ��
		int sum = 0;
		for(int i=1;i<=100;i++) {
			if(i % 3 == 0) {
				sum += i; 
			}
		}
		System.out.println(sum);
		
		//����3
		int sns1 = 0, sns2 = 0;
		while(sns1 + sns2 != 5) {
			sns1 = (int) (Math.random() *6) +1;
			sns2 = (int) (Math.random() *6) +1;
			System.out.printf("(%d,%d)\n",sns1,sns2);
		}
		//����4
		for(int x=1; x<=10; x++) {
			for(int y=1; y<=10; y++) {
				if(4*x + 5*y == 60) {
					System.out.printf("(%d,%d)",x,y);
				}
			}
		}
		System.out.println();
		//����5
		String star = "";
		for(int i=1;i<5;i++) {
			star += "*";
			System.out.println(star);
		}
		//����6
		
		for(int i=1; i<5; i++) {
			star = "";
			for(int j=1; (4-j)>=i; j++) {
				star += " ";
			}
			for(int k=1; k<=i; k++) {
				star += "*";
			}
			System.out.println(star);
		}
		//����7
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		aaa: while(run) {
			System.out.println("-------------------------------------");
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("-------------------------------------");
			System.out.print("����> ");
			String sel = sc.nextLine();
			switch(sel) {
				case "1" : 
					System.out.print("���ݾ�> ");
					String num = sc.nextLine();
					balance += Integer.parseInt(num); 
					break;
				case "2" : 
					System.out.print("��ݾ�> ");
					int num2 = Integer.parseInt(sc.nextLine());
					if(balance>=num2) {
					balance += -num2;
					}
					else {
						System.out.println("�ܰ� �����մϴ�");
					}
					break;
				case "3" : System.out.printf("�ܰ�> %d\n",balance); break;
				case "4" : 
					System.out.println("���α׷� ����");
					run = false; break;
//					break aaa;
				default : System.out.println("�߸��� ���Դϴ�"); break;
			}
		}
	}//end main
}//end class
