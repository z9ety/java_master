package chap5;

import java.util.Scanner;

public class WhileExe1 {

	public static void main(String[] args) {

		// for :  �ݺ�Ƚ���� �������ִ� ���
		
		//while : ������ �����ϴ� ���� �ݺ�
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.print("���ڰ��� �Է��ϼ��� > ");
			String txt = scn.nextLine();
			if(txt.equals("quit")) {
				System.out.println("���α׷��� �����մϴ�");
				break;
			}
			System.out.println("�Է°��� " + txt + " �Դϴ�.");
		}
		scn.close();
		System.out.println("end of prog.");
	}

}
