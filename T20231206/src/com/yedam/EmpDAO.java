package com.yedam;

import java.util.ArrayList;

public class EmpDAO {
	public ArrayList<Employee> members;

	public EmpDAO() {
		members = new ArrayList<Employee>();
		members.add(new Employee("23-12", "±è±æµ¿", "943-1244", "2023-10-02", 250));
	}

	boolean addMember(Employee add) {
//		try {
		members.add(add);
//		} catch (NumberFormatException er) {
//			return false;
//		}
		return true;
	}

	ArrayList<Employee> memberList() {
		return members;
	}

	boolean modifyIncome(String memnum, int income) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getMemnum().equals(memnum)) {
				members.get(i).setIncome(income);
				return true;
			}
		}
		return false;
	}

	boolean removeMember(String memnum) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getMemnum().equals(memnum)) {
				members.remove(i);
				return true;
			}
		}
		return false;
	}

	Employee searchMember(String jday) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getJday().equals(jday)) {
				return members.get(i);
			}
		}
		return null;
	}

}
