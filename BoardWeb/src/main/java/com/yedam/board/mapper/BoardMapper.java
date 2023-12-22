package com.yedam.board.mapper;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardMapper {
	// xml�� �ִ� ����� ������
	// ���,�ܰ���ȸ,�߰�,����,����,��ȸ������.
	List<BoardVO> selectList();
	BoardVO selectOne(int bno);
	int insertBoard(BoardVO vo); //
	int updateBoard(BoardVO vo); // db ���� Ƚ���� �޾ƿ�
	int deleteBoard(int bno);    //
	int updateCnt(int bno);
}
