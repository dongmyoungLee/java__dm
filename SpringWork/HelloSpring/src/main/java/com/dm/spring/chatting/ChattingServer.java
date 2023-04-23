package com.dm.spring.chatting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChattingServer extends TextWebSocketHandler {
	
	private Map<String, WebSocketSession> clients = new HashMap();
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 클라이언트가 접속하면 실행되는 메소드
		log.debug("클라이언트 접속 !!!");
		
		// 접속한 사용자에게 환영메세지 전송 (JSON 방식..)
		Message welcome = new Message("system", "admin", "", "입장을 환영 합니다.", "");
		session.sendMessage(new TextMessage(mapper.writeValueAsString(welcome)));	
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// js 에서 send(data) 함수를 실행하면 실행되는 함수
		log.debug("{}", message.getPayload());
		Message msg = mapper.readValue(message.getPayload(), Message.class);
		
		switch(msg.getType()) {
			case "connect" :
				addClients(session,msg);
			break;
			case "msg" :
				sendMessage(msg);
			break;
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 클라이언트 접속이 종료되면 실행되는 함수
		
		log.debug("session종료 : " + status.getReason());
		
		String userId = "";
		
		System.out.println("clients " + clients);
		
		for(Map.Entry<String, WebSocketSession> client : clients.entrySet()) {
			
			if(client.getValue().equals(session)) {
				userId = client.getKey();
			}
			
		}
		
		sendMessage(Message.builder().type("system").msg(userId + " 님이 퇴장 하셨습니다.").build());
		
		deleteClients();
	}
	
	private void sendMessage(Message msg) {
		// 클라이언트가 보낸 메세지 전송처리하는 기능
		
		try {
			for(Map.Entry<String, WebSocketSession> client : clients.entrySet()) { 
				if (client.getValue().isOpen()) {
					client.getValue().sendMessage(new TextMessage(mapper.writeValueAsString(msg)));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void addClients(WebSocketSession session, Message msg) {
		clients.put(msg.getSender(), session);
	
		// 접속중단된 클라이언트 삭제
		deleteClients();
		
		Message info = Message.builder().type("system").sender("admin").msg(msg.getSender() + " 님이 접속 하셨습니다.").build();
		sendMessage(info);
	}
	
	private void deleteClients() {
		Iterator<Map.Entry<String, WebSocketSession>> it = clients.entrySet().iterator();
		

		while(it.hasNext()) {
			Map.Entry<String, WebSocketSession> client = it.next();
			
			if (!client.getValue().isOpen()) {
				it.remove();
			}
		}
	}
}



