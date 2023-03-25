package com.mybatis.model.service;

import static com.mybatis.common.SqlSessionTemplate.getSession;

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
}
