package com.yedam.common;
// ��Ʈ�ѷ� : url -> ���� ����.

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	// �����ֱ� : ������ -> init -> service() -> destroy()

	Map<String, Control> map; // <Ű( , ���(����)>

	public FrontController() {
		System.out.println("������ ȣ��.");
		map = new HashMap<String, Control>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() ȣ��.");
		map.put("/main.do", new MainControl());
		map.put("/sub.do", new SubControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() ȣ��.");
		// http:..localhost/BoardWeb/main.do ->mainControl.
		String url = req.getRequestURI(); // /BoardWeb/main.do
		String context = req.getContextPath(); // /BoardWeb
		String path = url.substring(context.length());
		System.out.println(path);

		Control ctrl = map.get(path);
		ctrl.execute(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("destroy() ȣ��.");
	}
}
