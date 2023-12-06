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
		System.out.print("�Ǹ��� ��ǰ�� �ڵ� �Է�>> ");
		String code_ = sc.nextLine();
		System.out.print("�Ǹ� ���� �Է�>> ");
		int outs_ = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < pds.size(); i++) {
			if (pds.get(i).getIocode() == code_ && pds.get(i).getPdsum() >= outs_) {
				pds.get(i).setPdsum(pds.get(i).getPdsum() - outs_);
				if (pds.get(i).getPdsum() < outs_) {
					pds.remove(i);
				}
				System.out.println("�Ǹ� �Ϸ�");
				ios.add(new InOut(code_, today, outs_, 2));
			} else {
				System.out.println("������ �����մϴ�");
			}
		}
	}

	void In() {
		System.out.print("������ ��ǰ�� �ڵ� �Է�>> ");
		String code_ = sc.nextLine();
		System.out.print("���� ���� �Է�>> ");
		int ins_ = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < ProductExe.products.size(); i++) {
			if (ProductExe.products.get(i).getCode() == code_) {
				pds.get(i).setPdsum(pds.get(i).getPdsum() + ins_);
			}
			System.out.println("���� �Ϸ�");
			ios.add(new InOut(code_, today, ins_, 2));
		}
	}

	void Products() {

		System.out.println();
	}

	void getIOList() {

	}
}
