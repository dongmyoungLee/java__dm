package com.dm.springboot.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.dm.springboot.websocket.ChattingServer;

@Configuration
@EnableWebSocket
public class WebMvcConfig implements WebMvcConfigurer, WebSocketConfigurer{

	private ChattingServer chatServer;
	
	public WebMvcConfig(ChattingServer server) {
		this.chatServer = server;
	}
	
	// 기본 화면 전환에 대한 설정을 하는 메소드 구현
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/loginpage").setViewName("loginPage");
	}
	
	
	// vue, react, angular 등 js프레임워크를 view로 선정하였을 때
	// ajax 를 이용해서 요청을 보냄 -> javascript 보안상 같은 origin이 아니면 통신을 차단해버림.. -> cors
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("http://localhost:3000");
	}

	// websocket 요청을 처리하는 객체 등록하기
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addHandler(chatServer, "/chatting").setAllowedOrigins("*");
	}
	
	
	
	
	
}
