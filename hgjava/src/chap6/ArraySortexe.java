package chap6;

public class ArraySortexe {
	public static void main(String[] args) {
		int[] numAry = {6, 2, 1, 5, 4, 3};
		
		// �����۾�.
		int temp = 0;
		for(int j=0; j<numAry.length-1; j++) {
			//��ġ�����۾�.
			for(int i=0; i<numAry.length-1; i++) {
				if(numAry[i] > numAry[i+1]) {
					temp = numAry[i];
					numAry[i] = numAry[i+1];
					numAry[i+1] = temp;
				}
			}
		}
		for(int num : numAry)
			System.out.println(num);
	}
}
