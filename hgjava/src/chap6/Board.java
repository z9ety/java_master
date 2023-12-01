package chap6;


import java.text.SimpleDateFormat;
import java.util.Date;

//import lombok.Data;
//@Data
public class Board {
	private int num;
	private String title;
	private String writer;
	private String txt;
	private String day;
	
	Board(int num1, String title1, String writer1, String txt1, String day1){
		Date today = new Date(); // �ý��۽ð��� �������� ����.
//		int year = today.getYear();
//		int month = today.getMonth()+1;
//		int date = today.getDate();
		
		// Date -> String -> Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.num = num1;
		this.title = title1;
		this.writer = writer1;
		this.txt = txt1;
		this.day = sdf.format(today);
//		this.day = year + "-" + month + "-" + date;
//		this.day = day1;
	}
	
//	void showInfo() {
//		System.out.println("["+num+"]   \t"+title+"   \t"+writer);
//	}
//	void showInfo2() {
//		System.out.println("["+num+"]   \t���� : "+title+"\n�ۼ��� : "+writer+"\n���� : "+txt+"\n�Ͻ� : "+day);
//	}
//	int getNum() {
//		return num;
//	}
	
	
	///////////////////////////
	void setContent(String txt) {
		this.txt = txt;
	}
	void setWriteDate(String day) {
		this.day = day;
	}
	String showInfo() {
		return "["+num+"]   \t"+title+"   \t"+writer+ "   \t"+day;
	}
	String showDetailInfo() {
//		��ȣ: 1/ ����:�ڹٰԽ����Դϴ�
//		�ۼ���: user01
//		����: ������ ������ �ڹٰԽ����� ����� ���ô�.
//		�Ͻ�: 2023-11-28
		String result = "��ȣ: " + num +"/ ����: "+ title;
		result += "\n�ۼ���: " + writer;
		result += "\n����: " + txt;
		result += "\n�Ͻ�: " + day;
		return result;
	}
	int getBoardNo() {
		return num;
	}
	String getWriter() {
		return writer;
	}
}//end class