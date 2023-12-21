package common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UpdateStudent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String no = request.getParameter("sno");
		String name = request.getParameter("sname");
		String eng = request.getParameter("escore");
		String math = request.getParameter("mscore");
		
		Student st = new Student(no, name, Integer.parseInt(eng), Integer.parseInt(math));
		StudentDAO dao = new StudentDAO();
		boolean modst = dao.modifyStudent(st.getStudentNo(), st.getStudentEng(), st.getStudentMath());
		
		PrintWriter out = response.getWriter();
		
		if(modst) {
			out.println("<script>alert('OK'); location.href='studentList'; </script>");
		}else {
		out.println("<script>alert('Fail'); location.href='index.html'; </script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
