package chap05;

public class ArrayExe1 {

	public static void main(String[] args) {
		
		int[] ary = { 10, 20, 33, 25, 34 };		//�迭 ���� + ũ�� 3¥�� �迭�� �� �ʱ�ȭ
		
		int sum = 0;
		for (int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		System.out.println("�հ�� " + sum + "�Դϴ�.");
		
		int[] intAry = new int[5];		//new ������ int �迭 ũ�⸸ ����
		System.out.println(intAry[1]);	//int �迭 �⺻�� 0
		
		String[] names = new String[10];	//new ������ String �迭 ����
		names[0] = "ȫ�浿";
		names[1] = "��浿";
		System.out.println(names[0]);
		System.out.println(names[2]);		//String �迭 �⺻�� null
		
		
	}

}
