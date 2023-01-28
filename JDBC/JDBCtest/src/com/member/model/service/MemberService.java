package com.member.model.service;

import java.sql.Connection;
import java.util.List;

import com.member.common.JDBCTemplate;
import com.member.model.dao.MemberDao2;
import com.member.model.vo.Member;



// DB에 접속하는 Connection 및 트랜잭션을 처리하는 클래스
public class MemberService {
	
	private MemberDao2 dao = new MemberDao2();
	
	public List<Member> searchAll() {
		Connection conn = JDBCTemplate.getConnection();
		
		List<Member> members = dao.searchAll(conn);
		
		JDBCTemplate.close(conn);
		
		return members;
	}
	
	public List<Member> searchName(String name) {
		Connection conn = JDBCTemplate.getConnection();
		List<Member> members = dao.searchName(conn, name);
		JDBCTemplate.close(conn);
		return members;
	}
	
	public List<Member> searchId(String id) {
		Connection conn = JDBCTemplate.getConnection();
		List<Member> members = dao.searchId(conn, id);
		JDBCTemplate.close(conn);
		return members;
	}
	
	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertMember(conn, m);
		
		// 트랜잭션 관리..
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}
	
	public int updateMember(Member m) {
		
		return 0;
	}
	
	public int deleteMember(String id) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.deleteMember(conn, id);
		
		// 트랜잭션 관리..
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}
}
