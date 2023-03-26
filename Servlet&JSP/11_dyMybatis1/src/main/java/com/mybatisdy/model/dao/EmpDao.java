package com.mybatisdy.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatisdy.model.vo.Employee;
import com.mybatisdy.model.vo.Job;

public class EmpDao {
	
	public List<Employee> selectEmpAll(SqlSession session) {
		return session.selectList("emp.selectEmpAll");
	}
	
	public List<Employee> searchEmp(SqlSession session, Map<String, Object> param) {
		return session.selectList("emp.searchEmp", param);
	}
	
	public Job searchJob(SqlSession session, String jobCode) {
		return session.selectOne("job.searchJob", jobCode);
	}
}
