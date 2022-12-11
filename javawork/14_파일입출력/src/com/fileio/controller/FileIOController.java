package com.fileio.controller;

import java.io.File;
import java.io.IOException;

public class FileIOController {
	public void basicFile() {
		// HDD에 저장되어있는 파일을 관리할 수 있는 클래스 -> File
		// 매개변수 있는 생성자를 이용해서 생성 -> 파일경로 + 파일명
		
		// 경로에 존재하는 파일명, 없는 파일명
		
		// 절대경로
		//File myFile = new File("D:/java__dm/README.md");
		
		// 상대경로, 파일명 앞에 아무것도 쓰지 않으면 프로젝트 폴더에 자동으로 설정
		File myFile = new File("test.txt");
		
		try {
			// 상대경로에 test.txt 라는 파일 생성함..
			myFile.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		// 폴더 생성하기
		// mkdir() -> 1개폴더 생성, mkdirs() -> 여러하위 폴더만들때
		File dir = new File("testaaa");
		//System.out.println(dir.mkdir());
		
		// 폴더 뎁스 추가
		File dir2 = new File("world/kor/seoul");
		//System.out.println(dir2.mkdirs());
			
		// 경로지정
		// 폴더가 존재하지 않는경우 폴더를 생성 해줘야 함.
		File test = new File("D:/java__dm/javawork/14_파일입출력/testaaa/test.txt");
		
		try {
			// 파일이 없다면..
			if(!test.exists()) {
				System.out.println(test.createNewFile());
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		// 존재하고 있는 파일 정보 확인하기
		File currFile = new File("test.txt");
		// 1. 파일명 확인
		System.out.println(currFile.getName());
		
		// 2. 경로확인
		System.out.println(currFile.getAbsolutePath());
		
		// 3. 폴더인지 확인 & 파일인지 확인 
		System.out.println(currFile.isDirectory());
		System.out.println(currFile.isFile());
		// 존재유무
		System.out.println(currFile.exists());
		
		// 4. 파일 삭제
		File delFile = new File("test.txt");
		System.out.println(delFile.delete());
		
		// 폴더지우기 (최하위 폴더 하나만 지워짐...)
		File delDir = new File("testaaa");
		System.out.println(delDir.delete());
		
	}
	
	public void fileManage() {
		File f = new File("c:Windows/System32");
		
		// 폴더안에 있는 파일 가져오기.
		// 1. 문자열로 파일명을 가져오는 방법 -> list()
		// 2. File 클래스로 파일을 가져오는 방법 -> listFile();
		String[] files = f.list();
//		System.out.println(files.length);
//		
//		for(String file : files) {
//			File tmp = new File("c:Windows/System32" + file);
//			System.out.println(tmp.getName() + " : " +  tmp.isFile());
//		}
		
		File[] files2 = f.listFiles();
//		for(File file : files2) {
//			System.out.println(file.getName() + " : " + file.isFile());
//		}
		
		// exe만 가져오기
		files = f.list((dir, name) -> name.contains("exe"));
		
		System.out.println(files.length);
		
//		for(String file : files) {
//			System.out.println(file);
//		}
		
		files2 = f.listFiles((file) -> file.isDirectory());
		System.out.println(files2.length);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
