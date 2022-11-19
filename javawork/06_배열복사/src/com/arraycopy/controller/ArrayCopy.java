package com.arraycopy.controller;

import java.util.Arrays;

public class ArrayCopy {
	public void arrayCopy() {
		// 얕은복사 - 생성된 배열의 주소만 복사해서 활용하는것. 원본을 수정..
		// -> 데이터가 저장된 영역을 같이 공유해서 사용하기 때문에 변수값을 따로 바꾸지 않아도 바뀔 수 있음..
		
		int[] intArr = {1,2,3,14,5};
//		int[] copyArr = intArr;

 		// 깊은복사 - 새로운 배열을 생성해서 배열에 저장된 데이터를 복사 사본 수정..
		
		// # 1.  for문을 이용해서 직접 데이터를 복사 해 주는 방법..
		
		int[] deepCopyArr = new int[intArr.length];
		
		for(int i = 0; i < intArr.length; i++) {
			deepCopyArr[i] = intArr[i];
		}
		
		// # 2. Arrays 클래스가 제공하는 method 사용하기
		// copyOf()
		
		//deepCopyArr = Arrays.copyOf(intArr, 2);
		//System.out.println(Arrays.toString(deepCopyArr));
		
		// # 3. 배열명.clone();
		
		deepCopyArr = intArr.clone();
		
		//System.out.println(Arrays.toString(deepCopyArr));
		
		
		// # 2차원 배열..
		int[][] intArr2 = new int[4][4];
		int count = 0;
		for(int i = 0; i < intArr2.length; i++) {
			for(int j = 0; j < intArr2.length; j++) {
				intArr2[i][j] = ++count;
				System.out.print(intArr2[i][j]);
			}
			System.out.println();
		}
		
		
		// 2차원 배열 선언과 동시에 초기화
		// 2차원 배열 순회하기
		String[] names = {"유병승1", "유병승2", "유병승3", "유병승4", "유병승5"};
		String[][] names2 = {{"유병승9","유병승8","유병승7","유병승6",},{"유병승3","유병승4","유병승5",}};
//		
//		for(int i = 0; i < names2.length; i++) {
//			for(int j = 0; j < names2[i].length; j++) {
//				System.out.print(names2[i][j]+ " ");
//			}
//			System.out.println();
//		}
		
		// names2의 저장소에 유병승6 이 저장된 위치를 출력하는 기능
		for(int i = 0; i < names2.length; i++) {
			for(int j = 0; j < names2[i].length; j++) {
				if (names2[i][j].equals("유병승6")) {
					System.out.println("유병승6 은 " + (i+1) + "번째 줄 " + j + "번째에 있다.");
					return ;
				}
			}
		}
		
	}
	
	public void forEachTest() {
		// 배열, 리스트, Set, Map 자료형을 쉽게 순회하는 반복문.
		// forEach문 : 데이터 전체를 숞뇌하여 값을 찾거나 출력할 때
		
		int[] numbers = {10,20,30,40,50,60};
		
//		for (int el : numbers) {
//			System.out.println(el);
//		}
		
		// 2차원배열로 for문돌리기..
		String[][] names2 = {{"유병승9","유병승8","유병승7","유병승6",},{"유병승3","유병승4","유병승5",}};
		
//		for (String[] el : names2) {
//			for(String el2 : el) {
//				System.out.println(el2);
//			}
//		}
		
		// lotto 만들기
		int [] lotto = new int[6];
		
		for(int i = 0; i < lotto.length; i++) {
			int value = (int)(Math.random()*45)+1;
			for(int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					// 중복값이 있음..
					i--;
					break;
				}
			}
			lotto[i] = value;
		}
		
		for(int el : lotto) {
			System.out.println(el);
		}
		
		
		
	}
}
