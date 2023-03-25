package com.web.member.service;

import java.sql.Connection;

import com.web.member.dao.MemberDao;
import com.web.member.vo.Member;
import static com.web.common.JDBCTemplate.getConnection;
import static com.web.common.JDBCTemplate.close;
import static com.web.common.JDBCTemplate.commit;
import static com.web.common.JDBCTemplate.rollback;

public class MemberService {

	private MemberDao dao=new MemberDao();
	
	public Member selectMember(String userId) {
		Connection conn=getConnection();
		Member m=dao.selectMember(conn,userId);
		close(conn);
		return m;
	}
	
	public int insertMember(Member m) {
		Connection conn=getConnection();
		int result=dao.insertMember(conn,m);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int selectMemberCount() {
		Connection conn=getConnection();
		int count=dao.selectMemberCount(conn);
		close(conn);
		return count;
	}
			
			
			
			
			
			
}
