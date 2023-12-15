package p231214;

import java.sql.*;
import java.util.ArrayList;

public class BoardExe {
	Connection comd;
	PreparedStatement sqlin;
	ResultSet rs;

	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB ȣ��Ʈ ����
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // jar ���Ͽ��� Ŭ���������� ������
			comd = DriverManager.getConnection(url, "dev", "dev"); // DB ȣ��Ʈ ����, ����� �̸�, ��й�ȣ
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comd;
	}

	ArrayList<Board> getBoardList() {
		getConn();
		ArrayList<Board> boards = new ArrayList<Board>();
		try {
			sqlin = comd.prepareStatement("select * from board order by 1 ");
			rs = sqlin.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBd_no(rs.getInt("board_no"));
				board.setBd_id(rs.getString("board_id"));
				board.setBd_title(rs.getString("board_title"));
				board.setBd_writer(rs.getString("board_writer"));
				board.setBd_date(rs.getString("board_date"));
				board.setBd_joins(rs.getInt("board_joins"));
				boards.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boards;
	}

	boolean addBoard(Board adB) {
		getConn();
		try {
			sqlin = comd.prepareStatement("insert into board values(?,?,?,?,?,?,?) ");
			sqlin.setInt(1, adB.getBd_no());
			sqlin.setString(2, adB.getBd_id());
			sqlin.setString(3, adB.getBd_title());
			sqlin.setString(4, adB.getBd_inside());
			sqlin.setString(5, adB.getBd_writer());
			sqlin.setString(6, adB.getBd_date());
			sqlin.setInt(7, adB.getBd_joins());

			int vchange = sqlin.executeUpdate();
			if (vchange == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	boolean addUser(Account adU) {
		getConn();
		try {
			sqlin = comd.prepareStatement("insert into accountinfo values(?,?) ");
			sqlin.setString(1, adU.getUser_id());
			sqlin.setString(2, adU.getUser_pw());

			int vchange = sqlin.executeUpdate();
			if (vchange == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
