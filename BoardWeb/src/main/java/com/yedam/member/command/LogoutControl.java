package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;

public class LogoutControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// �α׾ƿ�...���ǻ���.
		HttpSession session = req.getSession(); // ��û���� ������ ����
		session.invalidate(); // ���� ��Ȱ��ȭ

		try {
			resp.sendRedirect("loginForm.do"); // �Ķ���� ����. FrontController�� ������
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
