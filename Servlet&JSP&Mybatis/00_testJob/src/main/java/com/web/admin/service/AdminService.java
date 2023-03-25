package com.web.admin.service;

import java.sql.Connection;
import java.util.List;

import com.web.member.dao.MemberDao;
import com.web.member.vo.Member;
import static com.web.common.JDBCTemplate.*;

public class AdminService {

	private MemberDao dao=new MemberDao();
	
	
	public List<Member> selectMemberList(int cPage,int numPerpage){
		Connection conn=getConnection();
		List<Member> list=dao.selectMemberList(conn,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	
	public List<Member> searchMemberList(String type, String keyword){
		Connection conn=getConnection();
		List<Member> list=dao.searchMemberList(conn,type,keyword);
		close(conn);
		return list;
	}
	
}
