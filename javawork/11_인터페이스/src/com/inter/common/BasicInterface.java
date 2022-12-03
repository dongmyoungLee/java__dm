package com.inter.common;

public interface BasicInterface {
	// static final 변수만 선언이 가능함.
	public static final int age = 19;
	
	// default 로 static final 붙음.
	String email = "pajang1515@daum.net";
	
	// 추상메소드만 선언이 가능함.
	//public abstract void test();
	void test();
	int calc(int x, int y);
	
	
}
