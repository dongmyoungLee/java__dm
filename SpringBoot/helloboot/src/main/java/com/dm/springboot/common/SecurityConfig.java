package com.dm.springboot.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	// security 에서 사용할 bean을 등록한다.
	// 1. 인증처리할 bean 등록
	// 2. 시큐리티 설정하는 bean 등록

	private MyProvider provider;
	
	public SecurityConfig(MyProvider provider) {
		this.provider = provider;
	}
	
	@Bean
	public SecurityFilterChain authenticationPath(HttpSecurity http) throws Exception {
		//authenticationProvider -> 인증처리(로그인 처리 설정)
		return http.csrf().disable().formLogin()
				//.successForwardUrl("/")
				//.failureForwardUrl("/")
				//.loginPage("/loginpage")
				//.passwordParameter("pw")
				//.usernameParameter("id")
				//.loginProcessingUrl("/loginEnd.do")
				.and().authorizeHttpRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/logout.do").permitAll()
				.antMatchers("/loginpage").permitAll()
				.antMatchers("/**").hasAnyAuthority(MyAuthority.ADMIN.name(), MyAuthority.USER.name())
				.and().logout().logoutUrl("/logout.do")
				.and().authenticationProvider(provider).build();
	}
}
