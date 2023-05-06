package com.dm.springboot.model.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dm.springboot.common.MyAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member implements UserDetails {
	private String userId;
	private String password;
	private String userName;
	private	String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enrollDate;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auth = new ArrayList();
		
		auth.add(new SimpleGrantedAuthority(MyAuthority.USER.name()));
		
		if (userId.equals("admin")) {
			auth.add(new SimpleGrantedAuthority(MyAuthority.ADMIN.name()));
		}
		
		return auth;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userId;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
