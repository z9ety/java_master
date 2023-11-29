package chap4;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		// 1~50 : 369게임
//		
//		// 3, 6, 9 갯수 체크 변수
//		String a = "";
//		// 숫자 1~50 반복문
//		for(int i=1; i<=50; i++) {
//			// 일의 자리에 3, 6, 9 갯수 체크
//			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
//				a += "♥";
//			}
//			else if(i / 10 != 3 && i / 10 != 6 && i / 10 != 9){
//				a += i;
//			}
//			if(i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
//				a += "♥";
//			}			
//			a += "\t";
//			if(i % 10 == 0) {
//			a += "\n";
//			}
//			// 십의 자리에 3, 6, 9 갯수 체크
//		
//		// 갯수가 0 -> 숫자
//		// 갯수가 1 -> ♥
//		// 갯수가 2 -> ♥♥
//		}
//		System.out.printf("%s",a);
//		
//		//동전 교환
//		System.out.print("##교환할 금액 : ");
//		int money = sc.nextInt();
//		int r = 0;
//		System.out.printf("500원 짜리 : %d\n", money / 500);
//		r = money % 500;
//		System.out.printf("100원 짜리 : %d\n", r / 100);
//		r %= 100;
//		System.out.printf("50원 짜리 : %d\n", r / 50);
//		r %= 50;
//		System.out.printf("10원 짜리 : %d\n", r / 10);
//		r %= 10;
//		System.out.printf("교환 금액 : %d\n", money-r);
//		System.out.printf("남은 금액 : %d\n", r);
//		
//		//숫자 추측
//		int guess = (int) (Math.random() * 100) + 1;
//		System.out.print("숫자 입력 : ");
//		while(true) {
//			int in = sc.nextInt();
//			if(in < guess) {
//				System.out.println("up!");
//				System.out.print("숫자 입력 : ");
//			}
//			else if(in > guess) {
//				System.out.println("down!");
//				System.out.print("숫자 입력 : ");
//			}
//			else {
//				System.out.println("축하합니다!");
//				break;
//			}
//		}
//		
//		//구구단
//		for(int i=1; i<=9; i++) {
//			for(int j=2; j<=9; j++) {
//				if(i == 1) {
//					System.out.printf("%3d단",j);
//				}
//				else {
//					System.out.printf("%dx%d = %2d ",j,i,i*j);
//				}
//			}
//			System.out.println();
//		}
	}//end main
}//end class
