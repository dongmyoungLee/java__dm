package com.dm.spring.chatting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
	private String type;
	private String sender;
	private String receiver;
	private String msg;
	private String room;
}
