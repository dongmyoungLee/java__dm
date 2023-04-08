package com.dm.spring;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {
	
	@RequestMapping("/")
	public String mainView(HttpServletResponse response, HttpSession session) {
		
		// 쿠키 저장하기..
		Cookie c = new Cookie("testCookie", "cookieData");
		c.setMaxAge(60*60*24);
		response.addCookie(c);
		
		// session 객체에 데이터 저장..
		session.setAttribute("sessionId", "admin");
		
		
		

		return "index";
	}
	
	
}













