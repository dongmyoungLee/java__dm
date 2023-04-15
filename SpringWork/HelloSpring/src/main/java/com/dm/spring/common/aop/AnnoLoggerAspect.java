package com.dm.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

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
		//log.debug(sig.getName() + " 메소드 실행 전 ");
		//log.debug(sig.getDeclaringTypeName() + " 클래스");
		
		// 메소드 실행시 전달되는 파라미터값 확인하기
		Object[] params = jp.getArgs();
		
		if (params != null) {
			for(Object o : params) {
				//log.debug("파라미터 : {}", o);
			}
		}
		
		//log.debug("==============================end");
	}
	
	@After("memberLogger()")
	public void loggerAfter(JoinPoint jp) {
		Signature sig = jp.getSignature();
		//log.debug(sig.getName() + " 메소드 실행 후 ");
		//log.debug(sig.getDeclaringTypeName() + " 클래스");
		//log.debug("==============================end");
	}
	
	// 실행 전후에 로직 실행시키기 @Around
	
	@Pointcut("execution(* com.dm.spring.demo..*(..))")
	public void demoLogger() {};
	
	@Around("demoLogger()") // 전, 후를 동시 선언.. 반환형 Object..
	public Object demoLoggerAround(ProceedingJoinPoint pjp) throws Throwable {
		// 전,후 구분하기 -> ProceedingJoinPoint.proceed() 메소드를 기준으로 전, 후를 나눔..
		// proceed() 호출되기 전 : before로직, proceed() 호출된 후 : after로직
		// proceed() 메소드는 Object를 반환
		Signature sig = pjp.getSignature();
		
		// before 로직..
		//log.debug("===== Around 실행 전 =====");
		//log.debug(sig.getName() + " 메소드 실행 !");
		//log.debug("END==========================");
	
		Object obj = pjp.proceed();
		
		// after 로직..
		//log.debug("===== Around 실행 후 =====");
		//log.debug(sig.getName() + " 메소드 실행 !");
		//log.debug("END==========================");
		
		return obj;
	}
	
	@Around("execution(* com.dm.spring..insert*(..))")
	public Object insertTest(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object obj = pjp.proceed();
		
		stopWatch.stop();
		//log.debug("실행시간 : " + stopWatch.getTotalTimeMillis() + "ms");
		
		return obj;	
	}
	
	@AfterThrowing("execution(* com.dm.spring..*(..))")
	public void exceptionTest(JoinPoint jp) {
		log.debug("에러발생!");
	}
}






