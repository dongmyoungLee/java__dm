package com.extra.controller;

import java.util.ArrayList;
import java.util.List;

import com.extra.common.Gender;
import com.extra.model.dao.StudentDao;
import com.extra.model.vo.Student;

public class StreamController {
	public static void main(String[] args) {
		// Stream 이용해서 데이터 정제하기
		// Collection 에 저장된 데이터를 가지고 활용을 많이 한다.
		
		List<Student> students = StudentDao.getStudents();
		System.out.println(students.size());
		
		for(Student s : students)  {
			//System.out.println(s);
		}
		
		//남학생 조회하기
		List<Student> menStudent = new ArrayList();
		
		for(Student s : students) {
			if(s.getGender() == Gender.M) {
				menStudent.add(s);
			}
		}
		//남학생 조회
		menStudent.forEach(s -> System.out.println(s));
		System.out.println(menStudent.size());
		
		System.out.println();
		
		// Stream 이용해서 처리하기..
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
