package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.service.BoardServiceMybatis;
import com.yedam.common.Control;

public class BoardFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//���ȭ�� open.

		// ������ �̵�(forward)
				RequestDispatcher rd = req.getRequestDispatcher("board/addBoardForm.tiles"); // ??
				try {
					rd.forward(req, resp); // �Ķ���� Ű�� ���� ���� �ʱⰪ�� �ο�
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
	}

}
