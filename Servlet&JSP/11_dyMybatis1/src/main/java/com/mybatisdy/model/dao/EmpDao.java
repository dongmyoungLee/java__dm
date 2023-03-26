package com.mybatisdy.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatisdy.model.vo.Employee;

public class EmpDao {
	
	public List<Employee> selectEmpAll(SqlSession session) {
		return session.selectList("emp.selectEmpAll");
	}
	
	public List<Employee> searchEmp(SqlSession session, Map<String, Object> param) {
		return session.selectList("emp.searchEmp", param);
	}
}
