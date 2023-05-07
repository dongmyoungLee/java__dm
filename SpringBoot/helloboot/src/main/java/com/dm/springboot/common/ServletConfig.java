package com.dm.springboot.common;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

//@Configuration
public class ServletConfig {
	
	@Bean
	public FilterRegistrationBean<CharacterEncodingFilter> encoding() {
		FilterRegistrationBean<CharacterEncodingFilter> register = new FilterRegistrationBean<CharacterEncodingFilter>();
		
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		register.setFilter(encodingFilter);
		register.addUrlPatterns("/*");
		register.setName("encodingFilter");
		
		return register;
	}
}
