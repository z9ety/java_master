package chap4;

import java.util.Scanner;

public class Game2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.print("##년도 입력 : ");
//		int year = sc.nextInt();
//		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
//			System.out.printf("%d년은 윤년입니다.\n",year);
//		}
//		else {
//			System.out.printf("%d년은 평년입니다.\n",year);
//		}
		
		//섭씨 화씨
//		Scanner sc2 = new Scanner(System.in);
//		boolean run = true;
//		while(run) {
//			System.out.print("-------------------\n1. 화씨 => 섭씨\n2. 섭씨 => 화씨\n3. 종료\n-------------------\n▶ 번호 선택 : ");
//			String num = sc2.nextLine(); // 같은 스캐너에서 함수가 다른 종류로 바뀌면 중복으로 읽어버림
//			switch(num) {
//				case "1" :
//					System.out.print("▶ 화씨 온도 입력 : ");
//					double f = (sc.nextDouble() - 32) * 5 / 9;
//					System.out.printf("  섭씨온도 = %.6f\n",f);
//					break;
//				case "2" :
//					System.out.print("▶ 섭씨 온도 입력 : ");
//					double c = (sc.nextDouble() / 5 * 9) + 32;
//					System.out.printf("  화씨온도 = %.6f\n",c);
//					break;
//				case "3" :
//					System.out.println("program end");
//					run = false;
//					break;
//				default : System.out.println("잘못된 값입니다."); break;
//			}
//		}
//		int mw = 0, cw = 0;
//		boolean run = true;
//		while(mw < 3 && cw < 3) {
//			int com = (int) (Math.random() *3) + 1;
//			System.out.print("## 가위(1) 바위(2) 보(3) : ");
//			int man = sc.nextInt();
//			if(man == com) {
//				System.out.printf("사람 %d, 컴 %d 비겼음\n",man,com);
//			}
//			else if(man - com == man - 2)
//		}
	}//end main
}//end class