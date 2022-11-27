package com.Inherit.controller;

import com.Inherit.model.vo.Cat;
import com.Inherit.model.vo.Dog;
import com.Inherit.model.vo.Employee;
import com.Inherit.model.vo.Hamster;
import com.Inherit.model.vo.Student;
import com.Inherit.model.vo.Teacher;

public class InheritController {
	
	public void basicInherit() {
		// 기본 상속..
		// 1. java 에서 사용하는 모든 클래스는 Object 클래스를 상속 받고 있다.
		
		// 클래스에 상속관계 설정하기
		// 두개의 클래스간에 부모(super), 자식(sub) 관계를 설정하는 것을 말 한다.
		// 선언방법 : 클래스 선언부에 extends 예약어 사용
		// public class Test(클래스명) extends 상속할 클래스명(부모클래스) { 구현 }
		
		
		Student s1 = new Student();
		Employee e1 = new Employee();
		Teacher t1 = new Teacher(); 
		
		// 상속..
		s1.setName("학생");
		e1.setName("직원");
		t1.setName("선생");
		
		s1 = new Student("김태훈", 25, '남', "경기도", 1, 2, 3);
		System.out.println(s1.infoStudent());
		
		
	}
	
	public void overrideTest() {
		// 오버라이드.. 재정의하다.. -> 상속관계에 있을 때 자식 클래스에서 부모 클래스에서 정의되어있는 메소드를 커스터마이징 한다..
		// 부모선언부에서 선언한대로 선언해야한다. 구현부의 내용만 변경되는거임..
		// @Override 어노테이션을 사용한다.. 안써도 적용되는것에는 문제가 없지만 왠만해선 사용해주는게 좋다.
		// 지금 선언한 메소드가 override 인지를 인지 시키는 것임..
		
		// 오버라이딩 : 재정의 -> 메소드 선언부를 동일하게 사용
		// 오버로딩 : 이름만 동일하게 쓰는 다른 메소드 구현 -> 메소드 명만 동일하고 매개변수는 다르게
		
		System.out.println("오버라이드 테스트");
		
		Cat cat = new Cat("고양이", "나비", 8, '여');
		Dog dog = new Dog("강아지", "달콤이", 10, '여');
		Hamster hamster = new Hamster("햄스타", "햄톨이", 5, '남');
		
		//System.out.println(cat.bark());
		//System.out.println(dog.bark());
		//System.out.println(hamster.bark());

		// Object 클래스의 메소드를 재정의해서 사용..
		// 1. equals() : 클래스의 동등성을 비교하기 위해서 재정의 해야하는 메소드
		// 2. hashcode() : 생성된 객체의 주소를 의미하는 hash값 (유일한 값)을 출력 int 형
		// 3. toString() : 생성된 객체를 표현할 수 있는 대표 문자열을 출력하는 메소드
		// 4. clone() : 생성된 객체를 깊은복사 할 때 사용하는 메소드
		
		Student s1 = new Student("유병승", 19, '남', "경기도 시흥시", 1,2,3);
		Student s2 = new Student("유병승", 19, '남', "경기도 시흥시", 1,2,3);
		
		System.out.println(s1.equals(s2));
		
		// Object 의 toString 이 실행..(현재는 override 했음)
		System.out.println(s1);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}
}
