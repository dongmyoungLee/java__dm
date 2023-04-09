package com.dm.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// Annotation 방식으로 aop 적용해보자..
@Component
@Aspect
@Slf4j
public class AnnoLoggerAspect {
	/*member 패키지에 있는 모든 method..*/
	@Pointcut("execution(* com.dm.spring.member..*(..))")
	public void memberLogger() {};
	
	@Before("memberLogger()")
	public void loggerBefore(JoinPoint jp) {
		Signature sig = jp.getSignature();
		log.debug(sig.getName() + " 메소드 실행 전 ");
		log.debug(sig.getDeclaringTypeName() + " 클래스");
		log.debug("==============================end");
	}
	
}
