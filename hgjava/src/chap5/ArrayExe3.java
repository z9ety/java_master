package chap5;

public class ArrayExe3 {

	public static void main(String[] args) {
		
		String[] nameArray = {"ȫ�浿", "��浿", "ȫ�浿", "�ڱ浿", "ȫ�浿", "Ȳ�浿"};
		
		String search = "ȫ�浿";
		int count = 0;
		
		for(String name : nameArray) {
			if(search.equals(name)) count++;
		}
		
		System.out.println(search + "�� �� " + count + "�� �Դϴ�.");
		
		
		//�ִ밪, �ּҰ� ã��
		int[] scores = {88, 68, 72, 89, 92, 70};
		int maxScore = scores[0];
		int minScore = scores[0];
		
		for(int num : scores) {
			if(num > maxScore) maxScore = num;
			if(num < minScore) minScore = num;
		}
		
		System.out.println("�ִ밪 : " + maxScore);
		System.out.println("�ּҰ� : " + minScore);
		
	}
}
