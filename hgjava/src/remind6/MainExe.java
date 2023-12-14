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
			System.out.println("���Ἲ��!!");
			select();
			String sql = "insert into student(student_number, student_name, english_score, mathmatic_score) "
					+ "values(?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, "23-003");
			psmt.setString(2, "�ھ�");
			psmt.setInt(3, 80);
			psmt.setInt(4, 85);

//			 �Է�, ����, ���� => executeUpdate();
			int r = psmt.executeUpdate();
			if (r == 1) {
				System.out.println("�Է¼���.");
			}
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("Driver ����.");
		}
	}// main.

	public static void select() throws Exception {
		String sql = "select * from student";
		PreparedStatement psmt = conn.prepareStatement(sql);
		ResultSet rs = psmt.executeQuery();
		while (rs.next()) {
			System.out.println("��ȣ:" + rs.getString("student_number")//
					+ ", �̸�:" + rs.getString("student_name")//
					+ ", ����:" + rs.getInt("english_score")//
					+ ", ����:" + rs.getInt("mathmatic_score"));
		}
	}
}