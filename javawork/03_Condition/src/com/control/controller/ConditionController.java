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

//		System.out.println("ID : ");
//		id = sc.next();
//		System.out.println("Pass : ");
//		pass = sc.next();
//		
//		if (!(id.equals("a") && pass.equals("123"))) {
//			System.out.println("로그인 실패");
//			return ;
//		}
//		
//		System.out.println("로그인 성공");
		
	/*	
		System.out.println("나이를 입력하세요 : ");
		int age2 = sc.nextInt();
		
		if (age2 > 19) {
			System.out.println("성인은 가입이 불가능 합니다.");
			return ;
		} 
		
		System.out.println("회원가입할 아이디 : ");
		String id2 = sc.next();
		System.out.println("회원가입할 비밀번호 : ");
		String pass2 = sc.next();
		System.out.println("회원가입할 이름 : ");
		String name = sc.next();
		System.out.println("회원가입할 별명 : ");
		String nick = sc.next();
		System.out.println("회원가입할 나이 : ");
		int age3 = sc.nextInt();
		System.out.println("회원가입할 키 : ");
		double height = sc.nextDouble();
		
		System.out.println("아이디를 입력하세요 :");
		String validId = sc.next();
		System.out.println("비밀번호를 입력하세요 : ");
		String validPass = sc.next();
		
		if (!(id2.equals(validId) && pass.equals(validPass))) {
			System.out.println("회원정보가 달라요.");
			return;
		}
		
		System.out.println(name + "님 안녕하세요 ? " + nick + "님 이고 " + age3 + " 살의 키가 " + height + "이군요 ?" );
		
		*/
		
		
	}
	
	public void switchTest() {
		
		Scanner sc = new Scanner(System.in);

		// String형으로 이욯하기
		/*
		System.out.println("메뉴 고르세요 : ");
		
		
		int menu = sc.nextInt();
		
		switch(menu) {
			case 1 : System.out.println("떡볶이 3000");
			break;
			case 2 : System.out.println("순대 30000");
			break;
			case 3 : System.out.println("튀김 4000");
			break;
			case 4 : System.out.println("피카추 55000");
			break;
			default : System.out.println("선택 중에서만 적으세요");
		}
		*/
		
		// 의도적 break 생략..
		int month = 4;
		
		switch(month) {
			case 1 :
			case 2 :
			case 12 :
				System.out.println("tttt");
			break;
			case 3:
			case 4:
			case 5:
				System.out.println("qqqq");
			break;
		}
		
		
		
	}
}
