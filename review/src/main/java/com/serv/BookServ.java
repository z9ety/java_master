package com.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//javax : 확장패키지
@WebServlet("/BookServ")
public class BookServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BookServ() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html; charset=UTF-8"); //mimetype
		String[] list = new String[] {"스프링","html","java","boot"};
		request.setAttribute("list", list);
		request.getRequestDispatcher("book.jsp").forward(request, response);
//		PrintWriter out = response.getWriter();
//		out.append("<ul>");
//		for(String book:list) {
//			out.print("<li>" + book);
//		}
//		out.append("</ul>");
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.service(arg0, arg1);
//	}

}
