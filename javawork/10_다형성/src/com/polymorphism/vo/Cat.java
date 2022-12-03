package com.polymorphism.vo;

public class Cat extends Animal {
	
	public Cat(String name, String gender) {
		super(name, gender);
	}
	
	public Cat() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void bark() {
		System.out.println("야오오오오옹");
	}
}
