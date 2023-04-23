package com.dm.spring.chatting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChattingController {
	
	@RequestMapping("openchatting.do")
	public String openChatting() {
		
		return "chatting/chat";
	}
}
