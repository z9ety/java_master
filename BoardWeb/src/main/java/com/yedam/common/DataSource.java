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

	// SqlSessionFactory ��ȯ.
	public static SqlSessionFactory getInstance() {
		String resource = "config/mybatis-config.xml"; // db ���� ���� �� alias ����
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSF = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSF; // mybatis-config�� ������ �޾ƿ�
	}
}
