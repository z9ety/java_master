package com.yedam.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.DataSource;

public class BoardServiceMybatis implements BoardService {
	
	SqlSession session = DataSource.getInstance().openSession(true); //���� �ν��Ͻ� ����
	BoardMapper mapper = session.getMapper(BoardMapper.class); // xml���ϰ� �������� .class
	
	@Override
	public List<BoardVO> boardList() {
		return mapper.selectList();
	}

	@Override
	public BoardVO getBoard(int bno) {
		mapper.updateCnt(bno);
		return mapper.selectOne(bno);
	}

	@Override
	public boolean addBoard(BoardVO vo) {
		System.out.println(vo);
		return mapper.insertBoard(vo) == 1;
	}

	@Override
	public boolean modBoard(BoardVO vo) {
		return mapper.updateBoard(vo) == 1;
	}

	@Override
	public boolean remBoard(int bno) {
		return mapper.deleteBoard(bno) == 1;
	}

}
