package com.poly.abstracttest.model.vo;

// 추상클래스에 추상메소드가 있는 경우 무조건 Override 해줘야한다...
public class TestChild extends InnerAbstractMethod {
	
	@Override
	public void testAbstract() {
		System.out.println("ggg");
	}
}
