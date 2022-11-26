package com.controller.run;

import com.obj.model.vo.Animal;
import com.obj.model.vo.NewStudent;

// 1. 데이터 보관용 클래스
// 2. 기능을 제공하는 클래스

public class MethodsTest {
	
	// 메소드는 클래스가 제공하는 기능
	// 메소드를 이용하려면 클래스를 반드시 생성하고 이용을 해야한다. * static 예약어를 설정하지 않은 메소드
	// 클래스 내부에 static 예약어 없이 선언된 메소드를 멤버메소드로 지칭한다.
	// 메소드를 선언하는 방법
	// 접근제한자 반환형 메소드명([매개변수]){ 로직 } 형식으로 사용됨
 	
	// 1. 반환형이 없고 매개변수도 없음.
	public void printMsg() {
		//System.out.println("프린트");
	}
	
	// return 에 type형을 맞춰줘야 함
	public int plus() {
		return 10 + 20;
	}
	
	public void sendMsg(String msg) {
		//System.out.println(msg);
	}
	
	// 숫자를 1~5까지 더한수를 반환하는 메소드 만들기
	public int numAccumulation() {
		int result = 0;

		for (int i = 0; i < 5; i++) {
			result += i;
		}
		
		return result;
	}
	
	// 두개의 문자열을 전달받아 합쳐서 출력하는 메소드 만들기
	public void numSend(int num1, int num2) {
		int result = 0;
		
		result = num1 + num2;
		
		System.out.println(result);
		
	}
	
	// 문자열을 전달받아 문자열에 중복이 있는지 여부를 반환해주는 메소드 만들기
	public void redundantData(String data) {
		boolean result = false;
		
		for (int i = 0; i < data.length(); i++) {
			
			for (int j = 0; j < data.length(); j++) {
				//System.out.print(data.charAt(i) + " ");
				//System.out.print(data.charAt(j));
				if (i != j && data.charAt(i) == data.charAt(j)) {
					
				}
			}
		}
		
		//System.out.println(result);
	}
	
	// 세개문자를 입력받고 합쳐서 출력하는 메소드 만들기
	
	
	// 매개변수로 배열, 클래스 선언하기
	public void paramArr(int[] numbers) {
		for (int n : numbers) {
			//System.out.println(n);
		}
	}
	
	public void paramObj(Animal a) {
		//System.out.println(a.name + " " + a.age + " " + a.type + " " + a.gender);
	}
	
	// 매개변수로 받은 데이터 수정하기
	// 기본자료형을 배개변수로 받았을 때 데이터 수정 -> 
	public void updateNumber(int number) {
		number += 100;
	}
	
	// 참조자료형을(배열,클래스)를 매개변수로 받았을 때 데이터 수정 ->
	public void updateArr(int [] intArr) {
		intArr[0] = 158;
	}
	
	public void updatePerson(Animal a) {
		a.name = "하하하";
		a.age = 16;
	}
	
	// void 형도 return 사용가능.
	public void testReturn(String msg) {
		if (msg.length() < 2) {
			return;
		}
		System.out.println(msg);
	}
	
	// 메소드 선언시 static 예악어를 사용할 수 있다.
	public static void sendMsgStatic(String msg) {
		System.out.println(msg);
	}
	
	public static String test1(int su) {
		return "입력 값 : " + su;
	}
	
	
		
}
