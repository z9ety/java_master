package todo.p20231206;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductExe {
	static List<Product> products;
	private Scanner sc = new Scanner(System.in);

	ProductExe() {
		products = new ArrayList<>();
		products.add(new Product("P001", "볼펜", 1000));
		products.add(new Product("P002", "연필", 1200));
		products.add(new Product("N001", "노트100", 1000));
		products.add(new Product("N002", "다이어리", 3000));
	}

	void addProduct() {
		System.out.print("상품코드입력>> ");
		String code_ = sc.nextLine();
		System.out.print("상품명입력>> ");
		String name_ = sc.nextLine();
		System.out.print("상품가격입력>> ");
		int price_ = Integer.parseInt(sc.nextLine());
		products.add(new Product(code_, name_, price_));
		
	}

	void modifyProduct() {
		System.out.print("가격수정할 상품코드입력>> ");
		String code_ = sc.nextLine();
		System.out.print("가격입력>> ");
		int price_ = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getCode() == code_) {
				products.get(i).setPrice(price_);
			}
		}
	}

	void getProductList() {
		System.out.println("상품코드    \t상품명       \t가격");
		System.out.println("=====================================");
		for (int i = 0; i < products.size(); i++) {
			System.out.printf("%-8s\t%-10s\t%d\n", products.get(i).getCode(), products.get(i).getName(),
					products.get(i).getPrice());
		}
	}
}
