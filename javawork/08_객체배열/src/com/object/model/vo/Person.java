package com.object.model.vo;

public class Person {
	private String name;
	private int age;
	private String address;
	
	// ctrl + space + enter 기본 생성자
	public Person() {};

	// alt + s + a + g 매개변수있는 생성자
	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	// alt + s + r + a + r  getterm setter
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String infoPerson() {
		return name + " " + age + " " + address;
	}

	
	
	
	
	
}
