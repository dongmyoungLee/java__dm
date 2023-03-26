package com.mybatisdy.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatisdy.common.SqlSessionTemplate;
import com.mybatisdy.model.dao.MemberDao;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public List<Map> selectMemberList() {
		SqlSession session = SqlSessionTemplate.getSession();
		
		List<Map> result = dao.selectMemberList(session);
		
		session.close();
		
		return result;
	}
}
