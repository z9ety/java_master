package chap6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardExe {
	static Board[] boards;

	BoardExe() {
		// boards = new Board[100];
	}

	static {
		boards = new Board[100];
	}

	// �ʱⰪ ����.
	public static void initData() {
		boards[0] = new Board(1, "ù��° ��", "user01", "����", "23-11-27");
		boards[1] = new Board(2, "�ι�° ��", "user02", "����2", "23-11-27");
		// boards[2] <--- 5����.
		boards[3] = new Board(4, "�׹�° ��", "user04", "����4", "23-11-28");
		boards[2] = new Board(3, "����° ��", "user03", "����3", "23-11-28");
		boards[4] = new Board(5, "�ټ���° ��", "user03", "����5", "23-11-28");
		boards[5] = new Board(6, "������° ��", "user03", "����6", "23-11-28");
		boards[6] = new Board(7, "�ϰ���° ��", "user03", "����7", "23-11-28");
		boards[7] = new Board(8, "������° ��", "user03", "����8", "23-11-28");
	}

	// ���. �۹�ȣ/����/�ۼ���/����/�ۼ����� => ��ȯ��: boolean.
	public static boolean addBoard(Board board) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = board;
				return true; // break; // �ݺ��� ����.
			}
		}
		return false;
	}

	// ���. ��ȯ��: �迭
	public static Board[] boardList() {
		/////////////////////////////
		// �����۾�.
		Board temp = null;
		for (int j = 0; j < boards.length - 1; j++) {
			// ��ġ�����۾�.
			for (int i = 0; i < boards.length - 1; i++) {
				if (boards[i] != null && boards[i + 1] != null) {
					if (boards[i].getBoardNo() > boards[i + 1].getBoardNo()) {
						temp = boards[i];
						boards[i] = boards[i + 1];
						boards[i + 1] = temp;
					}
				}
			}
		}
		/////////////////////////////
		// boards => ���ο� �迭�� ���ĵ� ������ ��ȯ.
		return boards;
	}// end of boardList().

	// �迭, ������ => �������� 5���� ��ȯ.
	public static Board[] pageList(Board[] ary, int page) {
		Board[] resultAry = new Board[5];

		int start = (page - 1) * 5;
		int end = page * 5;
		int j = 0;
		for (int i = 0; i < ary.length; i++) {
			if (i >= start && i < end) {
				resultAry[j++] = ary[i];
			}
		}
		return resultAry;
	}

	// �ܰ���ȸ. �Ű�����: �۹�ȣ, ��ȯ��: Board
	public static Board getBoard(int boardNo) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == boardNo) {
				return boards[i];
			}
		}
		return null;
	}

	// �űԹ�ȣ : ����۹�ȣ+1
	public static int getSequence() {
		int seqNo = 1;
		// �迭���� �۹�ȣ�� max��������.
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() > max) {
				max = boards[i].getBoardNo();
			}
		}
		seqNo = max + 1;
		return seqNo;
	}

	// ����. �Ű���(�۹�ȣ, ����) => boolean.
	public static boolean modBoard(int no, String content) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		////
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == no) {
				boards[i].setContent(content);
				////
				boards[i].setWriteDate(sdf.format(today));
				////
				return true;
			}
		}
		return false;
	}

	// ����. �Ű���(�۹�ȣ) => boolean.
	public static boolean remBoard(int no) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == no) {
				boards[i] = null;
				return true;
			}
		}
		return false;
	}

	// ����ڰ� �ش�۹�ȣ�� ����, �������� üũ. => boolean.
	public static boolean checkResponsibility(String id, int no) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == no && boards[i].getWriter().equals(id)) {
				return true;
			}
		}
		return false;
	} // end of checkResponsibility

	// �Խñ��� ��� �ִ� �迭���� ���� �ִ� �Ǽ��� ��ȯ.
	public static int getBoardCount() {
		int realCnt = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				realCnt++;
			}
		}
		return realCnt;
	}
}// end class
