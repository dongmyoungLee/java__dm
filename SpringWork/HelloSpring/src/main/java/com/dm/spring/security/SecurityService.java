package com.dm.spring.security;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dm.spring.member.model.dao.MemberDao;
import com.dm.spring.member.model.vo.Member;

public class SecurityService implements UserDetailsService {
	
	private MemberDao dao;
	private SqlSessionTemplate session;
	
	public SecurityService(MemberDao dao, SqlSessionTemplate session) {
		super();
		this.dao = dao;
		this.session = session;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member loginMember = dao.selectMemberById(session, username);
		
		if (loginMember == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return loginMember;
	}
	
	
}
