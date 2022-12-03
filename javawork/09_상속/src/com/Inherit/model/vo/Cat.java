package com.Inherit.model.vo;

public class Cat extends Animal {
	
	public Cat() {
		// TODO Auto-generated constructor stub
	}
	
	public Cat(String type, String name, int age, char gender) {
		super(type, name, age, gender);
	}
	
	// 부모에 정의되어 있는 메소드를 재정의 함.
	@Override
	public void bark() {
		System.out.println("야옹");
	}
}
