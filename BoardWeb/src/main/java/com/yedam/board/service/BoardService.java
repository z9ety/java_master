package com.yedam.board.service;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardService {
	// ��������.
	public List<BoardVO> boardList(); // ���.
	public BoardVO getBoard(int bno); // �۹�ȣ ��ȸ.
	public boolean addBoard(BoardVO vo); // �۵��.
	public boolean modBoard(BoardVO vo); // �ۼ���.
	public boolean remBoard(int bno); // �ۻ���.
}
