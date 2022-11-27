package com.Inherit.model.vo;

public class Student extends Person {
	private int grade;
	private int classNumber;
	private int number;
	
	public Student() {}

	public Student(int grade, int classNumber, int number) {
		super();
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
	
	

	
	
}
