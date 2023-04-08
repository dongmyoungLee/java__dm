package com.dm.spring.common.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dm.spring.member.controller.MemberController;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	// member로 시작하는 url 실행되기전 로그를 출력하는 기능
	
	
	private Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

	// 맵핑 메소드가 실행되기 전에 실행할 로직을 구현하는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//return super.preHandle(request, response, handler);
		
		logger.debug("----전처리 interceptor 실행 ----");
		logger.debug(request.getRequestURI());
		
		//handler 인수 이용하기
		HandlerMethod method = (HandlerMethod)handler;
		// 실행되는 클래스(controller)정보 가져오기
		logger.debug("{}", method.getBean());
		MemberController c = (MemberController)method.getBean();
		// 실행되는 메소드에 대한 정보들
		logger.debug("{}", method.getMethod());
		
		Method m = method.getMethod();
		
		
		logger.debug("-----------------------------");
		// return 값
		// true : 맵핑메소드 실행
		// false : 맵핑메소드 실행하지 않음
		
		return true;
		
	}
	
	// 맵핑 메소드가 실행된 후 실행하는 로직
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		logger.debug("----- 후처리 실행 -----");
		logger.debug(modelAndView.getViewName());
		logger.debug("{}", modelAndView.getModelMap());
		logger.debug("----------------------");
	}
	
}
