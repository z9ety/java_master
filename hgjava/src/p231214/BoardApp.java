package p231214;

import java.util.*;

public class BoardApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Board> boards = new ArrayList<Board>();
		BoardExe bexe = new BoardExe();
		boolean run = true;
		int page = 1;
		System.out.printf("\n%20s\n\n", "�����Խ���");
		while (run) {
			ArrayList<Board> boardList = bexe.getBoardList();
			System.out.println("�Խù�ȣ \t �з� \t ���� \t �۾��� \t ��ϳ�¥ \t ��ȸ��");
			for (int L = (page * 10) - 9; L <= page * 10; L++) {
				boardList.get(L).showInfo();
			}
			System.out.printf("  %-10s<%d>", "[�۾���]", page);
			String sel = sc.nextLine();
			switch (sel) {
			case ">":
				page++;
				break;
			case "<":
				page--;
				break;
			case "�۾���":

				break;
			case "x":
				System.out.println("�׽�Ʈ ����.");
				run = false;
				break;
			default:

			}
		}
	}
}
