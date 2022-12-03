package com.inter.controller;

import com.inter.common.BasicInterface;
import com.inter.model.vo.BasicInterfaceClass;

public class InterfaceController {
	public void basicInterface() {
		// 기본 인터페이스 이용하기
		// 인터페이스는 추상메소드와 static 상수를 가지는 객체
		// 자체 생성이 불가능하고, 클래스에 의해 구현됨(선언된 추상메소드)
		
		// 인터페이스와 구현한 클래스는 상속관계로 연결됨. -> 다형성이 적용된다.
		// 인터페이스도 하나의 타입으로 사용
		// ex) public interface 인터페이스명 { 구현(static 변수, 추상메소드 선언) }
		// 선언된 인터페이스를 구현하는 방법
		// 클래스 선언부에 implements 예약어를 사용함.
		// public class 클래스명 impleaments 인터페이스명 {}
		
		BasicInterface bis = new BasicInterfaceClass();
		bis.test();
		
		System.out.println(bis.calc(10, 20));
		
		//new BasicInterface(); // 불가
		
		
	}
}
