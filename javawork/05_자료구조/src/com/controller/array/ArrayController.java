package com.controller.array;

public class ArrayController {
	public void arrayTest() {
		// 배열은 기본으로 제공되는 저장공간으로 생성(new)을 해서 사용한다.
		// 저장되는 저장공간은 선형구조로 되어있음.
		// 배열 선언 방법
		
		/*
		int[] arr = {1,2,3,4,5};
		int[] arr2 = new int[] {1,2,3,4};
		char[] str = new char[3];
		
		
		
		*/
		
		int[] intArr;
		intArr = new int[5];
		
		
		// [I@2d8f65a4 -> stack 의 주소값
		//System.out.println(intArr);
		
		
		// 수강생 5명 이름을 저장할 수 있는 배열을 만들고 각 배열저장공간에 이름을 저장하기
		String[] strArr;
		strArr = new String[] {"A", "B", "C", "D", "E"};
		
		for (String el : strArr) {
			System.out.println(el);
		}
		
		
	}
}
