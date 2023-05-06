package com.dm.springboot.common;

import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.dm.springboot.model.vo.Member;

//사용자 인증관련 설정
@Component
public class MyProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userId = authentication.getName();
		String password = (String)authentication.getCredentials();
		
		if (!userId.equals("admin") || !password.equals("1234")) {
			throw new BadCredentialsException("인증 실패");
		}
		
		Member m = new Member();
		m.setUserId(userId);
		m.setPassword("1234");
		m.setUserName("관리자");
		List<GrantedAuthority> auto = List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		return new UsernamePasswordAuthenticationToken(m, password, auto);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
}
