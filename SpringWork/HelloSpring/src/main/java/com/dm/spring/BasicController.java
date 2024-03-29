package com.dm.spring;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BasicController {
	// log4j 로 출력하려면 log4j 가 제공하는 객체를 이용..
	// Logger 클래스가 제공하는 메소드를 이용
	// debug(), info(), warn(), error()
	
	private Logger logger = LoggerFactory.getLogger(BasicController.class);
	
	@RequestMapping("/")
	public String mainView(HttpServletResponse response, HttpSession session) {
		
		// 쿠키 저장하기..
		Cookie c = new Cookie("testCookie", "cookieData");
		c.setMaxAge(60*60*24);
		response.addCookie(c);
		
		// session 객체에 데이터 저장..
		session.setAttribute("sessionId", "admin");
		
		
		
		/*
		logger.debug("debug레벨 출력");
		logger.info("infor 레벨 출력");
		logger.warn("warn레벨 출력");
		logger.error("error 레벨 출력");
		*/
		
		
		//logger 를 이용해서 메세지 출력시 String을 인수로 받는다.
		// 객체를 출력할때는 매개변수가 두개인 메소드를 이용해야한다.
		// 첫번째는 매개변수에 문자열로 {}, 두번째는 대입될 값을 선언
		logger.info("{}", session);
		
//		if(session != null) {
//			throw new IllegalArgumentException();
//		}
		
		return "index";
		
	
	}
	
	
	@RequestMapping("/error.do")
	public String error(Model m) {
		
		m.addAttribute("msg", "아이디나 패스워드가 일치하지 않습니다.");
		m.addAttribute("loc", "/member/loginpage.do");
		
		return "common/msg";
	}
	
	@RequestMapping("/successLogin.do")
	public String successLogin() {
		
		// security 가 저장한 로그인 정보 가져오기
		Object o = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		logger.debug("{}", o);
		
		return "redirect:/";
	}
}













