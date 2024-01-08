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
import com.yedam.reply.vo.PageDTO;

public class GetBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// �۹�ȣ ��ȸ.
		BoardService svc = new BoardServiceMybatis();
		String bno = req.getParameter("bno");
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));

		int totalCnt = 70;
		PageDTO dto = new PageDTO(1, totalCnt);
		req.setAttribute("vo", vo);
		req.setAttribute("page", dto);

		// ������ �̵�(forward)
		RequestDispatcher rd = req.getRequestDispatcher("board/getBoard.tiles"); // ??
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
