package com.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	//SqlSession객체를 생성해서 반환해주는 역할하는 클래스
	public static SqlSession getSession() {
		//SqlSession객체를 생성하는 방법
		//1. SqlSessionFractoryBuilder클래스를 생성
		//2. 설정파일인 mybatis-config.xml파일을 가져와 적용(InputStream)
		//3. SqlSessionFactoryBuilder의 build()메소드를 이용해서 SqlSessionFatory클래스를 생성
		//4. SqlSessionFactory클래스에서 openSession()메소드를 이용해서 SqlSession객체를 생성
		//  - openSession(true||false) -> 트렌젝션관리설정(auto-commit설정)
		SqlSession session=null;
		try {
			SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
			String path="/mybatis-config.xml";
			InputStream is=Resources.getResourceAsStream(path);
			SqlSessionFactory factory=builder.build(is);
			session=factory.openSession(false);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
	
	
	
	
	
}













