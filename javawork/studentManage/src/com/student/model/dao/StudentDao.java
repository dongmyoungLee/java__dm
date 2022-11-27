package com.student.model.dao;

import com.student.model.vo.Student;

public class StudentDao {
	
	// 객체 싱글톤..
	private static StudentDao dao;
	private StudentDao () {};
	public static StudentDao getDao() {
		if(dao == null) {
			dao = new StudentDao();
		}
		return dao;
	}
	
	// 입력된 학생(생성된 Student 객체)을 관리하는 역할..
	
	// 객체배열로 저장
	private Student[] students = new Student[10];
		
	public boolean saveStudent(Student student) {
		boolean result = false;
		
		for (int i = 0; i < students.length; i++) {
			if (this.students[i] == null) {
				this.students[i] = student;
				result = true;
				break;
			}
		}
		return result;
	
	}
	
	public String searchAll() {
		String result = "";
		
		// 필드에 저장된 학생을 반환해주는 기능
		for(Student student : students) {
			if (student != null) {
				result += student.studentInfo() + "\n";
			}
		}
		
		// 여기서 보내는 boolean 값은 controller 에서 메시지 출력 분기용 데이터로 보내진다..
		return result;
	}
	
	public String searchName(String searchName) {
		// 매개변수로 전달된 값이랑 저장된값을 비교..
		String result = "";
		
		for (Student student : students) {
			if (student != null && student.getName().equals(searchName)) {
				result += student.studentInfo() + "\n";
			}
		}
				
		return result;
		
	}
}
