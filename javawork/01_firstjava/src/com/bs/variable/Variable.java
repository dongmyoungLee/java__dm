package com.bs.variable;

public class Variable {
	// main method 만들기
	public static void main(String[] args) {
		// 변수선언하기
		// RAM 영역에 사용할 공간을 확보하는 것
		
		// boolean 자료형은 1byte로 true, false 리터럴을 저장할 수 있음!.
		// 선언한 변수를 이용하려면 변수명을 사용한다.	
		boolean flag;
		flag = true;
	//	System.out.println(flag);
		flag = false;
	//	System.out.println(flag);
		
		// 정수형변수 선언/대입하기
		byte bnum; //  파일데이터를 가져오거나 할 때 사용한다. -> byte 배열을 이용함.
		short snum; // 2byte 크기를 갖는다.
		int num; // 4byte의 크기를 갖고, 기본적으로 숫자를 저장할 때 많이 쓴다.
		long lnum; // 8byte 크기를 갖고, int 형의 범위를 넘어서는 값을 저장할때 사용
		
		bnum = 100;
		snum = 120;
		num = 200;
		lnum = 100000000000L;
		
		
		//System.out.println(bnum);
		//System.out.println(snum);
		//System.out.println(num);
		//System.out.println(lnum);
		
		// 실수 : 소수점수
		float fnum; // 4byte
		double dnum; // 8byte default 자료형
		
		fnum = 180.5f;
		dnum = 65.5;
		
		
		// 문자를 저장하는 경우
		// 문자를 표시하는 리터털은 '' 홀따옴표로 표현을 함.
		char ch; //2byte 문자한개를 저장 할 수 있는 공간으로 지정된 코드표와 매핑되어 있음.
		ch = 'A'; // 내부 저장 영역에선 ascii 코드 65 로 저장이된다.
		
		// 단어나 문장을 저장하는 변수
		// String -> 예약어가 아니라 클래스임. 문장, 단어, 1개이상의 문자를 저장하는 저장소.
		String msg;
		msg="여러분 조금 있으면 점심시간 이에요";
		
		
	//	System.out.println(ch);
	//	System.out.println(msg);
		
		
		// 변수의 명명규칙
		// 1. 대소문자를 구분함.
		int age;
		age = 19;
		int aGe;
		aGe = 33;
		
//		System.out.println(age);
//	System.out.println(aGe);
		
		// 2. 변수명의 길이에는 제한이 없다.
		double asdasdsfdsfewfsfsdlfldsfsdlfdlsldllelle;
		asdasdsfdsfewfsfsdlfldsfsdlfdlsldllelle = 3.14;
//		System.out.println(asdasdsfdsfewfsfsdlfldsfsdlfdlsldllelle);
		
		
		// 3. 예약어를 사용할 수 없다.
		// short public
		
		// 4. 변수명에 특수기호는 _, $ 만 사용 가능하다.
		char $ch;
		char ch_;
		//char ch^;
		
		// 5. 여러단어를 사용시 카멜케이스 적용한다.
		
		
		// 변수선언할때 동일한 자료형에 다수의 변수를 선언한다면 한번에 선헌할 수 도 있다.
		
		int a,b,c,d;
		a = 10;
		b = 20;
		c = 30;
		d = 40;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		// 동일 영역 안에서 (scope 내 에서) 동일한 이름의 변수명을 사용할 수 없다.
		
//		String a (중복)
		
		// 상수활용하기
		// 상수는 한번 값을 대입하면 그 값을 유지하는 저장공간 * 더이상 다른 값을 대입할 수 없다. 통상 상수는 대문자로 사용함.
		final int AGE;
		AGE = 19;
		
//		System.out.println(AGE);
		
		String str = "기차" + 123;
		
		System.out.println(str);
		
	}//main

}
