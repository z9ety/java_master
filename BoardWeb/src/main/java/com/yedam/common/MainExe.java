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

		// ���.
		List<BoardVO> list = mapper.selectList();
		for (BoardVO vo : list) {
			System.out.println(vo.toString());
		}
		// �ܰ���ȸ.
		System.out.print("�Խñ� �ѹ� �Է� : ");
		int no = Integer.parseInt(sc.nextLine());
		BoardVO oneBoard = mapper.selectOne(no);
		System.out.printf("��ȸ�� �� : %s\n", oneBoard);

		// �߰�.
		System.out.println("�� �߰�");
		BoardVO adB = new BoardVO(0, "��ǥ", "��ǥ��", "������");
		if (mapper.insertBoard(adB) == 1) {
			System.out.println(adB);
			System.out.println("�߰���");
		}
		
		// ����.
		

	}
}
