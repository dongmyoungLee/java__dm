package com.poly.abstracttest.model.vo;

public abstract class InnerAbstractMethod {
	
	// 추상 메소드 선언
	// abstract 예약어를 사용..
	// 추상메소드는 선언부만 사용... 구현부는 사용안함 추상클래스여야함.
	// 상속받은 클래스에서 반드시 Override 해야 한다.
	// 자식클래스에는 반드시 추상메소드가 구현되어있다는 것을 보장함
	public abstract void testAbstract();
	
}
