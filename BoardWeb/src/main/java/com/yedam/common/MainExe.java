package com.yedam.common;

import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;

public class MainExe { // 서비스 테스트용
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();
		svc.replyListPaging(3,3).forEach(reply -> System.out.println(reply));
	}
}
