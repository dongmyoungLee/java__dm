package com.polymorphism.vo;

public class Student extends Person {
	private int grade;
	private int classNumber;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, double height, int grade, int classNumber) {
		super(name, age, height);
		this.grade = grade;
		this.classNumber = classNumber;
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
	
//	 여기서 매개변수 type을 Object 준 이유도 내가 어떤 타입으로 지정할지 모르니까 일단 최상위로 받아준거임.
	@Override
	public boolean equals(Object o) {
		
		if (o instanceof Student) {
			Student s = (Student)o;
			
			if (this.getName().equals(s.getName()) && this.grade == s.grade) {
				return true;
			}
		}
		
		return false;
		
		
		
	}
	
	@Override
	public String toString() {
		return "학생 " + super.toString() + " " + grade + " " + classNumber;
	}
	
	
	
}
