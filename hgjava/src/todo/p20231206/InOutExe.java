package todo.p20231206;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InOutExe {
	static List<InOut> ios;
	static List<InOut> pds;
	private Scanner sc = new Scanner(System.in);
	public LocalDate today = LocalDate.now();

	InOutExe() {
		ios = new ArrayList<>();
		ios.add(new InOut("P001", today, 10, 1));
		ios.add(new InOut("P001", today, 2, 2));
		ios.add(new InOut("P001", today, 3, 2));
		pds = new ArrayList<>();
		pds.add(new InOut("P001", 5));
		pds.add(new InOut("P002", 3));
		pds.add(new InOut("N001", 10));
	}

	void Out() {
		System.out.print("판매할 상품의 코드 입력>> ");
		String code_ = sc.nextLine();
		System.out.print("판매 수량 입력>> ");
		int outs_ = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < pds.size(); i++) {
			if (pds.get(i).getIocode() == code_ && pds.get(i).getPdsum() >= outs_) {
				pds.get(i).setPdsum(pds.get(i).getPdsum() - outs_);
				if (pds.get(i).getPdsum() < outs_) {
					pds.remove(i);
				}
				System.out.println("판매 완료");
				ios.add(new InOut(code_, today, outs_, 2));
			} else {
				System.out.println("수량이 부족합니다");
			}
		}
	}

	void In() {
		System.out.print("구매할 상품의 코드 입력>> ");
		String code_ = sc.nextLine();
		System.out.print("구매 수량 입력>> ");
		int ins_ = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < ProductExe.products.size(); i++) {
			if (ProductExe.products.get(i).getCode() == code_) {
				pds.get(i).setPdsum(pds.get(i).getPdsum() + ins_);
			}
			System.out.println("구매 완료");
			ios.add(new InOut(code_, today, ins_, 2));
		}
	}

	void Products() {

		System.out.println();
	}

	void getIOList() {

	}
}
