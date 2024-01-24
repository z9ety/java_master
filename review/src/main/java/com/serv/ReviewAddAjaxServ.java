package com.serv;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReviewAddAjaxServ
 */
@WebServlet("/ReviewAddAjaxServ")
public class ReviewAddAjaxServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String content = request.getParameter("contnet");
		System.out.println(name +":"+content);
//		response.setContentType("text/html; charset=UTF-8");
		response.setContentType("application/json");
		
//		Map<String, Object> map = new HashMap<>();
//		map.put("result", "success");
//		String str = gson.toJson(map);
		
//		response.getWriter().append("success");
		response.getWriter().append("{\"result\":\"success\"}");
//		response.getWriter().append(str);
		
	}

}
