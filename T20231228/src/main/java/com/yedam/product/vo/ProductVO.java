package com.yedam.product.vo;

import lombok.Data;

@Data
public class ProductVO {
	private String pcode;
	private String pname;
	private String pdesc;
	private int oprice;
	private int sprice;
	private int like;
	private String image;
}
