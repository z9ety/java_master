package remind6;

import java.sql.*;

public class MainExe {
	static Connection conn;

	public static void main(String[] args) {
		// jdbc lib
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결성공!!");
			select();
			String sql = "insert into student(student_number, student_name, english_score, mathmatic_score) "
					+ "values(?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, "23-003");
			psmt.setString(2, "박씨");
			psmt.setInt(3, 80);
			psmt.setInt(4, 85);

//			 입력, 수정, 삭제 => executeUpdate();
			int r = psmt.executeUpdate();
			if (r == 1) {
				System.out.println("입력성공.");
			}
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("Driver 없음.");
		}
	}// main.

	public static void select() throws Exception {
		String sql = "select * from student";
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			System.out.println("번호:" + rs.getString("student_number")//
					+ ", 이름:" + rs.getString("student_name")//
					+ ", 영어:" + rs.getInt("english_score")//
					+ ", 수학:" + rs.getInt("mathmatic_score"));
		}
	}
}