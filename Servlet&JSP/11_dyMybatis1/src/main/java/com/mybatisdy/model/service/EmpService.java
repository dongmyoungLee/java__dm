package com.mybatisdy.model.service;

import static com.mybatisdy.common.SqlSessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatisdy.model.dao.EmpDao;
import com.mybatisdy.model.vo.Employee;
import com.mybatisdy.model.vo.Job;

public class EmpService {
	
	private EmpDao dao = new EmpDao();
	
	public List<Employee> selectEmpAll() {
		SqlSession session = getSession();
		
		List<Employee> list = dao.selectEmpAll(session);
		
		session.close();
		
		return list;
	}
	
	public List<Employee> searchEmp(Map<String, Object> param) {
		SqlSession session = getSession();
		
		List<Employee> list = dao.searchEmp(session, param);
		
		session.close();
		
		return list;
	}
	
	public Job searchJob(String jobCode) {
		SqlSession session = getSession();
		
		Job j = dao.searchJob(session, jobCode);
		
		session.close();
		
		return j;
	}
}
