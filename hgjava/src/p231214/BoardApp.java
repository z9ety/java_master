package p231214;

import java.util.*;

public class BoardApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Board> boards = new ArrayList<Board>();
		BoardExe bexe = new BoardExe();
		boolean run = true;
		int page = 1;
		System.out.printf("\n%20s\n\n", "자유게시판");
		while (run) {
			ArrayList<Board> boardList = bexe.getBoardList();
			System.out.println("게시번호 \t 분류 \t 제목 \t 글쓴이 \t 등록날짜 \t 조회수");
			for (int L = (page * 10) - 9; L <= page * 10; L++) {
				boardList.get(L).showInfo();
			}
			System.out.printf("  %-10s<%d>", "[글쓰기]", page);
			String sel = sc.nextLine();
			switch (sel) {
			case ">":
				page++;
				break;
			case "<":
				page--;
				break;
			case "글쓰기":

				break;
			case "x":
				System.out.println("테스트 종료.");
				run = false;
				break;
			default:

			}
		}
	}
}
