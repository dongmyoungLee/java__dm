package com.operator.controller;

public class OperatorController {
	// 기능 제공용 클래스..
	public void singleOp() {
		// 단항 연산자..
		// 1. 부정연산자 : boolean 형 데이터를 반전시키는 연산자
		// 표현 : !변수명 또는 !기능(메소드) 호출구문
		// ex) !flag, !str.equals("test")
		
		System.out.println("==== 부정연산자 활용하기 =====");
		
		boolean flag = true;
		System.out.println(!flag);
		System.out.println(flag);
		
		System.out.println("유병승".equals("유병승"));
		System.out.println(!"유병승".equals("유병승"));
		
		int age = 19;
		System.out.println(!(age < 20));
	}
}
