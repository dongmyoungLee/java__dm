package com.control.controller;

import java.util.Scanner;

public class ConditionController {
	public void condintion_01() {
		String id = "a";
		String pass = "123";
		int age;
		int num;
		Scanner sc = new Scanner(System.in);
		
		
//		System.out.println("니 이름 : ");
//		name = sc.next();
//		
//		if (name.equals("이동명")) {
//			System.out.println("good");
//			return ;
//		}
		
//		System.out.println("나이 :");
//		age = sc.nextInt();
//		if (age > 19 && age < 30) {
//			System.out.println("취업하자.");
//			return ;
//		}
//		
//		System.out.println("돈많이벌자");
		
//		System.out.println("숫자 : ");
//		
//		num = sc.nextInt();
//		
//		if (num % 5 == 0) {
//			System.out.println("5의배수에요");
//			return ;
//		}
//		
//		System.out.println("5의 배수가 아니네요");
//		
		System.out.println("ID : ");
		id = sc.next();
		System.out.println("Pass : ");
		pass = sc.next();
		
		if (id.equals("a") && pass.equals("123")) {
			System.out.println("로그인 성공");
			return ;
		}
		
		System.out.println("로그인 실패");
		
		
		
	}
}
