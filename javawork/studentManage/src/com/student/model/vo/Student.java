package com.student.model.vo;

public class Student {
	private long studentNo;
	private String name;
	private int age;
	private char gender;
	private String address;
	private String phone;
	private String email;
	private String major;
	int count = 0;
	
	{
		studentNo = ++count;
	}
	
	public Student() {}
	
	public Student(String name, int age, char gender, String address, String phone, String email, String major) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.major = major;
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
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public String studentInfo() {
		return name + " " + age + " " + gender + " " + phone + " " + email + " " + address + " " + major;
	}
	
}
