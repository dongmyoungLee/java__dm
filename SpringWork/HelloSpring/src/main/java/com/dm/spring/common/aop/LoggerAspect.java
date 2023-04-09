package com.dm.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import lombok.extern.slf4j.Slf4j;

// 로그를 출력해주는 공통기능
@Slf4j
public class LoggerAspect {
	
	// 공통으로 실행할 메소드를 선언
	// 메소드를 선언할때는 선언방식이 advisor 에 따라 정해져 있음.
	// before advisor 등록하기
	
	public void loggerBefore(JoinPoint jp) {
		log.debug("===== before logger 실행 =====");
		
		// jp 를 이용해서 실행하는 메소드, 클래스명 출력하기
		Signature sig = jp.getSignature();
		log.debug(sig.getDeclaringType() + " : " + sig.getName());
		log.debug("=============================");
	}
	
	public void loggerAfter(JoinPoint jp) {
		log.debug("===== after logger 실행 =====");
		Signature sig = jp.getSignature();
		log.debug(sig.getDeclaringType() + " : " + sig.getName());
		log.debug("=============================");		
	}
}
