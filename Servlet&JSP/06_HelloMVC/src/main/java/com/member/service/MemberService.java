package com.member.service;

import static com.web.common.JDBCTemplate.close;
import static com.web.common.JDBCTemplate.getConnection;
import static com.web.common.JDBCTemplate.commit;
import static com.web.common.JDBCTemplate.rollback;
import java.sql.Connection;

import com.member.dao.MemberDao;
import com.member.vo.Member;


public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public Member selectMember(String userId) {
		Connection conn = getConnection();
		Member m = dao.selectMember(conn, userId);		
		close(conn);
		return m;
	}
	
	public int insertMember(Member m) {
		
		Connection conn = getConnection();
		int result = dao.insertMember(conn, m);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return 1;
	}
}
