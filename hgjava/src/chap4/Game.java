package chap4;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		// 1~50 : 369����
//		
//		// 3, 6, 9 ���� üũ ����
//		String a = "";
//		// ���� 1~50 �ݺ���
//		for(int i=1; i<=50; i++) {
//			// ���� �ڸ��� 3, 6, 9 ���� üũ
//			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
//				a += "��";
//			}
//			else if(i / 10 != 3 && i / 10 != 6 && i / 10 != 9){
//				a += i;
//			}
//			if(i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
//				a += "��";
//			}			
//			a += "\t";
//			if(i % 10 == 0) {
//			a += "\n";
//			}
//			// ���� �ڸ��� 3, 6, 9 ���� üũ
//		
//		// ������ 0 -> ����
//		// ������ 1 -> ��
//		// ������ 2 -> ����
//		}
//		System.out.printf("%s",a);
//		
//		//���� ��ȯ
//		System.out.print("##��ȯ�� �ݾ� : ");
//		int money = sc.nextInt();
//		int r = 0;
//		System.out.printf("500�� ¥�� : %d\n", money / 500);
//		r = money % 500;
//		System.out.printf("100�� ¥�� : %d\n", r / 100);
//		r %= 100;
//		System.out.printf("50�� ¥�� : %d\n", r / 50);
//		r %= 50;
//		System.out.printf("10�� ¥�� : %d\n", r / 10);
//		r %= 10;
//		System.out.printf("��ȯ �ݾ� : %d\n", money-r);
//		System.out.printf("���� �ݾ� : %d\n", r);
//		
//		//���� ����
//		int guess = (int) (Math.random() * 100) + 1;
//		System.out.print("���� �Է� : ");
//		while(true) {
//			int in = sc.nextInt();
//			if(in < guess) {
//				System.out.println("up!");
//				System.out.print("���� �Է� : ");
//			}
//			else if(in > guess) {
//				System.out.println("down!");
//				System.out.print("���� �Է� : ");
//			}
//			else {
//				System.out.println("�����մϴ�!");
//				break;
//			}
//		}
//		
//		//������
//		for(int i=1; i<=9; i++) {
//			for(int j=2; j<=9; j++) {
//				if(i == 1) {
//					System.out.printf("%3d��",j);
//				}
//				else {
//					System.out.printf("%dx%d = %2d ",j,i,i*j);
//				}
//			}
//			System.out.println();
//		}
	}//end main
}//end class
