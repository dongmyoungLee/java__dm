package com.member.model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.member.model.vo.Member;

// DB에 접속해서 해당하는 데이터를 조회, 추가, 수정, 삭제 기능을 제공
public class MemberDao {
	
	public List<Member> searchAll() {
		//BS 계정의 Member 테이블에 저장된 모든 데이터를 전달해주는 기능..
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> members = new ArrayList();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BS", "BS");
			conn.setAutoCommit(false);
			
			stmt = conn.createStatement();
			String sql = "SELECT * FROM MEMBER";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Member m = new Member();
				
				m.setMemberId(rs.getString("member_id"));
				m.setMemberName(rs.getString("member_name"));
				m.setAge(rs.getInt("age"));
				m.setGender(rs.getString("gender"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby").split(","));
				m.setEnrollDate(rs.getDate("enroll_date"));
				
				members.add(m);
			}
					
		
		} catch(ClassNotFoundException e ) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
				
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return members;
		
		
	}
	
	public List<Member> searchName(String name) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> members = new ArrayList();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BS", "BS");
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE '%"+ name +"%'";
			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Member m = getDataBaseMember(rs);
				members.add(m);
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
				
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return members;
	}
	
	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BS", "BS");
			
			stmt = conn.createStatement();
			//String sql = "INSERT INTO MEMBER VALUES('"+m.getMemberId()+"', '"+m.getMemberPwd()+"', '"+m.getMemberName()+"', '"+m.getGender()+"', "+m.getAge()+", '"+m.getEmail()+"', '"+m.getPhone()+"', '"+m.getAddress()+"', '"+String.join(",", m.getHobby())+"', sysdate)";
			
			// 매개변수 값을 가지고 쿼리문을 구성할때 PreparedStatement 객체를 이용하는것이 좋음
			// 자료형에 맞는 메소드를 제공해 줌.
			// setString, setInt ... 
			// 각 set 메소드의 매개변수는 2개를 가짐
			// 첫 번째 매개변수 : ? 의 위치 -> 왼쪽에서부터 1로 시작함
			// 두 번재 매개변수 : 값
			// sql 문에 설정된 모든 ?에 값을 대입함
			String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, String.join(",", m.getHobby()));
			
			
			result = pstmt.executeUpdate();
			
			
			
			
			
			
			
			
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
						
		} catch(Exception e) {
			
		} finally {
			try {
				if(stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
				
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	private Member getDataBaseMember(ResultSet rs) throws SQLException {

		Member m = new Member();
		
		m.setMemberId(rs.getString("member_id"));
		m.setMemberName(rs.getString("member_name"));
		m.setAge(rs.getInt("age"));
		m.setGender(rs.getString("gender"));
		m.setEmail(rs.getString("email"));
		m.setAddress(rs.getString("address"));
		m.setHobby(rs.getString("hobby").split(","));
		m.setEnrollDate(rs.getDate("enroll_date"));
		
		return m;
		
	}
}
