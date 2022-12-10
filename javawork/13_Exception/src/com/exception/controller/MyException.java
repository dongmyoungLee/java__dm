package com.exception.controller;

public class MyException extends Exception {
	// 예외 클래스들 .. Exception 상속받음
	
	public MyException(String msg) {
		super(msg);
	}
}
