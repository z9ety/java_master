package com.yedam.common;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.vo.BoardVO;

public class MainExe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession();

		BoardMapper mapper = session.getMapper(BoardMapper.class);

		// 목록.
		List<BoardVO> list = mapper.selectList();
		for (BoardVO vo : list) {
			System.out.println(vo.toString());
		}
		// 단건조회.
		System.out.print("게시글 넘버 입력 : ");
		int no = Integer.parseInt(sc.nextLine());
		BoardVO oneBoard = mapper.selectOne(no);
		System.out.printf("조회된 글 : %s\n", oneBoard);

		// 추가.
		System.out.println("글 추가");
		BoardVO adB = new BoardVO(0, "발표", "발표중", "박지웅");
		if (mapper.insertBoard(adB) == 1) {
			System.out.println(adB);
			System.out.println("추가됨");
		}
		
		// 수정.
		

	}
}
