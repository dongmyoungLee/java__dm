package com.member.model.dao;

import static com.member.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.member.common.JDBCTemplate;
import com.member.model.vo.Member;

public class MemberDao2 {
	private Properties sqlData = new Properties();
	
	public MemberDao2() {
		String path = MemberDao2.class.getResource("/mappers/member_sql.properties").getPath();
		try {
			sqlData.load(new FileReader(path));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private Member getMember(ResultSet rs) throws SQLException {
		Member m = new Member();
		
		m.setMemberId(rs.getString("member_id"));
		m.setMemberName(rs.getString("member_name"));
		m.setGender(rs.getString("gender"));
		m.setAge(rs.getInt("age"));
		m.setEmail(rs.getString("email"));
		m.setPhone(rs.getString("phone"));
		m.setAddress(rs.getString("address"));
		m.setHobby(rs.getString("hobby").split(","));
		m.setEnrollDate(rs.getDate("enroll_date"));
		
		return m;
	}
	
	public List<Member> searchAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> result = new ArrayList();
		
		try {
			String sql = sqlData.getProperty("searchAll");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				result.add(getMember(rs));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public List<Member> searchName(Connection conn, String name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> result = new ArrayList();
		
		String sql = sqlData.getProperty("searchName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result.add(getMember(rs));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	public List<Member> searchId(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> result = new ArrayList();
					
		String sql = sqlData.getProperty("searchId");
		
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + id + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result.add(getMember(rs));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = sqlData.getProperty("insertMember");
		
		try {
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
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
				
	}
	
	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = sqlData.getProperty("updateMember");
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberName());
			pstmt.setInt(2, m.getAge());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	} 
	
	public int deleteMember(Connection conn, String id) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = sqlData.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			

			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
