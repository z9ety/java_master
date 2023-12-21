package common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studentList")
public class StudantListServ extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��� ������.
		StudentDAO dao = new StudentDAO();
		List<Student> list = dao.getStudentList();

		// out.print("<table border='1'>");
		String str = "<table border='1'>";
		str += "<thead><tr><th>�л���ȣ</th><th>�л��̸�</th><th>��������</th><th>��������</th></tr></thead>";
		str += "<tbody>";
		for (Student std : list) {
			str += "<tr>" + "<td><a href='getStudentServlet?sno=" + std.getStudentNo() + "'>"+std.getStudentNo()+"</a></td>" + "<td>" + std.getStudentName() + "</td>" + "<td>"
					+ std.getStudentEng() + "</td>" + "<td>" + std.getStudentMath() + "</td></tr>";
		}
		str += "</tbody></table>";
		str += "<a href='index.html'>�ε��� �̵�</a>";
		str += "<a href='student/inform.html'> �Է�â����</a>";
		
		out.print(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
