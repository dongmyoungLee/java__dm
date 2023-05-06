package com.dm.springboot.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.dm.springboot.dao.MemberDao;
import com.dm.springboot.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	private SqlSessionTemplate session;
	private MemberDao dao;
	
	public MemberServiceImpl(SqlSessionTemplate session, MemberDao dao) {
		this.session = session;
		this.dao = dao;
	}
	
	@Override
	public List<Member> selectMemberAll() {
		// TODO Auto-generated method stub
		return dao.selectMemberAll(session);
	}
	
	@Override
	public Member selectByMemberbyId(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
