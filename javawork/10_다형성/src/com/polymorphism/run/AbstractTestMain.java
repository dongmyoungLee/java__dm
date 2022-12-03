package com.polymorphism.run;

import com.poly.abstracttest.model.vo.AbstarctTest;
import com.poly.abstracttest.model.vo.AbstractChild;
import com.poly.abstracttest.model.vo.InnerAbstractMethod;
import com.poly.abstracttest.model.vo.TestChild;
import com.poly.abstracttest.model.vo.TestChild2;

public class AbstractTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 추상클래스 객체생성 불가능
		//AbstractTest ab = new AbstractTest();
		
		// 추상클래스는 반드시 상속을 받아서 사용..ㅕ
		AbstractChild ac = new AbstractChild();
		ac.setName("유병승");
		System.out.println(ac.getName());
		
		// 추상클래스는 타입으로 사용이 가능
		AbstarctTest at = new AbstractChild();
		
		// 추상메소드를 포함하고 있는 클래스는 반드시 추상 클래스로 선언을 해야한다.
		
		InnerAbstractMethod iam = new TestChild();
		iam.testAbstract();
		
		//test(new TestChild());
		test(new TestChild2());
		
		// 추상메소드가 선언된 클래스는 익명클래스로 생성 할 수 있음...
		InnerAbstractMethod in = new InnerAbstractMethod() {
			@Override
			public void testAbstract() {
				
			}
		};
		
		test(in);
		
	}
	
	public static void test(InnerAbstractMethod param) {
		param.testAbstract();
	}

}
