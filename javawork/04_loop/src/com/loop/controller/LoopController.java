package com.loop.controller;

import java.util.Scanner;

public class LoopController {
	public void loopControll() {
		Scanner sc = new Scanner(System.in);
		
//		for(int i = 0; i <= 60; i++) {
//			System.out.println("오늘의 마지막 시간이네요  " + i + " 번째");
//		}
		
//		for(int i = 1; i < 11; i++) {
//			if (i % 2 == 0) {
//				System.out.print(i+" ");
//			}
//		}
		
		// 외부에서 선언 한 변수는 초기화를 해줘야 for 문 안에서 접근 할 수 있음..
		int result=0;
		
		for (int i = 1; i < 4; i++) {
			System.out.println(i + "번째 숫자 입력");
			int num = sc.nextInt();
			result += num;
		}
		System.out.println(result);
		
		
	};
}
