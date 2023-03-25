package com.mybatis.common;

import org.apache.ibatis.session.SqlSession;

public class SqlSessionTemplate {
	// SqlSession 객체를 생성해서 반환해주는 역할을 하는 클래스
	
	public static SqlSession getSession() {
		// SqlSession 객체를 생성하는 방법..
		
		// 1. SqlSessionFactoryBuilder 클래스 생성..
		// 2. 설정파일인 mybatis-config.xml 파일을 가져와 적용함..(InputStream)
		// 3. SqlSessionFactoryBuilder 의 build() 메소드를 이용해서 SqlSessionFactory 클래스를 생성한다.
		// 4. SqlSessionFactory 클래스에서 openSession() 메소드를 이용해서 SqlSession 객체를 생성한다..
		
		// - openSession(true || false) -> 트랜잭션관리설정(autocommit 설정)
	}
}
