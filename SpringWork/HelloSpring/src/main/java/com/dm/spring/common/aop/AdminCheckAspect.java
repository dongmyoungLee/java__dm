package com.dm.spring.common.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.dm.spring.common.AdminCheckException;
import com.dm.spring.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class AdminCheckAspect {
	
	//@Before("execution(* com.dm.spring.memo..select*(..))")
	public void adminCheck(JoinPoint jp) {
		// 1. 로그인 정보를 가져오기, - RequestContextHolder 클래스를 이용해서 request 정보를 가져올 수 있음..
		// RequestContextHolder - currentRequestAttribute() 메소드 이용해보자..
		
		HttpSession session = (HttpSession)RequestContextHolder
				.currentRequestAttributes()
				.resolveReference(RequestAttributes.REFERENCE_SESSION);
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		if (loginMember == null || !loginMember.getUserId().equals("admin")) {
			// 관리자가 아닌 상태.. 바로 exception..
			throw new AdminCheckException("관리자만 접근할 수 있습니다.");
		}
		
		
	}
}



