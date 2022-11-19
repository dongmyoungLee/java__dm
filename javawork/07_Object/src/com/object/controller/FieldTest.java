package com.object.controller;

import java.util.Arrays;

public class FieldTest {
	// 클래스에 필드선언하기
	// 클래스내에 필요한 상태값(데이터)가 있으면 선언하는 ㅓ것.
	// 선언하는 방식
	// 클래스 선언 내부({}안)에 변수 선언과 동일한 방식으로 선언
	// 필드로 선언된 저장공간은 클래스 생성시 이용이 가능함. 생성하지 않으면 이용이 불가능함.
	// 접근제한자 [예약어] 자료형 변수명;
	
	// public : 프로젝트 내에서 모두 직접접근이 가능함.
	// protected : 상속받은 클래스나 같은 패키지내에서 직접접근이 가능함.
	// default : 같은패키지, 클래스내부에서 직접접근이 가능함.
	// private : 클래스 내부에서만 직접접근 가능함.
	
	// 직접접근 : 접근연산자 . 을 이용해서 변수에 접근하는 것을 의미한다.
	public int age = 19;
	String name = "유병승";
	private char gender = '여';
	
	// 필드타입은 모든 것을 다 선언 할 수 있음.
	// 배열, 다른 클래스 등을 필드로 선언할 수 있다.
	public String[] hobby;
	public ObjectController pt = new ObjectController();
	
	// 필드 예약어 사용하기
	// final, static
	// final : 변경되지 않는 저장공간
	
	// final 로 선언시 .. 선언과동시에 초기화를 해주거나 나중에 생성자로 초기화를 해주던가 해줘야한다.
	public final double HEIGHT = 180.5;
	public double weight;
	
	// static : 선언한 변수를 static 영역에 저장하는 예약어..
	public static int count = 0;
	
	
	
	public void testP() {
	//	System.out.println(Arrays.toString(this.hobby));
	//	System.out.println(this.pt);
	}
	
	// 학생정보를 저장하는 클래스를 생성해서 이용하기.
	// 학생정보 : 이름, 나이, 학년, 반, 키 ,주소
	// 모든필드는 어디서든 접근 가능하게 설정.
	// 아래 학생들을 생성해서 출력
	// 유병승 19 1 3 180.5 경기도시흥시
	// 유병승2 18 2 3 185.5 경기도도
	// 유병승3 17 3 3 181.5 경기도시
	// 유병승4 16 4 3 182.5 경기도레
	// 유병승5 15 5 3 183.5 경기도파
	
	
	

}
