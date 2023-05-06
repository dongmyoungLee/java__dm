package com.dm.springboot.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggerAspect {
	@Before("execution(* com.dm.springboot..*(..))")
	public void logger(JoinPoint jp) throws Throwable {
		Signature sig = jp.getSignature();	
		log.info(sig.getName());
	}
	
	
}
