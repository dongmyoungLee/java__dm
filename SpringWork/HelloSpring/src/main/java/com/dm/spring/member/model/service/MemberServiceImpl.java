package com.dm.spring.member.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.spring.member.model.dao.MemberDao;
import com.dm.spring.member.model.vo.Member;


@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberDao dao;
	private SqlSessionTemplate session;
	
	@Autowired
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	@Autowired
	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}

	@Override
	public List<Member> selectMemberAll() {
		// TODO Auto-generated method stub
		return dao.selectMemberAll(session);
	}

	@Override
	public Member selectMemberById(String userId) {
		// TODO Auto-generated method stub
		return dao.selectMemberById(session, userId);
	}

	@Override
	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		return dao.insertMember(session, m);
	}

	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
