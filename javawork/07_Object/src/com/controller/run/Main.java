package com.controller.run;

import com.obj.model.vo.Student;
import com.object.controller.FieldTest;
import com.object.controller.ObjectController;

public class Main {

	public static void main(String[] args) {
		// 클래스는 생성을 해야지 이용을 할 수 있다.
		// 클래스는 기본 코드 생성할 규칙을 정의한 코드 자체 -> 생성 해야지 활용이 가능함..
		// 선언된 클래스를 생성하는 방법 : new 연산자를 이용
		// new 클래스명(); 
		
		new ObjectController();
		// 클래스는 하나의 타입으로 활용이 되기 때문에 생성된 클래스는 변수로 저장할 수 있음.
		ObjectController oc = new ObjectController();
		// 클래스는 new 연산자를 사용할때 마다 새로운 객체를 생성해서 반환.. 위에 new연산해서 만든거랑 주소값이 다름.
		
		
		
		// FieldTest 클래스에 선언된 필드 이용하기.. ( ctrl +  shift + o ) import 단축어.. 클래스명은 하나의 type이 될 수 있음.
		FieldTest ft = new FieldTest();
		ft.age = -100;
		ft.testP();
		
		FieldTest ft2 = new FieldTest();
		
		
		//System.out.println(ft.age);
		//System.out.println(ft2.age);
		// 배열초기화를 해주지 않으면 쓸 수 없어
		
		//System.out.println(ft.weight);
		//System.out.println(ft.HEIGHT);
		
		// static 필드에 접근하기..
		// 클래스를 생성하지 않고 접근이 가능함 ..
		// 클래스명.static 필드변수명
		// System.out.println(FieldTest.count);
	
		Student lee = new Student();
		lee.name = "이병승";
		lee.age = 17;
		lee.grade = 1;
		lee.classNum = 2;
		lee.height = 180.5;
		lee.address = "경기도 시흥시";
		
		Student kim = new Student();
		kim.name = "김병승";
		kim.age = 11;
		kim.grade = 3;
		kim.classNum = 4;
		kim.height = 150.5;
		kim.address = "경기도 수원시";
		
		Student hong = new Student();
		
		// 초기화 블록 : 클래스가 생성될 때(new) 실행 할 내용이 있다면 선언하는 기능.
 		
		// 1. 인스턴스 초기화 블록
		// - 클래스를 생성할 때 마다 실행됨.
		// - 생성한 클래스의 수를 계산하거나, 특정필드의 임의의 값을 부여할때 사용한다.
		
		
		
		// 2. static 초기화 블록
		// - 클래스를 생성할 때 최초 한번만 실행된다.
		// - static 변수를 초기화해줄 때 사용함.
		
		
		
		lee.studentInfo();
		kim.studentInfo();
		hong.studentInfo();
		
		
	}

}
