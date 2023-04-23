package com.dm.spring.chatting;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChattingServer extends TextWebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 클라이언트가 접속하면 실행되는 메소드
		log.debug("클라이언트 접속 !!!");
		
		// 접속한 사용자에게 환영메세지 전송
		session.sendMessage(new TextMessage("입장을 환영합니다!"));
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// js 에서 send(data) 함수를 실행하면 실행되는 함수
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 클라이언트 접속이 종료되면 실행되는 함수
	}
	
}
