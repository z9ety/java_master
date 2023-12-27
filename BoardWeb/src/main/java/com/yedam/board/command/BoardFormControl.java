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
		//등록화면 open.

		// 페이지 이동(forward)
				RequestDispatcher rd = req.getRequestDispatcher("board/addBoardForm.tiles"); // ??
				try {
					rd.forward(req, resp); // 파라미터 키와 값의 가장 초기값을 부여
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
	}

}
