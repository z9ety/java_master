package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// id, pw -> ���� -> ���.
		// -> ������ -> �α���ȭ��.
		String id = req.getParameter("id"); // input�� �ԷµǾ� ���ϵ� �Ķ���Ͱ� id=(x)�� ����
		String pw = req.getParameter("pw");

		MemberService svc = new MemberServiceImpl();

		MemberVO vo = svc.login(id, pw);// SQL�� id, pw���� �����ؼ� MemberVO������� �޾ƿ�

		if (vo != null) { // SQL�� ���� ������ ���
			// ���ǰ�ü �α������� ����.
			HttpSession session = req.getSession();
			session.setAttribute("logId", vo.getId()); // ���ǰ�ü�� �α��ξ��̵�
			session.setAttribute("logName", vo.getName());
			try {
				resp.sendRedirect("boardList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			req.setAttribute("message", "���̵�� ��й�ȣ�� Ȯ���ϼ���.");
			try {
				req.getRequestDispatcher("member/logForm.tiles").forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
