package todo.p20231206;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductExe {
	static List<Product> products;
	private Scanner sc = new Scanner(System.in);

	ProductExe() {
		products = new ArrayList<>();
		products.add(new Product("P001", "����", 1000));
		products.add(new Product("P002", "����", 1200));
		products.add(new Product("N001", "��Ʈ100", 1000));
		products.add(new Product("N002", "���̾", 3000));
	}

	void addProduct() {
		System.out.print("��ǰ�ڵ��Է�>> ");
		String code_ = sc.nextLine();
		System.out.print("��ǰ���Է�>> ");
		String name_ = sc.nextLine();
		System.out.print("��ǰ�����Է�>> ");
		int price_ = Integer.parseInt(sc.nextLine());
		products.add(new Product(code_, name_, price_));
		
	}

	void modifyProduct() {
		System.out.print("���ݼ����� ��ǰ�ڵ��Է�>> ");
		String code_ = sc.nextLine();
		System.out.print("�����Է�>> ");
		int price_ = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getCode() == code_) {
				products.get(i).setPrice(price_);
			}
		}
	}

	void getProductList() {
		System.out.println("��ǰ�ڵ�    \t��ǰ��       \t����");
		System.out.println("=====================================");
		for (int i = 0; i < products.size(); i++) {
			System.out.printf("%-8s\t%-10s\t%d\n", products.get(i).getCode(), products.get(i).getName(),
					products.get(i).getPrice());
		}
	}
}
