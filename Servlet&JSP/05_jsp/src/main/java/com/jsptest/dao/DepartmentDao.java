package com.jsptest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsptest.common.JDBCTemplate;
import com.jsptest.vo.Department;

public class DepartmentDao {
	public List<Department> selectDepartment(Connection conn){
		
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      String sql="SELECT * FROM DEPARTMENT";
      
      List<Department> list=new ArrayList();
      
      try {
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
        	 Department d = new Department();
        	 d.setDeptId(rs.getString("dept_id"));
        	 d.setDeptTitle(rs.getString("dept_title"));
        	 d.setLocationId(rs.getString("location_id"));
        	 
        	 list.add(d);
         }
         
      }catch(SQLException e) {
         e.printStackTrace();
      }finally {
         JDBCTemplate.close(rs);
         JDBCTemplate.close(pstmt);
      }
      
      return list;
   }
	
	public List<Department> searchDepartment(Connection conn, String keyword) {
		  PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      String sql="SELECT * FROM DEPARTMENT WHERE DEPT_TITLE LIKE ?";
	      List<Department> list = new ArrayList();
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, "%" + keyword + "%");
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	        	 Department d = new Department();
	        	 d.setDeptId(rs.getString("dept_id"));
	        	 d.setDeptTitle(rs.getString("dept_title"));
	        	 d.setLocationId(rs.getString("location_id"));
	        	 
	        	 list.add(d);
	         }
	         
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(rs);
	         JDBCTemplate.close(pstmt);
	      }
	      
	      return list;
	}
}
