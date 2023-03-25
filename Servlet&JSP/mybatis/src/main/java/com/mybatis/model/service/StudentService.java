package com.mybatis.model.service;

import static com.mybatis.common.SqlSessionTemplate.getSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.StudentDao;
import com.mybatis.model.vo.Student;	

public class StudentService {
	private StudentDao dao = new StudentDao();
	
	public int insertStudent() {
		SqlSession session = getSession();
		
		int result = dao.inserStudent(session);
		
		// 트랜잭션 처리..
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
	
	public int insertStudentName(String name) {
		SqlSession session = getSession();
		
		int result = dao.insertStudentName(session, name);
		
		// 트랜잭션 처리..
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
		
		
	}
	
	public int insertStudentAll(Student s) {
		SqlSession session = getSession();
		
		int result = dao.insertStudentName(session, s);
		
		// 트랜잭션 처리..
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
		
	}
	
	public int updateStudent(Student s) {
		SqlSession session = getSession();
		
		int result = dao.updateStudent(session, s);
		
		// 트랜잭션 처리..
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
	
	public int deleteStudent(int no) {
		SqlSession session = getSession();
		int result = dao.deleteStudent(session, no);
		
		// 트랜잭션 처리..
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
	
	public int selectStudentCount() {
		SqlSession session = getSession();
		
		int result = dao.studentCount(session);
		
		session.close();
		
		return result;
	}
	
	public Student selectStudent(int no) {
		SqlSession session = getSession();
		
		Student s = dao.selectStudent(session, no);
		
		session.close();
		
		return s;
	}
	
	public Student selectStudentName(String name) {
		SqlSession session = getSession();
		
		Student s = dao.selectStudentName(session, name);
		
		session.close();
		
		return s;
	}
	
	public List<Student> selectStudentAll() {
		SqlSession session = getSession();
		
		List<Student> list = dao.selectStudentAll(session);
		
		session.close();
		
		return list;
	}
	
	
}
