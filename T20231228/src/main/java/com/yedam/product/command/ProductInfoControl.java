package com.yedam.product.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class ProductInfoControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		RequestDispatcher rd = req.getRequestDispatcher("pinfo/productInfo.tiles"); // ??
		try {
			rd.forward(req, resp); // 파라미터 키와 값의 가장 초기값을 부여
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
