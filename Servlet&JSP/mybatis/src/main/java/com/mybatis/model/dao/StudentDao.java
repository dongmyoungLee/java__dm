package com.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

public class StudentDao {
	
	public int inserStudent(SqlSession session) {
		// mybatis 가 제공하는 메소드를 이용해서.. mapper.xml 에 설정한 sql문을 실행함.
		// PreparedStatement, ResultSet 클래스는 SqlSession 에서 제공하는 메소드에서 알아서 처리함.
		// selectOne(), selectList(), insert(), update(), delete()
		
		// 2~3개 매개변수를 전달받음
		// 1번: mapper 와 sql문을 설정하는 데이터 String
		// -> mapper 의 namespace명칭.sql문 id명칭 
		
		int result = session.insert("student.inerstStudent");
		
		return result;
	}
}
