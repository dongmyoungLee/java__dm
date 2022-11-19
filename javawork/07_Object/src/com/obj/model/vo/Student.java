package com.obj.model.vo;

public class Student {
	// 프로젝트에서 학생에 대한 정보를 저장, 관리하는 역할
	public String name;
	public int age;
	public int grade;
	public int classNum;
	public double height;
	public String address;
	
	public void studentInfo() {
		
		System.out.println("이름 : " + name +" "+ age + "살 " + grade + "학년" + classNum + "반 " + height + "의 키를 가지고 " + address + "에 살고 있음");
	}
}
