package com.Inherit.model.vo;

public class Student extends Person {
	private int grade;
	private int classNumber;
	private int number;
	
	public Student() {}

	public Student(String name, int age, char gender, String address, int grade, int classNumber, int number) {
		// super 에 매개변수 넣어도 되고 안 넣으면 default 설정
		super(name, age, gender, address);
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	// 학생정보 출력
	public String infoStudent() {
		return name + " " + getAge() + " " + getGender() + " " + getAddress() + " " +  grade + " " + classNumber + " " + number; 
	}

	
	
}
