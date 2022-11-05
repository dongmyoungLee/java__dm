package com.bs.variable;

import java.util.Iterator;

public class StringTest {
	public static void main(String[] args) {
		 // 문자열 처리에 대해 알아보자.
		 // String은 자바에서 제공하는 하나의 클래스임.
		 // 편리하게 사용하기 위해서 기본자료형처럼 사용이 가능함
		
		String name = "유병승";
//		System.out.println(name);
		String name2 = new String("유병승2");
//		System.out.println(name2);
		
		// 문자열을 + 연산
		// "문자" + "결합" -> "문자결합"
		// 123 + "문자" -> "123문자"
		// 180.5 + "문자" -> "180.5문자"
		String temp = "점심" + (10+20) + "맛있게" + "먹었나요 ?";
//		System.out.println(temp + 12);
		
		// 리터럴값이 아닌 변수를 활용해서 문자열 연결을 해보자, 따옴표까지 출력할려면 이스케이프 작성
		String test = "\"유병승\"";
		int age = 19;
		temp = test + age;
//		System.out.println(temp);
		
		// 본인 이름, 나이, 키, 주소, 전화번호를 저장하는 변수를 만들고 변수에 각 데이터를 넣고 출력하는 기능 구현하기.
		String name222;
		String address;
		int age2;
		double height;
		String phoneNumber;
		
		name222 = "이동명 ";
		age2 = 29;
		height = 170.5;
		address = " suwon";
		phoneNumber = " 010-5540-1958 ";
		
		//System.out.println(name222 + age2 + address + phoneNumber + height);
		
		
		// String은 클래스로 유용한 기능을 제공함.
		// 1. String에 저장된 문자열의 길이를 알려주는 기능(method)
		// length();
		// "문자열".length();
		//System.out.println("오늘은 토요일 입니다.".length());
		
		// 2. 문자열에 저장 된 각 문자만 한개씩 출력하는 기능 (메소드)
		String str = "경기도 시흥시";
		//System.out.println(str.charAt(0));
		//System.out.println(str.charAt(1));
		
		
		/*
		 
		 오버플로우
		 
		 양수랑 음수를 표현하기 위해 2진수 변환법에서 맨 앞자리는 비워둔다 이를 부호비트 라고 한다.
		 
		  
		 * */
		 
		
		
		
	}
}
