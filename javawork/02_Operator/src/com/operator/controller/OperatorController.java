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
//		System.out.println(!flag);
//		System.out.println(flag);
//		
//		System.out.println("유병승".equals("유병승"));
//		System.out.println(!"유병승".equals("유병승"));
		
		int age = 19;
//		System.out.println(!(age < 20));
		
		int count = 0;
		count++;
//		System.out.println(count);
		++count;
//		System.out.println(count);
		
		// ++ 연산이 단독으로 사용했을때는 연산결과가 동일하다.
		// 다른 연산과 같이 사용했을때는 앞에 있을때(전위)와 뒤에(후위)있을때가 다름.
		// 아래 예제같은 경우 연산의 순서 때문에 값이 다름.
		int newCount = 0;
		int result = newCount++;
		// 후위증가 한 값 자체는 올라가지만 , 대입연산이 연산순서가 빠르기 때문에 초기화해준 0이 나옴. 여기서도 1이 나오게 할려면 전위연산을 사용해야한다.
//		System.out.println(result);
		// 후위증가 한 값 자체는 올라감
//		System.out.println(newCount);
	}
	
//	method선언..
	public void calculatorOp( ) {
		// 산술연산자에 대해 알아보자
		// +,-,*,/,% (나머지)
		
		int su = 2;
		int su2 = 10;
		int result = su + su2;
	//	System.out.println(result);
		
		//나누기 연산은 항상 자료형에 주의를 해야한다.
		su=10;
		su2=3;
		double result2=(double)su/su2;
		// 정확한 값이 나오지 않는다 이유는 int 와 int 를 나눴기 때문에 자연스럽게 정수로 표현함. 원하는값을 표현하려면 강제 형변환(캐스이 필요함), 또한 그 값을 받을 변수 type 도 바꿔줘야한다. 
//		System.out.println(result2);
		
		// 나머지연산 %
		// 짝수, 홀수, 배수, 약수 등을 구할 때 사용됨.
		// 어떤수 x를 4로 나눴을 때 나머지 ? -> 0,1,2,3 만 나오는데 이러한 조건으로 로직을 짤 수 있음.
		
		su=30;
		result=su%3;
		result=su%4;
		System.out.println(result);
		
		// 비교연산 사욯할 경우
		// num % 2 == 0 -> 짝수,  num % x == 0 -> x의 배수,
		
	}
}
