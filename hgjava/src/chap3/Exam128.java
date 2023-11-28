package chap3;

import java.util.*;

public class Exam128 {

	public static void main(String[] args) {
		// 문제4
		int pen = 534;
		int stu = 30;
		int pps = pen / stu;
		int remp = pen % stu;
		
		System.out.printf("학생당 연필 수 : %d, 남은 연필 수 : %d \n",pps,remp);
		// 문제5 -> 강제 타입 변환
		
		// 문제6
		int value = 356;
		System.out.println(value/100*100);
		
		//문제7 =부동소수점 표현 방식 0.1은 0.1보다 큰 값
		//강제 타입 변환 (float)0.1
		
		// 문제8
		// 사다리꼴의 너비 = (윗변 + 아랫변) * 높이 /2
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = ((double) (lengthTop+lengthBottom)*height/2);
		System.out.println(area);
				
		// 문제9
		Scanner sc = new Scanner(System.in);
//		System.out.print("첫번째 수 : ");
//		double num1 = sc.nextDouble();
//		System.out.print("두번째 수 : ");
//		double num2 = sc.nextDouble();
//		if(num2 == 0 || num2 == 0.0) {
//			System.out.print("결과:무한대");
//			
//		}
//		else {
//			System.out.print("결과:"+(num1/num2));
//		}
		
		// 문제10
		int v1 = 10;
		int v2 = 3;
		int v3 = 14;
		double v4 = v1 * v1 * Double.parseDouble(v2 +"." + v3);
		System.out.println("원의 넓이:" + v4);
		
		// 문제11
		System.out.print("아이디:");
		String name = sc.nextLine();
		System.out.print("패스워드:");
		String strpwd = sc.nextLine();
		int passwd = Integer.parseInt(strpwd);
		if(name.equals("java")) {
			if(passwd == 12345) {
				System.out.println("로그인 성공");
			}
			else {
				System.out.println("로그인 실패:패스워드가 틀림");
			}
		}
		else {
			System.out.println("로그인 실패:아이디 존재하지 않음");
		}
	}//end main

}//end class
