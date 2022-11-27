package com.Inherit.model.vo;

public class Animal {
	private String type;
	private String name;
	private int age;
	private char gender;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String type, String name, int age, char gender) {
		super();
		this.type = type;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String bark() {
		return "울음소리";
	}
	
	
	
	
}
