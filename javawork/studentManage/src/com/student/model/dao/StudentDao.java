package com.student.model.dao;

import com.student.model.vo.Student;

public class StudentDao {
	// 입력된 학생(생성된 Student 객체)을 관리하는 역할..
	private Student s1;
	private Student s2;
	private Student s3;
	
	public boolean saveStudent(Student student) {
		
		if (this.s1 == null) {
			this.s1 = student;
			return true;
		}
		
		if (this.s2== null) {
			this.s2 = student;
			return true;
		}
		
		if (this.s3 == null) {
			this.s3 = student;
			return true;
		}
		
		return false;
	}
	
	public String searchAll() {
		String result = "";
		
		// 필드에 저장된 학생을 반환해주는 기능
		if (s1 != null) {
			result += s1.studentInfo() + "\n";
		}
		
		if (s2 != null) {
			result += s2.studentInfo() + "\n";
		}
		
		if (s3 != null) {
			result += s3.studentInfo() + "\n";
		}
		
		return result;
	}
	
	public String searchName(String searchName) {
		// 매개변수로 전달된 값이랑 저장된값을 비교..
		String result = "";
		
		if (s1 != null && s1.getName().equals(searchName)) {
			result += s1.studentInfo() + "\n";
		}
		
		if (s2 != null && s2.getName().equals(searchName)) {
			result += s2.studentInfo() + "\n";
		}
		
		if (s3 != null && s3.getName().equals(searchName)) {
			result += s3.studentInfo() + "\n";
		}
		
		return result;
		
	}
}
