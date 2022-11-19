package com.controller.array;

import java.util.Arrays;

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
		/*
		for (String el : strArr) {
			System.out.println(el);
		}
		*/
		
		
		
		double [] dbArr;
		dbArr = new double[5];
		
		/*
		for(int i = 0; i < dbArr.length; i++) {
			System.out.println((i+1) + " 번째 키를 입력하세요.");
			dbArr[i] = sc.nextDouble();
		}
		
		for(double el : dbArr) {
			System.out.println(el);
		}
		*/
		int count = 0;
		double [] height;
		height = new double[] {180.5, 180.1, 172.1, 170.1};
		
		/*
		for(double el : height) {
			if (el > 180.0) {
				continue;
			}
			count++;
		}
		
		System.out.println("180 이상인 사람은 " + count + " 명 입니다.");
		*/
		
		// length 에 괄호가 없어야 함.
		
		int[] numArr =  new int[10];
		
		for(int i = 0; i < numArr.length; i++) {
			numArr[i] = (int)(Math.random()*100)+1;
		}
		
		int max = numArr[0];
		int min = numArr[0];
		
		/*
		for(int i = 0; i < numArr.length; i++) {
			if (max < numArr[i]) {
				max = numArr[i];
			}
			
			if(min > numArr[i]) {
				min = numArr[i];
			}
		}
		*/
		
		/*
		System.out.println(max);
		System.out.println(min);
		System.out.println(Arrays.toString(numArr));
		*/
		
		// 배열정렬
		int[] newArr = new int[] {1,3,4,65,6,3,3,2};
		
		for (int i = 0; i < newArr.length; i++) {
			
			
			for (int j = 0; j < i; j++) {
				if (newArr[i] < newArr[j]) {
					int tmp = newArr[i];	
					newArr[i] = newArr[j];
					newArr[j] = tmp;
				}
			}
			
		}
		
		
		System.out.println(Arrays.toString(newArr));
		
		
	}
	
	public void student() {
		String[] name = {"이동명", "박세현", "윤주", "김태훈", "김수진", "오윤재", "박보검", "박세리"};
		char[] alpha = {'a', 'b', 'c', 'A', 'B', 'C', 'Z', 'q', 'x', 'y'};
		
		int lCoint = 0;
		int SCount = 0;
		
		for(String el : name) {
			if (el.charAt(0) != '박') {	
				continue;
			}
			System.out.print(el + " ");
		}
		System.out.println();
		for(char el : alpha) {
			if (el >= 'A' && el <= 'Z') {
				lCoint++;
			} else {
				SCount++;
			}
		}
		
		System.out.println("대문자 " + lCoint + "개 " + "소문자 " + SCount + "개 ");
		
	}
}
