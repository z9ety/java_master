package common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getStudentServlet")
public class getStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url?sno=23-010&sname=ȫ�浿
		resp.setContentType("text/html;charset=utf-8");

		String sno = req.getParameter("sno");

		StudentDAO dao = new StudentDAO();
		Student std = dao.getStudent(sno);

		String str = "<table border='1'>";
		str += "<caption>�л�����</caption>";
		str += "<tr><th>�й�</th><td>" + std.getStudentNo() + "</td></tr>";
		str += "<tr><th>�̸�</th><td>" + std.getStudentName() + "</td></tr>";
		str += "<tr><th>����</th><td>" + std.getStudentEng() + "</td></tr>";
		str += "<tr><th>����</th><td>" + std.getStudentMath() + "</td></tr>";
		str += "</table>";
		str += "<br><a href='modifyStudent?sno=" + std.getStudentNo() + "'>����ȭ��</a>";
		str += "<br><a href='studentList'>���</a>";

		// ����� �������� ���.
		resp.getWriter().print(str);
	}
}
