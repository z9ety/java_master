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
		HttpSession session = req.getSession();
		session.invalidate();

		try {
			resp.sendRedirect("login.do");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
