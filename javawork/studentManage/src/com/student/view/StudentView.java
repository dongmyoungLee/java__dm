package com.student.view;

import java.util.Scanner;

public class StudentView {
	// student 를 관리하는 사용자에게 보여주는 화면..(html 에 관련된 것들 여기들어감)
	// 사용자에게 화면을 출력해주는 역할
	
	// 1. 메인화면을 출력해준다.	
	public void mainMenu() {
		// 프로그램이 시작되면 기능을 선택하게 하는 화면
		// mainMenu..
		
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("========== 학생관리 프로그램 v0.1 ==========");
			System.out.println("1. 학생등록");
			System.out.println("2. 학생수정");
			System.out.println("3. 학생삭제");
			System.out.println("4. 이름으로 조회");
			System.out.println("5. 전공으로 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("입력 : ");
		
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1 : 
					System.out.println("서비스 개발중..");
					break;
				case 2 : 
					System.out.println("서비스 개발중..");
					break;
				case 3 : 
					System.out.println("서비스 개발중..");
					break;
				case 4 : 
					System.out.println("서비스 개발중..");
					break;
				case 5 : 
					System.out.println("서비스 개발중..");
					break;
				case 0 : 
					System.out.println("학생 관리 프로그램을 종료..");
					return;
				default :
					System.out.println("잘못된 메뉴를 선택 하셨습니다. 다시 선택 해 주세요.");
					break;
			}
		} while(true);	
	}
	
	// 2. 시스템 메세지를 출력해준다.
	public void printMsg(String msg) {
		System.out.println("========== 시스템 메세지 \"==========");
		System.out.println("내용 : " + msg);
		System.out.println("==================================");
	}

	// 3. 입력화면을 출력해준다. (학생, 학생수정, 삭제 등)
	
}
