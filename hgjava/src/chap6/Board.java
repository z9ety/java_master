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
		Date today = new Date(); // 시스템시간을 기준으로 생성.
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
//		System.out.println("["+num+"]   \t제목 : "+title+"\n작성자 : "+writer+"\n내용 : "+txt+"\n일시 : "+day);
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
//		번호: 1/ 제목:자바게시판입니다
//		작성자: user01
//		내용: 오늘은 숙제로 자바게시판을 만들어 봅시다.
//		일시: 2023-11-28
		String result = "번호: " + num +"/ 제목: "+ title;
		result += "\n작성자: " + writer;
		result += "\n내용: " + txt;
		result += "\n일시: " + day;
		return result;
	}
	int getBoardNo() {
		return num;
	}
	String getWriter() {
		return writer;
	}
}//end class