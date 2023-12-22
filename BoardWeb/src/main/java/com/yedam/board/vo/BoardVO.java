package com.yedam.board.vo;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private String writerDate;
	private int clickCnt;
	private String image;

	public BoardVO(int no, String title, String cont,String writer) {
		this.boardNo = no;
		this.title = title;
		this.content = cont;
		this.writer = writer;
	}
}
