package com.yedam.student.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.mapper.StudentDAO;
import com.yedam.student.service.StudentService;
import com.yedam.student.serviceImpl.StudentServiceImpl;
import com.yedam.student.vo.Student;

@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateStudent() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		String no = request.getParameter("sno");
		String name = request.getParameter("sname");
		String eng = request.getParameter("escore");
		String math = request.getParameter("mscore");

		Student st = new Student(no, name, Integer.parseInt(eng), Integer.parseInt(math));
		StudentService dao = new StudentServiceImpl();
		boolean modst = dao.modStudent(st.getStudentNo(), st.getStudentEng(), st.getStudentMath());

		PrintWriter out = response.getWriter();

		if (modst) {
			out.println("<script>alert('OK'); location.href='studentList'; </script>");
		} else {
			out.println("<script>alert('Fail'); location.href='index.html'; </script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
