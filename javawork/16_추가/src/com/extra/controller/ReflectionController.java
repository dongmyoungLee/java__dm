package com.extra.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.extra.common.Gender;
import com.extra.model.vo.Student;

public class ReflectionController {
	public static void main(String[] args) {
		// 자바에서 선언된 클래스의 정보를 가져오는 것.
		// 자바 클래스에 대한 정보를 관리하는 Class 클래스를 제공
		// Class, Field, method, constructor 에 대한 정보를 확인, 호출
		Student s = new Student(100, "유병승", 19, 180.5, Gender.M, "경기도 시흥시");
		Class studentClass = s.getClass();
		
		//student 클래스에 선언된 메소드를 조회
		Method[] methods = studentClass.getDeclaredMethods();
		
		for(Method m : methods) {
			//System.out.println(m);
			if(m.getName().contains("get")) {
				//System.out.println(m.getName());
			
				try {
					Object o = m.invoke(s);
					System.out.println(o);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println();
		System.out.println();
		Field[] fs = studentClass.getDeclaredFields();
		for(Field f : fs) {
			System.out.println(f);
			System.out.println(f.getName());
			// set 메소드를 이용해서 필드의 데이터를 변경할 수 있게 허용함
			f.setAccessible(true);
			try {
				if(f.getName().contains("name")) {
					f.set(s, "홍길동");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		System.out.println(s.getName());
		System.out.println();
		
		Student s3 = new Student.Builder().stdNo(103).name("유병승").gender(Gender.M).address("경기").age(19).height(180.5).build();
		System.out.println(s3);
		s3 = new Student.Builder().stdNo(13330).build();
		System.out.println(s3);
		
	}
}
