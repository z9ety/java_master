package todo.p20231206;

import java.time.LocalDate;
import java.util.Scanner;

public class ProductApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductExe pexe = new ProductExe();
		InOutExe ioexe = new InOutExe();
		boolean run = true;
		
		while (run) {
			System.out.println("1.상품관리 2.입출고관리 3.종료");
			System.out.print("메뉴 선택 : ");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				System.out.println("1-1)등록 1-2)수정 1-3)목록");
				System.out.print("선택 : ");
				int menu1 = Integer.parseInt(sc.nextLine());
				switch (menu1) {
				case 1:
					pexe.addProduct();
					System.out.println("등록 완료");
					break;
				case 2:
					pexe.modifyProduct();
					System.out.println("수정 완료");
					break;
				case 3:
					pexe.getProductList();
					break;
				default:
					System.out.println("잘못된 값입니다");
				}
				break;
			case 2:
				System.out.println("2-1)판매 2-2)구매 2-3)재고");
				System.out.print("선택 : ");
				int menu2 = Integer.parseInt(sc.nextLine());
				switch (menu2) {
				case 1:
					ioexe.Out();
					break;
				case 2:
//					ioexe.In();
					break;
//					ioexe.Products();
				case 3:
					break;
				default:
					System.out.println("잘못된 값입니다");
				}
				break;
			case 3:
				System.out.println("시스템 종료");
				run = false;
			default:
				System.out.println("잘못된 값입니다");
			}
		} // end of while.
	}

}
