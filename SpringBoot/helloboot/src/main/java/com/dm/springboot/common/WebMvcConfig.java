package com.dm.springboot.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	// 기본 화면 전환에 대한 설정을 하는 메소드 구현
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}
	
	
	// vue, react, angular 등 js프레임워크를 view로 선정하였을 때
	// ajax 를 이용해서 요청을 보냄 -> javascript 보안상 같은 origin이 아니면 통신을 차단해버림.. -> cors
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:3000");
	}
	
	
	
	
}
