package com.inter.common;

public interface PrintDriver {
	void print();
	
	
	// 기본 메소드를 선언하게 하자..
	// default 메소드
	default void test() {
		System.out.println("기본메소드 추가하기");
	}
}
