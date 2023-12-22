package com.yedam.student.service;

import java.util.List;

import com.yedam.student.vo.Student;

public interface StudentService {
	// ���, �Է�, ����, ����, �ܰ���ȸ
	List<Student> studentList();

	boolean addStudent(Student std);

	boolean modStudent(String no, int eng, int math);

	boolean remStudent(String no);

	Student getStudent(String no);

}
