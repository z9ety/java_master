package chap6;

public class Board {
	private int num;
	private String title;
	private String writer;
	private String txt;
	private String day;
	
	Board(int num1, String title1, String writer1, String txt1, String day1){
		this.num = num1;
		this.title = title1;
		this.writer = writer1;
		this.txt = txt1;
		this.day = day1;
	}
	void showInfo() {
		System.out.println("["+num+"]   \t"+title+"   \t"+writer);
	}
	void showInfo2() {
		System.out.println("["+num+"]   \t제목 : "+title+"\n작성자 : "+writer+"\n내용 : "+txt+"\n일시 : "+day);
	}
	int getNum() {
		return num;
	}
}//end class
