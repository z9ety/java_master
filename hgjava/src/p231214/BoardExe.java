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
			comd = DriverManager.getConnection(url, "dev", "dev"); // 사용자 호스트 정보, 사용자 이름, 비밀번호
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
