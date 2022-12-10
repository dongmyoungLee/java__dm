package com.api.controller;

public class WrapperController {
	public static void main(String[] args) {
		// 기본자료형을 객체화해서 사용할 수 있게 해주는 클래스
		// 필요시 자동으로 변환해줌..
		
		Integer objInt = new Integer(10);
		System.out.println(objInt);
		System.out.println(objInt + 100);
		
		// 클래스로 만들었는데 기본자료형과 같이 매핑시켜버림..
		// 자동 형변환..
		int su = 19;
		objInt = su;
		
		Object o = su;
		Object[] data = {100, 'c', true, 180.5};
		
		// Wrapper 클래스는 필요한 메소드를 static 으로 제공한다
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.min(100,90));
		
		// 문자열을 기본형으로 변환해주는 메소드를 wrapper 클래스에서 제공
		String test = "19";
		// 안되니까..
		//int age = test;
		// 이것도 안되니까
		//int age = (Integer)test;
		// 이렇게.. 다만 문자열이 int 형으로 변환이 가능한 값만 가능...
 		int age = Integer.parseInt(test);
		System.out.println(age);
		
		String height = "180.5";
		double h = Double.parseDouble(height);
		System.out.println(height);
		
		test(10); //Integer 로 자동 형변환이 되서 대입이된다..
	}
	
	public static void test(Object o) {
		System.out.println(o);
	}
}
