package com.Inherit.model.vo;

public class Dog extends Animal {
	public Dog() {
		// TODO Auto-generated constructor stub
	}
	
	public Dog(String type, String name, int age, char gender) {
		super(type, name, age, gender);
	}
	
	// 부모에 정의되어 있는 메소드를 재정의 함.
	@Override
	public String bark() {
		return "멍멍";
	}
}
