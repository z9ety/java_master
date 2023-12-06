package com.yedam;

import lombok.Data;

@Data
public class Employee {
	private String memnum;
	private String memname;
	private String memtel;
	private String jday;
	private int income;

	public Employee(String memnum, String memname, String memtel, String jday, int income) {
		this.memnum = memnum;
		this.memname = memname;
		this.memtel = memtel;
		this.jday = jday;
		this.income = income;
	}

	void showInfo() {
		System.out.printf("%-7s\t%-5s\t%s\n", memnum, memname, memtel);
	}
}
