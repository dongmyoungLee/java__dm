package com.polymorphism.vo;

public class Animal {
	private String name;
	private String gender;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void bark() {
		System.out.println("이 동물은 울지않아요 ! ");
	}
}
