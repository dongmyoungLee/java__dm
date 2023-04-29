package com.dm.spring.member.model.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member implements UserDetails {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2312487527606301309L;
	private String userId;
	private String password;
	private String userName;
	private String name;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String[] hobby;
	private Date enrollDate;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 로그인 해서 성공하면 무조건 ROLE_USER 라는 권한을 줌
		List<GrantedAuthority> auth = new ArrayList();
		
		SimpleGrantedAuthority user = new SimpleGrantedAuthority("USER");
		
		auth.add(user);
		
		if(userId.equals("admin")) {
			SimpleGrantedAuthority manager = new SimpleGrantedAuthority("ADMIN");
			auth.add(manager);
		}
		
		if(userId.equals("admin1")) {
			auth.add(new SimpleGrantedAuthority("SELEER"));
		}
		
		return auth;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userId;
	}
	@Override
	public boolean isAccountNonExpired() {

		return true;
	}
	@Override
	public boolean isAccountNonLocked() {

		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}
	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	
}


