package com.student.controller;

import com.student.view.StudentView;

public class StudentController {
	// 서비스를 진행하는 역할..
	
	// 1. main메뉴를 출력해주는 기능..
	public void mainMenu() {
		new StudentView().mainMenu();
	}
}
