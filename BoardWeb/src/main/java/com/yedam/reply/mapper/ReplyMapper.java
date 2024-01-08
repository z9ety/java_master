package com.yedam.reply.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.reply.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> replyList(int boardNo);
	List<ReplyVO> replyListPaging(@Param("boardNo") int boardNo, @Param("page") int page);
	int deleteReply(int replyNo);
	int insertReply(ReplyVO vo);
	ReplyVO selectReply(int replyNo);
	// ������ ����ϱ� ���� ��ü�Ǽ� ��ȯ.
	int selectCount(int boardNo);
	// ��Ʈ ������(�����, �ۼ��Ǽ�)
	List<HashMap<String, Object>> selectReplyCnt();
}
