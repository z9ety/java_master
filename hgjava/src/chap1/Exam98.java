package chap1;

import java.util.Scanner;

public class Exam98 {

	public static void main(String[] args) {
		//1��
		String name = "���ڹ�";
		int age = 25;
		String tel1="010", tel2="123", tel3="4567";
		System.out.println("�̸�: " + name);
		System.out.print("����: " + age);
		System.out.printf("\n��ȭ: %s-%s-%s",tel1,tel2,tel3);
		
		//2��
		Scanner sc = new Scanner(System.in);
		System.out.print("\nù��° ��:");
		String strNum1 = sc.nextLine();
		System.out.print("�ι�° ��:");
		String strNum2 = sc.nextLine();
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("���� ���:" + result);
		
		//3��
		System.out.print("1. �̸�:");
		name = sc.nextLine();
		System.out.print("2. �ֹι�ȣ �� 6�ڸ�:");
		String ad = sc.nextLine();
		System.out.print("3. ��ȭ��ȣ:");
		String tel = sc.nextLine();
		System.out.printf("1. �̸�:%15s\n2. �ֹι�ȣ �� 6�ڸ�:%17s\n3. ��ȭ��ȣ:%17s",name,ad,tel);
		sc.close();
	}//end main

}//end class
