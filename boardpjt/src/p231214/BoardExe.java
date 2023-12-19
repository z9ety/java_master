package p231214;

import java.sql.*;
import java.util.ArrayList;

public class BoardExe {
	Connection comd;
	PreparedStatement sqlin;
	ResultSet rs;

	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB 호스트 정보
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // jar 파일에서 클래스정보를 가져옴
			comd = DriverManager.getConnection(url, "dev", "dev"); // DB 호스트 정보, 사용자 이름, 비밀번호
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comd;
	}

	void disconn() {
		try {
			if (sqlin != null)
				sqlin.close();
			if (rs != null)
				rs.close();
			if (comd != null)
				comd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		} finally {
			disconn();
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
		} finally {
			disconn();
		}
		return false;
	}

	boolean addUser(Account adU) {
		getConn();
		try {
			sqlin = comd.prepareStatement("insert into accountinfo values(?,?,?) ");
			sqlin.setString(1, adU.getUser_id());
			sqlin.setString(2, adU.getUser_pw());
			sqlin.setString(3, adU.getUser_nick());

			int vchange = sqlin.executeUpdate();
			if (vchange == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	boolean checkUser(Account user) {
		getConn();
		try {
			sqlin = comd.prepareStatement("select * from accountinfo ");
			rs = sqlin.executeQuery();
			while (rs.next()) {
				if (user.getUser_id().equals(rs.getString("user_id"))
						&& user.getUser_pw().equals(rs.getString("user_pw"))) {
					user.setUser_nick(rs.getString("user_nick"));
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	boolean modifyID(String before, String after) {
		getConn();
		try {
			sqlin = comd.prepareStatement("update accountinfo set user_id = ? where user_id = ? ");
			sqlin.setString(1, after);
			sqlin.setString(2, before);
			int vchange = sqlin.executeUpdate();
			if (vchange > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	boolean modifyPW(String before, String after) {
		getConn();
		try {
			sqlin = comd.prepareStatement("update accountinfo set user_pw = ? where user_pw = ? ");
			sqlin.setString(1, after);
			sqlin.setString(2, before);
			int vchange = sqlin.executeUpdate();
			if (vchange > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	boolean modifyNN(String before, String after) {
		getConn();
		try {
			sqlin = comd.prepareStatement("update accountinfo set user_nick = ? where user_nick = ? ");
			sqlin.setString(1, after);
			sqlin.setString(2, before);
			int vchange = sqlin.executeUpdate();
			if (vchange > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	ArrayList<Board> getUserBoardRecord(String user) {
		getConn();
		ArrayList<Board> records = new ArrayList<Board>();
		try {
			sqlin = comd.prepareStatement("select * from board where board_writer = ? order by 1 ");
			sqlin.setString(1, user);
			rs = sqlin.executeQuery();
			while (rs.next()) {
				Board record = new Board();
				record.setBd_no(rs.getInt("board_no"));
				record.setBd_id(rs.getString("board_id"));
				record.setBd_title(rs.getString("board_title"));
				record.setBd_writer(rs.getString("board_writer"));
				record.setBd_date(rs.getString("board_date"));
				record.setBd_joins(rs.getInt("board_joins"));
				records.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return records;
	}

	void deleteAccount(String userid) {
		getConn();
		try {
			sqlin = comd.prepareStatement("delete accountinfo where user_id = ? ");
			sqlin.setString(1, userid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
	}
}
