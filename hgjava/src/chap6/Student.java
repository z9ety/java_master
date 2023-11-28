package chap6;

public class Student {
	private String stuNo;
	private String stuName;
	private int stuEng;
	private int stuMath;
	
	Student(String stuNo, String stuName, int stuEng, int stuMath){
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuEng = stuEng;
		this.stuMath = stuMath;
	}
	
	void showInfo() {
		System.out.println("번호 : " + stuNo + "   \t이름 : " + stuName + "   \t영어 : " + stuEng + "점   \t수학 : " + stuMath + "점");
	}
	
	String getStudentNo() {
		return stuNo;
	}
	String getStudentName() {
		return stuName;
	}
	int getStudentEng() {
		return stuEng;
	}
	int getStudentMath() {
		return stuMath;
	}
}//end class
