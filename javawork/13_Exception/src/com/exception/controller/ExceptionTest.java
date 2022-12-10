package com.exception.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ExceptionTest {
	
	public void uncheckedException() {
		// 발생 가능성이 있는 예외에 대해 처리구문을 작성하지 않아도 되는 예외 (Exception)
		
		// ArithmeticException : 수학적으로 계산이 불가능할때 발생..
		int su = 10;
		int su2 = 0;
		
		// ArithmeticException !
		//System.out.println(su / su2);
		
		// ArrayIndexOutOfBoundsException : 할당된 배열의 인덱스번호를 넘어서 지정했을 때 발생..
		int[] intArr = new int[3];
		
		// ArrayIndexOutOfBoundsException !
		//System.out.println(intArr[3]);
		
		
		// ClassCastException : 클래스를 잘못 형변환 했을 때 발생..
		Object o = "유병승";
		// ClassCastException !
		//Integer i = (Integer)o;
		
		// NumberFormatException : 숫자로 변환되지 않는 문자열을 변환했을 때 발생..
		String str = "십";
		// NumberFormatException !
		//su = Integer.parseInt(str);
		
		// NullPointException : 참조형 변수에 null 이 있는 상태에서 접근연산자를 사용했을 때 발생..
		str = null;
		
		// NullPointException !
		//str.length();
	}
	
	public void checkedException() {
		// 발생하는 예외처리
		// 1. try & catch
		// 2. throw 예약어 : 예외처리구문을 호출하는곳에 위임한다.
		// 여러개의 catch 사용 가능
		
		int[] intArr = {1,2,3,4,5};
		
		
		try {
			intArr[5] = 100;
		} catch(ArrayIndexOutOfBoundsException e) {
			int[] temp = new int[intArr.length+1];
			for(int i = 0; i < intArr.length; i++) {
				temp[i] = intArr[i];
			}
			intArr = temp;
			intArr[5] = 100;
		}
			
		System.out.println(Arrays.toString(intArr));
		
		
		// exception 2개 발생
		try {
			String[] strs = null;
			String temp = strs[0];
			String strTemp = "하하";
			Object o = strTemp;
			int intTemp = (Integer)o;
		} catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		// 예외클래스도 상속관계가 있음. -> 모든 예외클래스는 Exception 클래스를 상속 받는다.
		/// 부모 Exception 은 자식 Exception을 처리할 수 있음. 모든 예외를 다 처리할 수 있음
		
		
		// 2. throw 예약어를 이용해서 처리..
		// throw 예외 클래스를 생성!
		//throw new IllegalArgumentException("잘못된 인수전달됨")
		// throw 로 예외를 발생하면 checkedException 은 반드시 처리해줘야한다.
		
		//throw new IllegalArgumentException("잘못된 인수");
		
		
			
	}
	
	public int divided(int su, int su2) {
		if (su == 0 || su2 == 00) {
			throw new IllegalArgumentException("매개변수에 0은 넣을 수 없습니다.");
		}
		return su / su2;
	}
	
	public void checkedExceptionCase() {
		//IOException 클래스 자식 클래스들..
		
		/*
		try {
			throw new IOException("checkException");
		} catch(IOException e) {
			// 에러가 발생한 위치를 알려준다
			e.printStackTrace();
		}
		*/
		
		// IO 관련된 메소드를 호출할 때 발생!
		/*
		try {
			FileReader fr = new FileReader("ㅅㄷㄴㅅ.ㅅㄷㄴㅅ");
			fr.read();
		}	catch(FileNotFoundException e) {
			e.printStackTrace();
		}	catch(IOException e) {
			e.printStackTrace();
		}
		*/
		
		try {
			checkedThrowTest();
		} catch(FileNotFoundException e) {
			
		}
		
	
		
	}
	
	// throws 로 예외처리 하기
	public void checkedThrowTest() throws FileNotFoundException {
		FileReader fr = new FileReader("test.txt");
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
