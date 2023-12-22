package com.yedam.student.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.service.StudentService;
import com.yedam.student.serviceImpl.StudentServiceImpl;
import com.yedam.student.vo.Student;

@WebServlet("/modifyStudent")
public class ModifyStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifyStudent() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		// �Ķ���� Ȱ���ؼ� ��ȸ
		String sno = request.getParameter("sno");

		StudentService dao = new StudentServiceImpl();
		Student std = dao.getStudent(sno);

		String str = "<form action='updateStudent'>";
		str += "<table border='1'><caption>�л�����</caption>";
		str += "<tr><th>�й�</th><td><input type='text' readonly name='sno' value='" + std.getStudentNo()
				+ "'></td></tr>";
		str += "<tr><th>�̸�</th><td>" + std.getStudentName() + "</td></tr>";
		str += "<tr><th>����</th><td><input type='number' name='escore' value='" + std.getStudentEng() + "'></td></tr>";
		str += "<tr><th>����</th><td><input type='number' name='mscore' value='" + std.getStudentMath() + "'></td></tr>";
		str += "<tr><td><input type='submit' value='����'></td></tr></table>";

		str += "</form>";

		response.getWriter().print(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
