package com.yedam.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	private static SqlSessionFactory sqlSF;

	private DataSource() {
	}

	// SqlSessionFactory 반환.
	public static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml"; // SQL DB 연결 정보 및 alias 지정
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource); //mybatis-config의 정보를 입력 받아 스트리밍
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSF = new SqlSessionFactoryBuilder().build(inputStream); //스트리밍된 정보를 기반으로 새로운 DB 인스턴스를 생성
		return sqlSF;
	}
}
