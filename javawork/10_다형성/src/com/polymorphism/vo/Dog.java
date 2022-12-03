package com.polymorphism.vo;

public class Dog extends Animal {
	
	public Dog(String name, String gender) {
		super(name, gender);	
	}
	public Dog() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void bark() {
		System.out.println("멍멍");
	}
}
