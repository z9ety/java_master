package com.serv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoodsInfoServ
 */
@WebServlet("/GoodsInfoServ")
public class GoodsInfoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookVO book = new BookVO();
		book.setName("자바프로그래밍");
		book.setPrice("1000");
		book.setPublsher("한빛미디어");
		
		List<ReviewVO> review = new ArrayList<>();
		review.add(new ReviewVO("리뷰1","길동"));
		review.add(new ReviewVO("리뷰2","기자"));
		review.add(new ReviewVO("리뷰3","순신"));
		
		request.setAttribute("book", book);
		request.setAttribute("review", review);
		
		request.getRequestDispatcher("goodsInfo.jsp").forward(request, response);
	}


}
