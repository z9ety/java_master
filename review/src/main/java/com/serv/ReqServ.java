package com.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReqServ
 */
@WebServlet("/ReqServ")
public class ReqServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.append(request.getQueryString()+"<hr>");
//		out.append(request.getRemoteAddr()+"<hr>");
//		out.append(request.getHeader("user-agent")+"<hr>");
//		out.append(request.getParameter("name")+"<hr>");
//		out.append(request.getCookies().toString() +"<hr>");
//		for(Cookie cookie : request.getCookies()) {
//			out.print(cookie.getName()+":"+ cookie.getValue()+"<hr>");
//		}
//		request.getRequestDispatcher("BookServ").forward(request, response);
		response.sendRedirect("BookServ");
		//msg.jsp
		request.setAttribute("msg", "~~~~");
		request.setAttribute("url", "main.do");
		request.getRequestDispatcher("msg.jsp").forward(request,response);
	}

}
