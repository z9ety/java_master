package com.yedam.student.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.student.mapper.StudentMapper;
import com.yedam.student.service.StudentService;
import com.yedam.student.vo.Student;

public class StudentServiceMybatis implements StudentService {
	// jdbc vs. mybatis.
	SqlSessionFactory factory = DataSource.getInstance();
	SqlSession session = factory.openSession();

	StudentMapper mapper = session.getMapper(StudentMapper.class);

	@Override
	public List<Student> studentList() {
		return mapper.studentList();
	}

	@Override
	public boolean addStudent(Student std) {
		return mapper.addStudent(std) == 1;
	}

	@Override
	public boolean modStudent(String no, int eng, int math) {
		return false;
	}

	@Override
	public boolean remStudent(String no) {
		return mapper.remStudent(no) == 1;
	}

	@Override
	public Student getStudent(String no) {
		return null;
	}
}
