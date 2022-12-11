package com.fileio.vo;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = 3664150252174252338L;
	private String name;
	private int age;
	private char gender;
	private double height;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age, char gender, double height) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", height=" + height + "]";
	}
	
	
}
