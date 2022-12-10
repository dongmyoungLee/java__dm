package com.exception.run;

import com.exception.controller.ExceptionTest;
import com.exception.controller.MyException;
import com.exception.controller.MyRunException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExceptionTest et = new ExceptionTest();
		
		//et.uncheckedException();
		//et.checkedException();
		//et.divided(0, 0);
		//et.checkedExceptionCase();
		
		/*
		try {
			et.checkedThrowTest();
		}	catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		*/
		
		// 나의 Exception 발생시키기, Exception 을 상속받으면 checkedException 이 된다.
		try {
			throw new MyException("나만의 예외 ㅋ ");
		}	catch(MyException e) {
			e.printStackTrace();
		}
		
		// unchecked Exception
		throw new MyRunException("런타임 exception");
		
		
	}
	
	
	// 예외클래스 커스터마이징 하기
	// 시스템에 필요한 예외 만들기
	// Exception, RuntimeException, IoException 을 상속한 클래스를 만들면 Exception 클래스가 된다.
	
	

}
