package com.member.dao;

import static com.web.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.member.vo.Member;

public class MemberDao {
	private Properties sql = new Properties();
	
	public MemberDao() {
		String path = MemberDao.class.getResource("/sql/member/member_sql.properties").getPath();
		
		try {
			sql.load(new FileReader(path));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member selectMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectMemberById"));
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				m = getMember(rs);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return m;
	}
	
	private Member getMember(ResultSet rs) throws SQLException {
		Member m = new Member();
		m.setUserid(rs.getString("userId"));
		m.setPassword(rs.getString("password"));
		m.setUserName(rs.getString("userName"));
		m.setAge(rs.getInt("age"));
		m.setGender(rs.getString("gender"));
		m.setEmail(rs.getString("email"));
		m.setAddress(rs.getString("address"));
		m.setPhone(rs.getString("phone"));
		m.setHobby(rs.getString("hobby"));
		m.setEnrollDate(rs.getDate("enrolldate"));
		
		return m;
	}
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql.getProperty("insertMember"));
			pstmt.setString(1, m.getUserid());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
}








