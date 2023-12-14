package todo.p20231214;

import java.sql.*;
import java.util.ArrayList;

public class BookExe {
	private ArrayList<Book> books;
	Connection comd;
	PreparedStatement sqlin;
	ResultSet rs;

	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // DB ȣ��Ʈ ����
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // jar ���Ͽ��� Ŭ���������� ������
			comd = DriverManager.getConnection(url, "dev", "dev"); // ����� ȣ��Ʈ ����, ����� �̸�, ��й�ȣ
			System.out.println("���Ἲ��!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return comd;
	}

	BookExe() {
		books = new ArrayList<Book>();
		books.add(new Book("B001", "�̰��� �ڹٴ�", "�ſ��", 25000));
		books.add(new Book("C003", "�ڹ� ����", "�����", 20000));
		books.add(new Book("D001", "�ڹٸ���Ʈ", "�����", 15000));
	}

	boolean addBook(Book nb) {
		getConn();
//		String sql = "insert into book values(?,?,?,?,?) ";
		try {
			sqlin = comd.prepareStatement("insert into book values(?,?,?,?,?) ");
			sqlin.setString(1, nb.getBookCo());
			sqlin.setString(2, nb.getBookName());
			sqlin.setString(3, nb.getWriter());
			sqlin.setString(4, nb.getMaker());
			sqlin.setInt(5, nb.getPrice());

			int vchange = sqlin.executeUpdate();
			if (vchange == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	ArrayList<Book> getBookList() {
		getConn();
		System.out.println("�����ڵ�  \t ������         \t ����      \t ����");
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			sqlin = comd.prepareStatement("select * from book ");
			rs = sqlin.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBookCo(rs.getString("book_code"));
				book.setBookName(rs.getString("book_name"));
				book.setWriter(rs.getString("book_writer"));
				book.setMaker(rs.getString("book_maker"));
				book.setPrice(rs.getInt("book_price"));
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	boolean modifyBookPrice(String code, int price) {
		getConn();
		try {
			sqlin = comd.prepareStatement("update book set book_price = ? where book_code = ? ");
			sqlin.setInt(1, price);
			sqlin.setString(2, code);
			int vchange = sqlin.executeUpdate();
			if (vchange > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	boolean removeBook(String code) {
		getConn();
		try {
			sqlin = comd.prepareStatement("delete from book where book_code = ? ");
			sqlin.setString(1, code);
			int vchange = sqlin.executeUpdate();
			if (vchange > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
