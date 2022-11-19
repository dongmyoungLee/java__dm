package com.controller.run;

import com.obj.model.vo.NewStudent;

public class ConstructorMain {

	public static void main(String[] args) {
		// 생성자 활용하기
		// 생성자는 클래스를 생성할때 이용하는 기능으로 클래스가 가지고 있는 변수공간(field)에 데이터를 특정데이터를 대입할때 사용
		
		// # 1. 기본 생성자 기본 값으로 클래스를 생성하는 것 -> 클래스 내부에 생성자를 선언하지 않으면 자동으로 만들어줌..
		// # 2. 매개변수 있는 생성자 클래스를 생성하는 곳에서 보내준 데이터로 필드를 초기화하여 생성해주는 것.
		
		NewStudent lee = new NewStudent("이동명", 17, "male", "010-123-4568");
		

//		lee.name = "이동명";
//		lee.age = 18;
//		lee.gender = "male";
//		lee.phone = "010-1234-5678";
//		
//		lee.NewStudentInfo();
		
	}

}
