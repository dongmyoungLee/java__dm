package com.collection.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesController {
	public static void main(String[] args) {
		// Properties 클래스..
		// map 방식으로 처리 -> key, value 로 되어 있음. 파일과 연결해서 데이터를 관리할 수 있다.
		// 프로그램에서 사용자와 맞는 설정값, 환경설정 내용을 관리할 때 사용할 수 있음.
		
		Properties props = new Properties();
		
		// 데이터 저장 -> key 문자열, value 문자열
		props.put("name", "류병승");
		props.put("email", "devteacher09@gmail.com");
		
		props.setProperty("Phone", "01055522323");
		
		System.out.println(props);
		
		// 저장된 값을 간편하게 파일로 저장시킬 수 있음
		// store() 메소드 제공
		
//		try {
//			props.store(new FileOutputStream("test.properties"), "");
//			props.storeToXML(new FileOutputStream("test.xml"), "xmltest");
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		
		// 저장된 데이터 가져오기
		Properties loadProps = new Properties();
		try {
			System.out.println(loadProps);
			loadProps.load(new FileInputStream("test.properties"));
			System.out.println(loadProps);
			System.out.println();
			// 불러온데이터 출력
			System.out.println(loadProps.getProperty("name"));
			
			loadProps.load(new FileReader("driver.properties"));
			System.out.println(loadProps.getProperty("driver"));
			System.out.println(loadProps.getProperty("pw"));
			
			// xml 파일 불러오기
			loadProps.loadFromXML(new FileInputStream("test.xml"));
			System.out.println(loadProps.getProperty("name"));
			System.out.println(loadProps.getProperty("email"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
