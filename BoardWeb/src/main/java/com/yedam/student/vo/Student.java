package com.yedam.student.vo;

import lombok.Data;

@Data
public class Student {
	private String stuNo;
	private String stuName;
	private int stuEng;
	private int stuMath;

	public Student() {
	}

	public Student(String stuNo, String stuName, int stuEng, int stuMath) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuEng = stuEng;
		this.stuMath = stuMath;
	}

	public void showInfo() {
		System.out.println(
				"번호 : " + stuNo + "   \t이름 : " + stuName + "   \t영어 : " + stuEng + "점   \t수학 : " + stuMath + "점");
	}

	public String getStudentNo() {
		return stuNo;
	}

	public String getStudentName() {
		return stuName;
	}

	public int getStudentEng() {
		return stuEng;
	}

	public int getStudentMath() {
		return stuMath;
	}

	public void setStudentMath(int stuMath) {
		this.stuMath = stuMath;
	}

	public void setStudentEng(int stuEng) {
		this.stuEng = stuEng;
	}

	public void setStudentNumber(String stuNo) {
		this.stuNo = stuNo;
	}

	public void setStudentName(String stuName) {
		this.stuName = stuName;
	}
}// end class
