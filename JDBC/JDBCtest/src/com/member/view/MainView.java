package com.member.view;

import java.util.List;
import java.util.Scanner;

import com.member.controller.MemberController;
import com.member.model.vo.Member;

public class MainView {
	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("===== jdbc 회원관리 프로그램 =====");
			System.out.println("1. 전체 회원조회");
			System.out.println("2. 아이디로 회원조회");
			System.out.println("3. 이름으로 회원조회");
			System.out.println("4. 회원 등록");
			System.out.println("5. 회원 수정 (이름, 나이, 이메일, 주소)");
			System.out.println("6. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.println("선택 : ");
			
			switch(sc.nextInt()) {
				case 1 :
					new MemberController().searchAll();
				break;
				case 2 :
					new MemberController().searchId();
				break;
				case 3 :
					new MemberController().searchName();
				break;
				case 4 :
					new MemberController().insertMember();
				break;
				case 5 :
					new MemberController().updateMember();
				break;
				case 6 :
					new MemberController().deleteMember();
				break;
				
				case 0 :
					System.out.println("프로그램을 종료 합니다.");
					return ;
			}
		}
	}
	
	public void printMembers(List<Member> members) {
		System.out.println("===== 회원조회결과 =====");
		members.stream().forEach(e -> System.out.println(e));
		System.out.println("=====================");
	}
	
	public String searchData(String title) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=====" + title + "조회 =====");
		System.out.println("입력 : ");
		
		return sc.nextLine();
	}
	
	public Member inputMember() {
		System.out.println("===== 회원등록 =====");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이디 : ");
		String memberId = sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String memberPwd = sc.nextLine();
		
		System.out.println("이름 : ");
		String memberName = sc.nextLine();
		
		System.out.println("성별 : ");
		String memberGender = sc.nextLine();
		
		System.out.println("나이 : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("이메일 : ");
		String memberEmail = sc.nextLine();
		
		System.out.println("연락처 : ");
		String memberPhone = sc.nextLine();
		
		System.out.println("주소 : ");
		String memberAddr = sc.nextLine();
		
		System.out.println("취미 : ");
		String memberHobby = sc.nextLine();
		
		return new Member(memberId, memberPwd, memberName, memberGender, age, memberEmail, memberPhone, memberAddr, memberHobby.split(","), null);
	}
	
	public void printMsg(String msg) {
		System.out.println("===== 시스템 메세지 ======");
		System.out.println(msg);
		System.out.println("======================");
	}
	
	public String deleteMember(String id) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===== 회원 삭제 =====");
		System.out.println("삭제할 "+ id +" 입력 : ");
		
		return sc.nextLine();
	}
	
}
