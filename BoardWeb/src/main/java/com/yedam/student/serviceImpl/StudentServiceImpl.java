package com.yedam.student.serviceImpl;

import java.util.List;

import com.yedam.student.mapper.StudentDAO;
import com.yedam.student.service.StudentService;
import com.yedam.student.vo.Student;

public class StudentServiceImpl implements StudentService {
	StudentDAO dao = new StudentDAO();

	@Override
	public List<Student> studentList() {
//		dao.getStudent("");
		return dao.getStudentList();
	}

	@Override
	public boolean addStudent(Student std) {
		return dao.addStudent(std);
	}

	@Override
	public boolean modStudent(String no, int eng, int math) {
		return dao.modifyStudent(no, eng, math);
	}

	@Override
	public boolean remStudent(String no) {
		return dao.removeStudent(no);
	}

	@Override
	public Student getStudent(String no) {
		return dao.getStudent(no);
	}

}