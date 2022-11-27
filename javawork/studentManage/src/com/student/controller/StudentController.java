package com.student.controller;

import com.student.model.dao.StudentDao;
import com.student.model.vo.Student;
import com.student.view.StudentView;

public class StudentController {
	private StudentDao dao = new StudentDao();

	// 서비스를 진행하는 역할..
	
	// 1. main메뉴를 출력해주는 기능..
	public void mainMenu() {
		new StudentView().mainMenu();
	}
	
	// 2.  학생등록 서비스 기능
	public void insertStudent() {
		// 1. 학생 등록하는 화면을 실행..
		Student student = new StudentView().inputStudentView();
		System.out.println("저장된 학생 정보 : " + student.studentInfo());
		
		// 2. 입력된 학생을 저장..
		boolean result = dao.saveStudent(student);
		
		// 3. 저장결과 출력
		new StudentView().printMsg(result ? "학생 저장 성공" : "학생 저장 실패", "학생 저장 성공");	
	}
	
	// 3. 전체학생조회
	public void searchAll() {
		// dao 에 저장되어 있는 학생정보 가져오기
		String searchStudent = dao.searchAll();
		
		// 가져온 데이터 출력
		new StudentView().printMsg(searchStudent, "전제 조회 성공");
	}
	
	// 4. 이름으로 조회
	public void searchName() {
		// 이름으로 조회하는 기능
		String searchName = new StudentView().inputName();
		
		String result = dao.searchName(searchName);
		
		new StudentView().printMsg(result, "이름으로 조회 성공");
	}
	
	
}
