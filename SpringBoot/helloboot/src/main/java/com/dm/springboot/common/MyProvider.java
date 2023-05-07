package com.dm.springboot.common;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dm.springboot.model.mapper.MemberMapper;
import com.dm.springboot.model.vo.Member;

//사용자 인증관련 설정
@Component
public class MyProvider implements AuthenticationProvider {
	private MemberMapper mapper;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public MyProvider(MemberMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userId = authentication.getName();
		String password = (String)authentication.getCredentials();
		Member loginMember = mapper.selectMemberLogin(userId);
		
		
		 if (loginMember == null || !encoder.matches(password,
		 loginMember.getPassword())) { throw new BadCredentialsException("인증 실패"); }
		 
		
		return new UsernamePasswordAuthenticationToken(loginMember, loginMember.getPassword(), loginMember.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
}
