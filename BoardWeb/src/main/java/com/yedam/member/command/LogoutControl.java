package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;

public class LogoutControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 로그아웃...세션삭제.
		HttpSession session = req.getSession(); // 요청받은 세션을 저장
		session.invalidate(); // 세션 비활성화

		try {
			resp.sendRedirect("loginForm.do"); // 파라미터 응답. FrontController에 지정됨
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
