package com.Inherit.model.vo;

import java.util.Objects;

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
		test();
		return getName() + " " + getAge() + " " + getGender() + " " + getAddress() + " " +  grade + " " + classNumber + " " + number; 
	}
	
	public void test() {
		System.out.println("자식 클래스의 test 메소드");
	}
	
	// 동등성 비교를 위해 equals override..
	/// Object 자료형으로 선언하게 되면 java에서 생성되는 모든 클래스를 전부 저장 할 수 있음. 따라서 아래 파라미터에 타입형이 무엇이어도 상관없음.
	@Override
	public boolean equals(Object o) {
		Student student = (Student)o;
		
		if (this.getName().equals(student.getName())
			&& this.getAge() == student.getAge()
			&& this.getGender() == student.getGender()
			&& this.getAddress().equals(student.getAddress())
			&& this.getNumber() == student.getNumber()) {
			
			return true;
		}
		
		return false;
	}
	
	// toString override..
	@Override
	public String toString() {
		return getName() + " " + getAge() + " " + getGender() + " " + getAddress() + " " + grade + " " + classNumber + " " + number;
	}
	
	@Override
	public int hashCode() {
		// 아래값들이 같으면 같은 hashCode 를 출력하도록 override ..
		return Objects.hash(getName(), getAge(), getGender(), getAddress(), number);
	}
	
	

}
