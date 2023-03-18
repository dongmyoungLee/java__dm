package com.web.member.dao;

import static com.web.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.web.member.vo.Member;

public class MemberDao {
	
	private Properties sql=new Properties();
	
	public MemberDao() {
		String path=MemberDao.class.getResource("/sql/member/member_sql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member selectMember(Connection conn,String userId) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectMemberById"));
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=getMember(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return m;
	}
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertMember"));
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}
	
	public List<Member> selectMemberList(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectMemberList"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);//데이터의 시작
			pstmt.setInt(2, cPage*numPerpage);//데이터의 끝
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=getMember(rs);
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	public int selectMemberCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectMemberCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);//컬럼의 인덱스 번호
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}
	
	public List<Member> searchMemberList(Connection conn, String type, String keyword){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=new ArrayList();
		String query=sql.getProperty("searchMemberList");
		//SELECT * FROM MEMBER WHERE #COL LIKE '%'||?||'%'
		query=query.replace("#COL", type);
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, keyword);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member m=getMember(rs);
				list.add(m);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	
	
	
	private Member getMember(ResultSet rs) throws SQLException {
		Member m=new Member();
		m.setUserId(rs.getString("userid"));
		m.setPassword(rs.getString("password"));
		m.setUserName(rs.getString("username"));
		m.setAge(rs.getInt("age"));
		m.setGender(rs.getString("gender"));
		m.setEmail(rs.getString("email"));
		m.setAddress(rs.getString("address"));
		m.setPhone(rs.getString("phone"));
		m.setHobby(rs.getString("hobby"));
		m.setEnrollDate(rs.getDate("enrolldate"));
		return m;
	}
	
}

