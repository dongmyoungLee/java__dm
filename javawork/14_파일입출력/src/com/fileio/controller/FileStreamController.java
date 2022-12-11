package com.fileio.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class FileStreamController {
	public void fileSave() {
		// 애플리케이션에서 관리하는 데이터(RAM)를 특정파일(HDD)에 저장하는 기능
		// 1. FileOutputStream 클래스 생성.. 전송할 데이터를 write() 메소드를 이용해서 전송
		// String 으로 파일 경로 및 파일명을 전달하는 생성자 만듬  or File 객체를 전달하는 생성자
		// write(int) 는 byte단위 통신이므로 int 형으로 데이터를 전송해줘야한다, 전체 데이터를 전송할때 까지 write()메소드를 반복
		// 2. 반드시 생성 된 FileOutputStream클래스를 반환(닫아주기)해야함..
		
		FileOutputStream fos = null;
		
		try {
			// FileOutputStream 을 생성하면.. 매개변수 이름과 파일이 없으면 자동으로 해당경로에 파일을 생성해서 stream을 연결함.
			String name = "유병승";
			fos = new FileOutputStream("testFile");
			fos.write(10);// 개행
			fos.write(65);// A
			fos.write('a');
			
			// int 값이 아니라서 불가능함
			//fos.write(name);
			// byte가 쪼개짐
			fos.write(name.charAt(0));
			fos.write(name.charAt(1));
			fos.write(name.charAt(2));
			
			
		}	catch(FileNotFoundException e) {
			e.printStackTrace();
		}	catch(IOException e) {
			e.printStackTrace();
		}	finally {
			
			try {
				if (fos != null) {
					fos.close();
				}
				
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public void loadFile() {
		// HDD 에 저장된 파일 어플리케이션으로 읽어오기
		// 1. FileInputStream 클래스 를 생성, 매개변수있는 생성자를 이용
		// String으로 경로와 파일명 전달, File 객체를 전달
		// * 지정한 파일이 없으면 exception 발생함.
		// 2. read() 메소드를 이용해서 파일에 저장된 내용을 불러옴
		// int 형으로 데이터를 가져옴, 가져온 데이터는 변수에 저장시켜야 재사용 가능.
		// 저장된 데이터의 크기나 값이 없기 때문에 기준이 있음
		// read() 메소드를 실행했을때 반환값이 -1이 나오면 데이터를 모두 읽어온 것이다.-> read() 메소드가 -1 을 반환할때까지 실행
		// 3. 반드시 FileInputStream 클래스를 반환해줘야함. close()
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("testFile");
			// 데이터읽어오기 위한 반복문
			int value = 0;
			while((value = fis.read()) != -1) {
				System.out.println((char)value);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e ) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			}	catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	//문자열을 저장하기 위해서는 Reader, Writer 클래스를 상속받은 클래스를 이용..
	// FileReader, FileWriter
	public void saveFileStr() {
		FileWriter writer = null;
		
		try {
			writer = new FileWriter("strssss");
			String name = "유병승";
			int age = 19;
			writer.write(name);
			writer.write(age);
			writer.write("19");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(writer != null) {
					writer.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void loadFileStr() {
		FileReader fr = null;
		
		try {
			fr = new FileReader("strssss");
			int value = 0;
			StringBuffer sb = new StringBuffer();
			
			while((value = fr.read()) != -1) {
				//System.out.println((char)value);
				sb.append((char)value);
			}
			
			System.out.println(sb);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) {
					fr.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void memoFile() {
		Scanner sc = new Scanner(System.in);
		
		FileWriter writer = null;
		
		try {
			// true -> 추가하기.
			writer = new FileWriter(new File("memo"), true);
			
			for(int i = 0; i < 3; i++) {
				System.out.println("메세지 입력 : ");
				String str = sc.nextLine();
				writer.write(str + "\n");
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(writer != null) {
					writer.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void memoLoad() {
		// try with Resource 구문
		
		// try 안에 매개변수로 들어간것을 try문 끝나고 close 해준다..
		try(FileReader fr = new FileReader("memo")) {
			int value = 0;
			StringBuffer sb = new StringBuffer();
			while((value = fr.read()) != -1) {
				sb.append((char)value);
			}
			System.out.println(sb);
			String[] message = new String(sb).split("\n");
			
			for(int i = 0; i < message.length; i++) {
				System.out.println((i+1) + "번째 메세지 : " + message[i]);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// 보조스트림을 이용해보기..
	// 1. byte 기반 스트림을 문자기반 스트림으로 변경해주는 보조스트림
	// 2. dataType 기반으로 데이터를 저장할 수 있게 해주는 보조 스트림
	// 3. 객체자제를 저장할 수 있게 해주는 보조스트림
	// 4. 저장, 읽어오기 속도를 향상시켜주는 보조스트림
	
	// 기본스트림에 특수한 기능을 추가한 것.
	// 보조스트림만 생성해서 이용할 수는 없음. 모든 보조스트림은 기본스트림을 생성한 객체를 이용
	// new 보조스트림(new 기본스트림));
	
	public void changeStream() {
		//byte 단위로 불러온 stream을 문자열기반 stream 으로 처리
		try(FileInputStream fis = new FileInputStream("memo"); InputStreamReader isr = new InputStreamReader(fis)) {
			int data = 0;
			while((data = isr.read()) != -1 ) {
				System.out.println((char)data);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		// 제공되는 API 네트워크 상에서 데이터를 가져올 때 byte 기반 스트림을 많이 이용하게 된다.
		// 그때 문자열을 받아서 처리하는 내용이면 InputStreamReader 로 변환을 한다.
		
		try (FileWriter writer = new FileWriter("naver.html");){
			URL url = new URL("https://www.naver.com");
			HttpURLConnection connect = (HttpURLConnection)url.openConnection();
			InputStream page = connect.getInputStream();
			InputStreamReader isr2 = new InputStreamReader(page);
			int val = 0;
			StringBuffer sb = new StringBuffer();
			while((val = isr2.read()) != -1 ) {
				sb.append((char)val);
			}
			System.out.println(sb);
			
			writer.write(new String(sb));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// 데이터 자료형을 유지하면서 파일에 데이터를 저장시켜주는 보조스트림
	public void dataTypeWriter(String name, int age, char gender, double height) {
		// DataOutputStream
		try(FileOutputStream fos = new FileOutputStream("data.dat"); DataOutputStream dos = new DataOutputStream(fos)) {
			
			dos.writeUTF(name);
			dos.writeInt(age);
			dos.writeChar(gender);
			dos.writeDouble(height);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dataTypeReader() {
		try(FileInputStream fis = new FileInputStream("data.dat"); DataInputStream dis = new DataInputStream(fis)) {
			// 데이터를 가져올 때 주의사항
			// 데이터를 write 했을 때 자료형을 기준으로 동일한 순서로 불러와야 함.
			String name = dis.readUTF();
			int age = dis.readInt();
			char gender = dis.readChar();
			double height = dis.readDouble();
			
			System.out.println(name + " " + age + " " + gender + " " + height);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
