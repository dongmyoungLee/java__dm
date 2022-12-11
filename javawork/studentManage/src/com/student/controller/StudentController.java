package com.student.controller;

import com.student.model.dao.StudentDao;
import com.student.model.vo.Student;
import com.student.view.StudentView;

public class StudentController {
	// 저장이 되는 객체는 상태가 유지되어야 하기 때문에 new로 계속 생성을 해줘서는 안됨..
	// 내 프로젝트 내에서는 기능을 제공하는 생성자는 하나만 만들자..-> singleton
	
	
	// 객체 singleton..
	private static StudentController controller;
	private StudentController() {};
	public static StudentController getController() {
		if (controller == null) {
			controller = new StudentController();
		}
		return controller;
	}
	
	private StudentDao dao = StudentDao.getDao();

	// 서비스를 진행하는 역할..
	
	// 1. main메뉴를 출력해주는 기능..
	public void mainMenu() {
		StudentView.getView().mainMenu();
	}
	
	// 1.  학생등록 서비스 기능
	public void insertStudent() {
		// 1. 학생 등록하는 화면을 실행..
		Student student = StudentView.getView().inputStudentView(1);
		System.out.println("저장된 학생 정보 : " + student.studentInfo());
		
		// 2. 입력된 학생을 저장..
		int result = dao.saveStudent(student);
		String msg = "";
		
		switch(result) {
			case 0 :
				msg = "학생 저장 성공";
			break;
			case 1 :
				msg = "학생 저장 실패 (중복)";
				break;
			case 2 :
				msg = "학생 저장 실패 (저장 공간 부족)";
				break;
		}
		
		// 3. 저장결과 출력
		StudentView.getView().printMsg(msg);	
	}
	
	// 2. 학생 수정
	public void modifyStudent() {
		// 수정할 학생의 이름을 받음..
		String modifyInputName = StudentView.getView().inputModName("mod");
		String msg = "";
		
		// 받은 이름으로 존재하는 학생인지 검색..
		// -1 : 없음 , 나머지는 해당 index
		int result = dao.searchModifyName(modifyInputName);
		
		if (result != -1) {
			// 수정할 정보 받기
			Student modifyStudent = StudentView.getView().inputStudentView(2);
			
			// 수정한 정보로 갈아끼우기
			int modResult = dao.modifyChangeStudent(modifyStudent, result);
			
			// 성공 메시지 출력
			StudentView.getView().printMsg(modResult == 1 ? "수정이 완료 되었습니다." : "수정 실패");
			return ;
		}
		
		StudentView.getView().printMsg("입력하신 학생은 존재하지 않습니다.");

		
	}
	
	// 3. 학생 삭제
	public void deleteStudent() {
	
		// 삭제할 학생이 존재하는지..
		String modifyInputName = StudentView.getView().inputModName("del");
		int result = dao.searchModifyName(modifyInputName);
		
		// -1 : 없음 , 나머지는 해당 index
		if (result != -1) {
			int deletedStudentResult = dao.deletedStudent(result);
			
			// 성공 메시지 출력
			StudentView.getView().printMsg(deletedStudentResult== 1 ? "삭제가 완료 되었습니다." : "삭제 실패");
			return ;
		}
		
		
		StudentView.getView().printMsg("입력하신 학생은 존재하지 않습니다.");
		
	}
	
	// 4. 전체학생조회
	public void searchAll() {
		// dao 에 저장되어 있는 학생정보 가져오기
		String searchStudent = dao.searchAll();
		
		// 가져온 데이터 출력
		StudentView.getView().printStudent(searchStudent);
	}
	
	// 5. 이름으로 조회
	public void searchName() {
		// 이름으로 조회하는 기능
		String searchName = StudentView.getView().inputName();
		
		String result = dao.searchName(searchName);
		
		StudentView.getView().printStudent(result);
	}
	
	// 6. 전공으로 조회
	public void searchMajor() {
		// 학생정보 가져오기..
		String searchMajor = StudentView.getView().inputMajor();
		
		String result = dao.searchMajor(searchMajor);
		
		StudentView.getView().printStudent(result);
		
	}
	
	// 7. 학생 파일로 내보내기
	public void saveData() {
		dao.saveStudents();
		
		System.out.println("학생 파일로 내보내기 성공..");
	}
	
	// 7. 파일로 저장된 학생 불러오기
	public void loadData() {
		dao.loadStudents();
		System.out.println("학생 불러오기 성공..저장됨");
	}
	
	
}
