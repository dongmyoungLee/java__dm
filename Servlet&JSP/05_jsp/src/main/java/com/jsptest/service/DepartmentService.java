package com.jsptest.service;

import java.sql.Connection;
import java.util.List;

import com.jsptest.common.JDBCTemplate;
import com.jsptest.dao.DepartmentDao;
import com.jsptest.vo.Department;

public class DepartmentService {
	private DepartmentDao dao = new DepartmentDao();
	
	public List<Department> selectDepartment(){
	      Connection conn=JDBCTemplate.getConnection();
	      List<Department> list = dao.selectDepartment(conn);
	      JDBCTemplate.close(conn);
	      return list; 
   }

   public List<Department> searchDepartment(String keyword) {
	   Connection conn = JDBCTemplate.getConnection();
	   List<Department> list = dao.searchDepartment(conn, keyword);
	   JDBCTemplate.close(conn);
	   return list; 
   }
	
}
