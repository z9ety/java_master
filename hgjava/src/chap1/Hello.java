package chap1;

import java.io.IOException;
import java.util.Scanner;

public class Hello {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		System.out.println("hello java");
		int x = 5;
		int y = x + 10;
		System.out.println(y);
		
		double z = 3.5;
		System.out.print(z + "\n");
		System.out.print("y = " + y + "\n");
		
		//������ ����ȯ
		x = 3;
		y = 10;
		//�� ��ȯ
		int temp = x;
		x = y;
		y = temp;
		
		//���
		System.out.println("x:" + x + ", y:" + y);
		
		//�⺻ Ÿ��
		//ũ����� byte<short<char(����ǥ�� �ȵ�)<int<long
		
		char charData = 'A';
		int intData = charData;
		
		System.out.println("char : " + charData + ", intcode : " + intData);
		
		char c1 = 'a';
		int c2 = c1 + 2; //�ڵ� Ÿ�� ��ȯ
		char c3 = (char) c2;//���� Ÿ�� ��ȯ
		System.out.printf("c2���� : %d, c3���� : %s \n",c2,c3);
		x = 5;
		y = 2;
		double result = (double)x / y ;
		System.out.println(result);
		
		double v1 = 3.5;
		double v2 = 2.7;
		int result2 = (int) (v1 + v2);
		System.out.println(result2);
		
		long va1 = 2L;
		float va2 = 1.8f;
		double va3 = 2.5;
		String va4 = "3.9";
		int result3 = (int) ((va1 + va2 + va3)+ (int)(Double.parseDouble(va4)));
		System.out.println(result3);
		System.out.printf("%s ���ִ�","���ڹ�");
		
		//ǥ�� �Է� : Ű���� => System.in.read()
		//�ѱ��ڸ� �о����
//		int keyCode;
//		while(true) {
//			keyCode = System.in.read();
//			System.out.println("keyCode : " + keyCode);
//			if(keyCode == 113) {
//				break;
//			}
//		}
//		System.out.println("����");
		
		//���ڿ� �Է� -> Scanner Ŭ���� -> ��ü�� �����ؼ� ���
		String scinput;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("�̸� �Է� : ");
			scinput = sc.nextLine();
			if(scinput.equals("q")) {
				break;
			}
			System.out.println("�� �̸��� " +scinput);
		}
		System.out.println("����");
		
		System.out.print("�� �Է� : ");
		scinput = sc.nextLine();
		System.out.println(Integer.parseInt(scinput) + 10);

		sc.close();
		
	}// end main
}//end class
