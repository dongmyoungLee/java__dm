package com.Inherit.model.vo;

public class Person {
	private String name;
	private int age;
	private char gender;
	private String address;
		
	public Person() {}

	public Person(String name, int age, char gender, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void test() {
		System.out.println("부모 클래스의 test 메소드");
	}
	
	// final 이라는 예약어가 붙으면 재정의가 불가능하다..
	public final String personPrint() {
		
		return "사람 : " + name + age + gender + address;
	}
	
	
	
}
