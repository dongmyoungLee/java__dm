package com.dm.springboot.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dm.springboot.dao.MemberDao;
import com.dm.springboot.model.mapper.MemberMapper;
import com.dm.springboot.model.vo.Member;

@Primary
@Service
public class MemberServiceImpl implements MemberService {
	private SqlSessionTemplate session;
	private MemberDao dao;
	private MemberMapper memberMapper;
	
	public MemberServiceImpl(SqlSessionTemplate session, MemberDao dao, MemberMapper memberMapper) {
		this.session = session;
		this.dao = dao;
		this.memberMapper = memberMapper;
	}
	
	@Override
	public List<Member> selectMemberAll() {
		// TODO Auto-generated method stub
		return memberMapper.selectMember();
	}
	
	@Override
	public List<Member> selectByMemberbyId(String id) {
		// TODO Auto-generated method stub
		
		return memberMapper.selectMemberById(id);
	}
}
