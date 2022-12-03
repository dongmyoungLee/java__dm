package com.inter.common;



//추상메소드 한개만 지정한 인터페이스 라는 의미임
@FunctionalInterface 
public interface TestLambda {
	// 추상메소드 하나만!!
	String checkStr(String str, char ch);
	
	// 하지만 default 선언은 할 수 있음..
	default void printTest() {
		
	}
}
