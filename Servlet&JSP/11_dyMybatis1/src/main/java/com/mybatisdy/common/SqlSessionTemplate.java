package com.mybatisdy.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	public static SqlSession getSession() {
		SqlSession session = null;
		String file = "mybatis-config.xml";
		
		try {
			InputStream is = Resources.getResourceAsStream(file);
			session = new SqlSessionFactoryBuilder().build(is).openSession(false);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return session;
	}
}
