package com.student.model.dao;

import java.util.Scanner;

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
	private Student[] students = new Student[3];
	private static int index = 0;
	
	
	// 학생 저장..
	public int saveStudent(Student student) {
		// 0 : 저장성공 , 1 : 저장실패 (중복), 2 : 저장실패 (저장 공간 부족)
		int result = 2; 
		
		// 저장되는 값과 동일한 학생이 있는지 확인하고 중복이 있으면 저장하지 않도록 ..
		for(Student saveStudent : students) {
			if (saveStudent != null && saveStudent.equals(student)) {
				result = 1;
				return result;
			}
		}
		
		/*
		for (int i = 0; i < students.length; i++) {
			if (this.students[i] == null) {
				this.students[i] = student;
				result = 0;
				break;
			}
		}
		*/
		
		try {
			students[StudentDao.index++]=student;
		} catch(ArrayIndexOutOfBoundsException e) {
			Student[] temp = new Student[students.length+1];
			//깊은복사 students 의 0번째 인덱스를 temp 의 0번째인덱스 부터 stduents의 개수만큼.. 
			System.arraycopy(students, 0, temp, 0, students.length);
			temp[students.length] = student;
			students = temp;
		}
		
		
		
		return result;
	
	}
	
	// 학생 전체 조회..
	public String searchAll() {
		String result = "";
		
		// 필드에 저장된 학생을 반환해주는 기능
		for(Student student : students) {
			if (student != null) {
				result += student + "\n";
			}
		}
		
		// 여기서 보내는 boolean 값은 controller 에서 메시지 출력 분기용 데이터로 보내진다..
		return result;
	}
	
	// 학생 이름으로 조회..
	public String searchName(String searchName) {
		// 매개변수로 전달된 값이랑 저장된값을 비교..
		String result = "";
		
		for (Student student : students) {
			// 포함하는 이름 전부검색..
			if (student != null && student.getName().contains(searchName)) {
				result += student + "\n";
			}
		}
				
		return result;
		
	}
	
	public String searchMajor(String searchMajor) {
		String result = "";
		
		for (Student student : students) {
			if (student != null && student.getMajor().equals(searchMajor)) {
				result += student + "\n";
			}
		}
		
		return result; 
	}
	
	// 이름으로 검색한 학생이 있다면 index 반환..
	public int searchModifyName(String modifyName) {
		int index = 0;
		int result = -1;
		
		// 저장된 데이터중 수정 대상 학생 index 반환
		for (Student student : students) {
			
			if (student != null && student.getName().equals(modifyName)) {
				result = index;
				return result;
			}
			
			index++;
		}
		
		return result;
	}
	
	// 수정한 정보로 학생 수정..
	public int modifyChangeStudent(Student modifyStudent, int index) {
		int result = 0;
		
	
		if (index != -1) {
			students[index] = modifyStudent;
			
			
			result = 1;
		}
		
		
		return result;
	}
	
	// 학생 삭제
	public int deletedStudent(int index) {
		int result = 0;
		int deleteConfirm = 0;
		Scanner sc = new Scanner(System.in);
		
		
		if (index != -1 && students[index] != null) {
			
			System.out.println("정말 삭제 하시겠습니까 ? ( Y & N )");
			String deleteResult = sc.nextLine();
			
			if (deleteResult.equals("Y") || deleteResult.equals("y")) {
				students[index] = null;
				return 1;
			} 
		}
		
		
		System.out.println("학생 삭제를 취소 합니다...");
		return 0;
		
	}
	
	
}
