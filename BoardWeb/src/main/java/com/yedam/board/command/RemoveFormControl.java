package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class RemoveFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		BoardService svc = new BoardServiceMybatis();
		String bno = req.getParameter("bno");
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));
		req.setAttribute("vo", vo);

		// ������ �̵�(forward)
		RequestDispatcher rd = req.getRequestDispatcher("board/remBoardForm.jsp"); // ??
		try {
			rd.forward(req, resp); // ??
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
