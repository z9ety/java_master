package chap5;

public class ArrayExe2 {

	public static void main(String[] args) {
		
		// ������ ���� �� �ִ� �迭�� ����(ũ��� 10�� ������ ����)
		int[] intAry = new int[10];
		for(int i = 0; i < intAry.length; i++) {
			// intAry => 10 ~100 ����
			intAry[i] = 10 * (i + 1);
			// ���
			System.out.println(intAry[i]);
		}
		
		// ��� : Ȯ�� for��
		int sum = 0;	// 50���� ū ���� ����
		double avg = 0;
		int count = 0;
		for(int num : intAry) {	// num�� �迭�� "��"�� �ݺ��ؼ� ����
			System.out.println(num);
			// 50���� ū ���� sum�� ������
			if(num > 50) {
				sum += num;	
				count++;
			}
		}
		avg = (double)sum / count;
		
		System.out.println("50���� ū ���� �հ� : " + sum);
		System.out.println("50���� ū ���� ��� : " + avg);
	}

}
