package com.loop.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Random;

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
	
	public void forTest() {
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
		/*
		System.out.println("수를 입력하세요, (5,10,100) ");
		int num = sc.nextInt();
		
		switch(num) {
			case 5 :
				for(int i = 1; i <= num; i++) {
					System.out.println(i);
				}
			break;
			case 10 :
				for(int i = 1; i <= num; i++) {
					System.out.println(i);
				}
			break;
			case 100 :
				for(int i = 1; i <= num; i++) {
					System.out.println(i);
				}
			break;
			default : System.out.println("5,10,100 중에서만 입력");
			break;
		}
		*/
		
		String msg = "일요일날도 열심히 해봅시다!";
		/*
		for(int i = 0; i < msg.length(); i++) {
			
			System.out.println(msg.charAt(i));
			
			if (msg.charAt(i) == ' ') {
				System.out.println(i + " 번째는 공백");
			}
		
		}*/
		
		
		
		
	}
	
	public void doubleFor() {
		// 중첩 반복문.
		
//		for (int i = 2; i < 10; i++) {
//			for (int j = 1; j < 10; j++) {
//				System.out.println(i+"*"+j+"="+(i*j));
//			}
//		}
		/*
		String msg = "apple";
		
		for (int i = 0; i < msg.length(); i++) {
			char ch = msg.charAt(i);
			
			for(int j = 0; j < msg.length(); j++) {
				System.out.print(msg.charAt(i) + " " + msg.charAt(j));
			}
		}
		*/
		char star = '*';
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < (i+1); j++) {
				System.out.print(star);
				
			}
			
			System.out.println();
		}
		
		for(int i = 4; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				System.out.print(star);
			}
			
			System.out.println();
		}
		
	}
	
	public void whileTest() {
		Scanner sc = new Scanner(System.in);
		
		int choice = 100;
		
		while(choice != 0) {
			System.out.println("메뉴골라 (1,2,3,4,5)");
			
			choice = sc.nextInt();
		}
	}
	
	public void calculator() {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int num = 0;
		int num2 = 0;
		String yn = " ";
		while(flag) {
			System.out.println("첫번째 수 ");
			num = sc.nextInt();
			System.out.println("두번째 수 ");
			num2 = sc.nextInt();
			
			System.out.println("결과 : "+ (num + num2));
			System.out.println("계속 하시겠습니까 ? (y,n)");
			yn = sc.next();
			
			if (yn.equals("n")) {
				flag = false;
			}

		}
		


	}
	
	public void doWhileTest() {
		Scanner sc = new Scanner(System.in);
		// break 현재 실행되고 있는 반복문을 중단.
		// continue continue 아래라인에 있는 코드를 생략하고 반복문을 실행함 .
		// break continue 는 특정조건을 만들어서 활용을 한다 .
		int count = 0;
		/*
		target:
		for (int i = 0; i<10; i++) {
			System.out.println(i);
			for (int j=0; j < 5; j++) {
				System.out.print(j + " ");
				if(j == 2) {
					break target;
				}
			}
			System.out.println();
		}
		*/
		
		/*
		String str = "pajw";
		int count1 = 0;
		
		t:
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (i != j && str.charAt(i) == str.charAt(j)) {
					count1++;
					break t;
				}
			}
		}
		
		
		System.out.println(count1 > 0 ? "중복" : "중복아님");
		*/
		
		// continue 를 이용한 홀수 출력
//		for(int i = 0; i < 100; i++) {
//			if (i % 2 == 0) {
//				continue;
//			}
//			System.out.println(i);
//		}
		
		// java 랜덤값호출
		
		Random rnd = new Random();
		
		// 0 ~ 9
		System.out.println(rnd.nextInt(10));
		
		
	}
}
