package com.Inherit.model.vo;

public class Dog extends Animal {
	public Dog() {
		// TODO Auto-generated constructor stub
	}
	
	public Dog(String type, String name, int age, char gender) {
		super(type, name, age, gender);
	}
	
	// 부모에 정의되어 있는 메소드를 재정의 함.
	// 부모에서 선언되어있는 메소드보다 더 넓은 접근제한자 범위로 수정은 가능.
	@Override
	public String bark() {
		return "멍멍";
	}
	
}
