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
			System.out.println("1.��ǰ���� 2.�������� 3.����");
			System.out.print("�޴� ���� : ");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				System.out.println("1-1)��� 1-2)���� 1-3)���");
				System.out.print("���� : ");
				int menu1 = Integer.parseInt(sc.nextLine());
				switch (menu1) {
				case 1:
					pexe.addProduct();
					System.out.println("��� �Ϸ�");
					break;
				case 2:
					pexe.modifyProduct();
					System.out.println("���� �Ϸ�");
					break;
				case 3:
					pexe.getProductList();
					break;
				default:
					System.out.println("�߸��� ���Դϴ�");
				}
				break;
			case 2:
				System.out.println("2-1)�Ǹ� 2-2)���� 2-3)���");
				System.out.print("���� : ");
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
					System.out.println("�߸��� ���Դϴ�");
				}
				break;
			case 3:
				System.out.println("�ý��� ����");
				run = false;
			default:
				System.out.println("�߸��� ���Դϴ�");
			}
		} // end of while.
	}

}
