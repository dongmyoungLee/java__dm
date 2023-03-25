package com.mybatis.model.service;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.StudentDao;
import com.mybatis.model.vo.Student;
import static com.mybatis.common.SqlSessionTemplate.getSession;

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
}
