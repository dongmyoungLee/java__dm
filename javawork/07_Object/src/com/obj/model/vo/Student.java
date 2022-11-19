package com.obj.model.vo;

public class Student {
	// 프로젝트에서 학생에 대한 정보를 저장, 관리하는 역할
	public final int STUDENT_NUM;
	public String name;
	public int age;
	public int grade;
	public int classNum;
	public double height;
	public String address;
	public int count;
	private static int no;
	
	
	// 초기화 블록 선언하기	
	
	static {
		System.out.println("static 초기화");
		Student.no = 0;
	}
	
	{
		System.out.println("생성");
		// final 상수 초기화 할 수 있음.
		
		// static 변수로 선언해야 누적할 수 있음.
		// 멤버변수로 선언할 경우 heap 메모리가 생성될때마다 1씩 오르는거임. heap 메모리는 생성할때 마다 no 는 0임 . heap 생성할때마다 ++ 해주니까 계속 0->1 로 될수 밖에 없는거임
		// 하지만 static 으로 선언할 경우 static 메모리에 쌓였던값이 계속 누적되기 때문에 카운트가 누적이 될 수 있음.. 중요함..
		STUDENT_NUM = ++Student.no;
		
	}
	
	
	public void studentInfo() {
		
		System.out.println(STUDENT_NUM + " 이름 : " + name +" "+ age + "살 " + grade + "학년" + classNum + "반 " + height + "의 키를 가지고 " + address + "에 살고 있음");
	}
}
