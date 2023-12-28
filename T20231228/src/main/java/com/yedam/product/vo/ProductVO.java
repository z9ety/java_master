package com.yedam.product.vo;

import lombok.Data;

@Data
public class ProductVO {
	private String productCode;
	private String productName;
	private String productDesc;
	private String originPrice;
	private String salePrice;
	private int likeIt;
	private String image;
}
