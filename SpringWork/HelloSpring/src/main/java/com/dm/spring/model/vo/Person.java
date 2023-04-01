package com.dm.spring.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/* @NoArgsConstructor */
public class Person {
	private String name;
	private int age;
	private double height;
	private Phone phone;
	
	{
		System.out.println("초기화블록실행");
	}
	
	public Person() {
		// TODO Auto-generated constructor stub
		System.out.println("Person 기본 생성자 호출");
	}
	
	public void infoPerson() {
		System.out.println(this.name + " " + this.age + " " + this.height + this.phone);
	}
}
