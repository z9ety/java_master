package chap3;

import java.util.*;

public class Exam128 {

	public static void main(String[] args) {
		// ����4
		int pen = 534;
		int stu = 30;
		int pps = pen / stu;
		int remp = pen % stu;
		
		System.out.printf("�л��� ���� �� : %d, ���� ���� �� : %d \n",pps,remp);
		// ����5 -> ���� Ÿ�� ��ȯ
		
		// ����6
		int value = 356;
		System.out.println(value/100*100);
		
		//����7 =�ε��Ҽ��� ǥ�� ��� 0.1�� 0.1���� ū ��
		//���� Ÿ�� ��ȯ (float)0.1
		
		// ����8
		// ��ٸ����� �ʺ� = (���� + �Ʒ���) * ���� /2
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = ((double) (lengthTop+lengthBottom)*height/2);
		System.out.println(area);
				
		// ����9
		Scanner sc = new Scanner(System.in);
//		System.out.print("ù��° �� : ");
//		double num1 = sc.nextDouble();
//		System.out.print("�ι�° �� : ");
//		double num2 = sc.nextDouble();
//		if(num2 == 0 || num2 == 0.0) {
//			System.out.print("���:���Ѵ�");
//			
//		}
//		else {
//			System.out.print("���:"+(num1/num2));
//		}
		
		// ����10
		int v1 = 10;
		int v2 = 3;
		int v3 = 14;
		double v4 = v1 * v1 * Double.parseDouble(v2 +"." + v3);
		System.out.println("���� ����:" + v4);
		
		// ����11
		System.out.print("���̵�:");
		String name = sc.nextLine();
		System.out.print("�н�����:");
		String strpwd = sc.nextLine();
		int passwd = Integer.parseInt(strpwd);
		if(name.equals("java")) {
			if(passwd == 12345) {
				System.out.println("�α��� ����");
			}
			else {
				System.out.println("�α��� ����:�н����尡 Ʋ��");
			}
		}
		else {
			System.out.println("�α��� ����:���̵� �������� ����");
		}
	}//end main

}//end class
