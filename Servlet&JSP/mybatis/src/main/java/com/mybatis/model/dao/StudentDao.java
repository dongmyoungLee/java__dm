package com.mybatis.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.vo.Student;

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
	
	public int insertStudentName(SqlSession session, String name) {
		return session.insert("student.insertStudentName", name);
	}
	
	public int insertStudentName(SqlSession session, Student s) {
		return session.insert("student.insertStudentAll", s);
	}
	
	public int updateStudent(SqlSession session, Student s) {
		return session.insert("student.updateStudent", s);
	}
	
	public int deleteStudent(SqlSession session, int no) {
		return session.insert("student.deleteStudent", no);
	}
	
	/*
	 * DB에서 데이터를 조회하는 메소드는 2가지가 있다.
	 * 
	 * 1. selectOne() : select 문의 결과가 한개 row만 나올때 실행하는 메소드
	 * 
	 * 		매개변수 
	 * 		1개 : mapper, namespace명.sql문 id
	 * 		2개 : Object(select문을 실행할때 필요값을 전송)
	 * 
	 * 2. selectList() : select 문의 겨로가가 한개 이상일때 실행하는 메소드
	 * 
	 * 		매개변수 
	 * 		1개 : mapper, namespace명.sql문 id
	 * 		2개 : Object(select문을 실행할때 필요값을 전송)
	 * 		3개 : 페이징처리 객체를 전달
	 * 
	 * */
	public int studentCount(SqlSession session) {
		return session.selectOne("student.selectStudentCount");
	}
	
	public Student selectStudent(SqlSession session, int no) {
		return session.selectOne("student.selectStudent", no);
	}
	
	public Student selectStudentName(SqlSession session, String name) {
		return session.selectOne("student.selectStudentName", name);
	}
	
	public List<Student> selectStudentAll(SqlSession session) {
		return session.selectList("student.selectStudentAll");
	}
}
