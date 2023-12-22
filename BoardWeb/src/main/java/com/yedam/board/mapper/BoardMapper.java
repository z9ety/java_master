package com.yedam.board.mapper;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardMapper {
	// xml에 있는 명령을 실행함
	// 목록,단건조회,추가,수정,삭제,조회수증가.
	List<BoardVO> selectList();
	BoardVO selectOne(int bno);
	int insertBoard(BoardVO vo); //
	int updateBoard(BoardVO vo); // db 전송 횟수를 받아옴
	int deleteBoard(int bno);    //
	int updateCnt(int bno);
}
