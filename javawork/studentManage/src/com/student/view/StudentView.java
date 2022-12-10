package com.student.view;

import java.util.Scanner;

import com.student.controller.StudentController;
import com.student.model.vo.Student;

public class StudentView {
	
	// 객체 싱글톤..
	private static StudentView view;
	private StudentView() {};
	public static StudentView getView() {
		if (view == null) {
			view = new StudentView();
		}
		return view;
	}
	
	// student 를 관리하는 사용자에게 보여주는 화면..(html 에 관련된 것들 여기들어감)
	// 사용자에게 화면을 출력해주는 역할
	
	// 1. 메인화면을 출력해준다.	
	public void mainMenu() {
		// 프로그램이 시작되면 기능을 선택하게 하는 화면
		// mainMenu..
		
		Scanner sc = new Scanner(System.in);
		StudentController controller = StudentController.getController();
		
		do {
			System.out.println("========== 학생관리 프로그램 v0.5 ==========");
			System.out.println("1. 학생등록");
			System.out.println("2. 학생수정");
			System.out.println("3. 학생삭제");
			System.out.println("4. 전체조회");			
			System.out.println("5. 이름으로 조회");
			System.out.println("6. 전공으로 조회");
			System.out.println("0. 프로그램 종료");
			System.out.print("입력 : ");
		
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1 : 
					controller.insertStudent();
					break;
				case 2 : 
					controller.modifyStudent();
					break;
				case 3 : 
					controller.deleteStudent();
					break;
				case 4 : 
					controller.searchAll();
					break;
				case 5 : 
					controller.searchName();
					break;
				case 6 : 
					controller.searchMajor();
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
		System.out.println("********** 메세지 **********");
		System.out.println("내용 : " + msg);
		System.out.println("**************************");
	}
	

	// 3. 입력화면을 출력해준다. (학생등록, 학생수정, 삭제 등)
	// flag - 1 : 신규등록, 2 : 기존 회원 수정
	public Student inputStudentView(int flag) {
		Scanner sc = new Scanner(System.in);
		int flagResult = 0;
		
		
		// default 생성자로 생성함.. 아무것도 없음.
		Student student = new Student();
		
		switch(flag) {
			case 1 :
				System.out.println("========== 학생 등록 ==========");
				break;
			case 2 :
				System.out.println("========== 수정할 학생의 정보를 입력 해 주세요. ==========");
			break;
		}
		
		System.out.print("이름 : ");
		student.setName(sc.nextLine());
		
		System.out.print("나이 : ");
		student.setAge(sc.nextInt());
		
		System.out.print("성별 : ");
		student.setGender(sc.next().charAt(0));
		
		sc.nextLine();
		
		System.out.print("주소 : ");
		student.setAddress(sc.nextLine());
		
		System.out.print("전화번호 : ");
		student.setPhone(sc.nextLine());
		
		System.out.print("이메일 : ");
		student.setEmail(sc.nextLine());
		
		System.out.print("전공 : ");
		student.setMajor(sc.nextLine());
		

		return student;		
		
	}

	public void printStudent(String data) {
		System.out.println("========== 조회한 학생정보 ==========");
		
		if(data.length() > 0) {
			System.out.println(data);
		} else {
			System.out.println("조회된 결과가 없습니다.");
		}
		
		System.out.println("================================");
	}
	
	public String inputName() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("========== 이름으로 학생 조회 ==========");
		System.out.print("검색할 이름은 ? : ");
		
		return sc.nextLine();
	}
	
	public String inputMajor() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("========== 전공으로 학생 조회 ==========");
		System.out.print("검색할 전공은 ? : ");
		
		return sc.nextLine();
	}
	
	public String inputModName(String gb) {
		Scanner sc = new Scanner(System.in);
		String gbMsg = "";
		
		switch(gb) {
			case "mod" :
				gbMsg = "수정";
			break;
			case "del" :
				gbMsg = "삭제";
			break;
		}
		
		
		System.out.println("==========" + gbMsg +  "할 학생 이름 입력 ==========");
		System.out.print(gbMsg + "할 학생 이름은 ? ");
		
		return sc.next();
	}
	
	
}
