package com.obj.model.vo;

public class NewStudent {
	public String name;
	public int age;
	public String gender;
	public String phone;
	
	// 기본 생성자 선언..
//	public NewStudent() { 
//		System.out.println("기본 생성자 호출");
//	}
	
	// 매개변수 있는 생성자 선언하기 ..
	// 호출하는 곳 에서 보내주는 데이터를 필드에 저장하는 기능
	public NewStudent(String userName, int userAge, String userGender, String userPhone) {
		System.out.println("매개변수 존재하는 생성자");
		System.out.println(userName + " " + userAge + " " + userGender + " " + userPhone);
		
		// 변수 초기화..
		name = userName;
		age = userAge;
		gender = userGender;
		phone = userPhone;
	}

	
//	public void NewStudentInfo() {
//		System.out.println(name + " " + age + " " + gender + " " + phone);
//	}
}
