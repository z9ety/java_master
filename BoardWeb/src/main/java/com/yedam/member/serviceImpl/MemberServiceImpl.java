package com.yedam.member.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.member.mapper.MemberMapper;
import com.yedam.member.service.MemberService;
import com.yedam.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	SqlSession session = DataSource.getInstance().openSession(true); // 세션 인스턴스 생성
	MemberMapper mapper = session.getMapper(MemberMapper.class); // xml파일과 구분위해 .class

	@Override
	public MemberVO login(String id, String pw) {
		return mapper.selectMember(id, pw);
	}

}
