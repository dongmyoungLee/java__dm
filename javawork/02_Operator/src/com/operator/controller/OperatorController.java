package com.operator.controller;

import java.util.Scanner;

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
//		System.out.println(result);
		
		// 비교연산 사욯할 경우
		// num % 2 == 0 -> 짝수,  num % x == 0 -> x의 배수,
	}
	
	public void compareOp() {
		// 비교연산
		// 비교연산의 결과는 boolean(true,false) 로 반환.
		// 동등비교 : 값의 일치, 불일여부 판단,
		// 기본자료형 : ==, !=
		// 참조자료형 : equals(); -> 메소드 사용.
		// 대소비교 : 값의 크기를 비교 -> 크다 작다 크거나 같다, 작거나 같다,
		// 숫자형 자료형에 적용 : > , < , >=, <=
		
		// 문자열을 동등비교하기. 클래스(참조형 자료형)을 비교하는 것.
		// equals() 메소드를 이용해야 한다.
		String str = "유병승";
		String str2 = "유병승2";
		String str3 = new String("유병승");
//		Scanner sc = new Scanner(System.in);
		
//		str == str3 은 false 이다.
//		str, str2 같은 경우는 값이 아니라 사실 class 이기 때문에 저장소에 주소값이 저장되어있다. 리터럴로 쓰게 될 경우 같은 값을 공유하기 때문에 같게 나오지만
// 		str3 같은 경우에는 새롭게 주소를 생성해서 저장을 하기 때문에 서로 값을 공유한 str, str2 와는 다른값이 나오게 됨.
		// 따라서 == 으로 비교할 경우 주소값을 비교하는것임.
		// 따라서 문자열을 비교할때는 반드시 equals 로 확인해야함.
		
		//System.out.println("당신의 이름은 ?");
		//String name = sc.nextLine();
		//System.out.println(str3.equals(name));
		
		// char는 대소비교가 가능할까 ?
		int ch = 'A';
		int ch2 = 'B';
		int ch3 = 'a'; 
		//System.out.println(ch > ch2); 
		// 입력받은값이 알파벳 대문자인지 확인하는 기능 ?
		//System.out.println('A' <= ch3);
		//System.out.println('Z' >= ch3);
		
	}
	public void logicOp() {
		//id 가 admin 이고 password 가 1234가 맞나 ?
		String id = "admin";
		String pass = "1234";
		
		String address = "서울";
		int age = 40;
		
		//System.out.println(id.equals("admin") && pass.equals("1234"));
		
		// 사는곳이 서울 또는 인천이면서 30대인 사람
		System.out.println((address.equals("서울") || address.equals("인천")) && (age >= 30 && age < 40));
		
	}
	
	public void myCalculator() {
		// 계산기 만들기
		// public void myCalculator() 메소드 만들고
		// 사용자에게 두 수를 입력받고, 그 두 수의 +,/,*,- 결과를 출력해주는 기능 만들기
				
		Scanner sc = new Scanner(System.in);
		
		int num1,num2;
		String flag;
		
		System.out.print("무슨 연산을 하시겠습니까 ? ex) +, -, /, * ");
		flag = sc.next();
		
		switch(flag) {
			case "+":
				plus();
			break;
			case "-":
				minus();
			break;
			case "*":
				multiply();
			break;
			case "/":
				divide();
			break;
			default:
				System.out.println("올바른 연산을 입력해주세요.");
				myCalculator();
			break;
		}
		
	}
	
	public void plus() {
		Scanner sc = new Scanner(System.in);
		int num1,num2;
		double dnum1,dnum2;
		boolean flag,flag2;
	
		System.out.println("첫번째 수를 입력하세요.");
		flag = sc.hasNextInt();
		
		// 첫번째수가 정수일 경우..
		if (flag) {
			num1 = sc.nextInt();
			System.out.println("두번째 수를 입력하세요.");
			flag2 = sc.hasNextInt();
			
			// 두번째 수도 정수일 경우..
			if (flag2) {
				num2 = sc.nextInt();
				System.out.println(num1 + num2);
				return;
			}
			
			// 두번째 수가 정수가 아닐 경우.
			if (!flag2) {
				dnum2 = sc.nextDouble();
				System.out.println(num1 + dnum2);
				return;
			}

			return;
		}
		
		// 첫번째수가 정수가 아닐 경우..
		if (!flag) {
			dnum1 = sc.nextDouble();
			System.out.println("두번째 수를 입력하세요.");
			flag2 = sc.hasNextInt();
			
			// 두번째 수도 정수가 아닐 경우..
			if (!flag2) {
				dnum2 = sc.nextDouble();
				System.out.println(dnum1 + dnum2);
				return ;
			}
			
			// 두번째 수가 정수일 경우..
			if (flag2) {
				num2 = sc.nextInt();
				System.out.println(dnum1 + num2);
				return;
			}
			
			return;
		}
		
	}
	public void minus() {
		Scanner sc = new Scanner(System.in);
		int num1,num2;
		double dnum1,dnum2;
		boolean flag,flag2;
	
		System.out.println("첫번째 수를 입력하세요.");
		flag = sc.hasNextInt();
		
		// 첫번째수가 정수일 경우..
		if (flag) {
			num1 = sc.nextInt();
			System.out.println("두번째 수를 입력하세요.");
			flag2 = sc.hasNextInt();
			
			// 두번째 수도 정수일 경우..
			if (flag2) {
				num2 = sc.nextInt();
				System.out.println(num1 - num2);
				return;
			}
			
			// 두번째 수가 정수가 아닐 경우.
			if (!flag2) {
				dnum2 = sc.nextDouble();
				System.out.println(num1 - dnum2);
				return;
			}

			return;
		}
		
		// 첫번째수가 정수가 아닐 경우..
		if (!flag) {
			dnum1 = sc.nextDouble();
			System.out.println("두번째 수를 입력하세요.");
			flag2 = sc.hasNextInt();
			
			// 두번째 수도 정수가 아닐 경우..
			if (!flag2) {
				dnum2 = sc.nextDouble();
				System.out.println(dnum1 - dnum2);
				return ;
			}
			
			// 두번째 수가 정수일 경우..
			if (flag2) {
				num2 = sc.nextInt();
				System.out.println(dnum1 - num2);
				return;
			}
			
			return;
		}
	}
	public void multiply() {
		Scanner sc = new Scanner(System.in);
		int num1,num2;
		double dnum1,dnum2;
		boolean flag,flag2;
	
		System.out.println("첫번째 수를 입력하세요.");
		flag = sc.hasNextInt();
		
		// 첫번째수가 정수일 경우..
		if (flag) {
			num1 = sc.nextInt();
			System.out.println("두번째 수를 입력하세요.");
			flag2 = sc.hasNextInt();
			
			// 두번째 수도 정수일 경우..
			if (flag2) {
				num2 = sc.nextInt();
				System.out.println(num1 * num2);
				return;
			}
			
			// 두번째 수가 정수가 아닐 경우.
			if (!flag2) {
				dnum2 = sc.nextDouble();
				System.out.println(num1 * dnum2);
				return;
			}

			return;
		}
		
		// 첫번째수가 정수가 아닐 경우..
		if (!flag) {
			dnum1 = sc.nextDouble();
			System.out.println("두번째 수를 입력하세요.");
			flag2 = sc.hasNextInt();
			
			// 두번째 수도 정수가 아닐 경우..
			if (!flag2) {
				dnum2 = sc.nextDouble();
				System.out.println(dnum1 * dnum2);
				return ;
			}
			
			// 두번째 수가 정수일 경우..
			if (flag2) {
				num2 = sc.nextInt();
				System.out.println(dnum1 * num2);
				return;
			}
			
			return;
		}
	}
	public void divide() {
		Scanner sc = new Scanner(System.in);
		int num1,num2;
		double dnum1,dnum2;
		boolean flag,flag2;
	
		System.out.println("첫번째 수를 입력하세요.");
		flag = sc.hasNextInt();
		
		// 첫번째수가 정수일 경우..
		if (flag) {
			num1 = sc.nextInt();
			System.out.println("두번째 수를 입력하세요.");
			flag2 = sc.hasNextInt();
			
			// 두번째 수도 정수일 경우..
			if (flag2) {
				num2 = sc.nextInt();
				double result = (double)num1 / num2;
				System.out.println(result);
				return;
			}
			
			// 두번째 수가 정수가 아닐 경우.
			if (!flag2) {
				dnum2 = sc.nextDouble();
				System.out.println(num1 / dnum2);
				return;
			}

			return;
		}
		
		// 첫번째수가 정수가 아닐 경우..
		if (!flag) {
			dnum1 = sc.nextDouble();
			System.out.println("두번째 수를 입력하세요.");
			flag2 = sc.hasNextInt();
			
			// 두번째 수도 정수가 아닐 경우..
			if (!flag2) {
				dnum2 = sc.nextDouble();
				System.out.println(dnum1 / dnum2);
				return ;
			}
			
			// 두번째 수가 정수일 경우..
			if (flag2) {
				num2 = sc.nextInt();
				System.out.println(dnum1 / num2);
				return;
			}
			
			return;
		}
	}
}
