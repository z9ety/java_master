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
			comd = DriverManager.getConnection(url, "dev", "dev"); // ����� ȣ��Ʈ ����, ����� �̸�, ��й�ȣ
			System.out.println("------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comd;
	}
	
	ArrayList<Board> getBoardList(){
		getConn();
		try {
			sqlin = comd.prepareStatement("select * from board order by 1 ");
			rs = sqlin.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setBd_no(board.get);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
