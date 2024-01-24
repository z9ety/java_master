package com.serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class reviewAddServ
 */
@WebServlet("/reviewAddServ")
public class reviewAddServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터

		// 리뷰 등록 서비스
		System.out.println("리뷰등록됨");
		// 페이지 이동
		// request.getRequestDispatcher("GoodsInfoServ")
		response.sendRedirect("GoodsInfoServ");
	}

}
