package com.bs.variable;

import java.util.Scanner;

public class StudentInfo {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String name;
		String mail;
		char sex;
		int age;
		int level;
		int ban;
		int num;
		double height;
			
		System.out.print("이름은 ? ");
		name = sc.next(); 
		System.out.print("나이는 ? ");
		age = sc.nextInt();
		System.out.print("성별은 ? ");
		sex = sc.next().charAt(0);
		System.out.print("몇학년 ? ");
		level = sc.nextInt();
		System.out.print("몇반? ? ");
		ban = sc.nextInt();
		System.out.print("키 몇 ? ");
		height = sc.nextDouble();
		System.out.print("이메일은 ? ");
		mail = sc.next();
		
		System.out.println("이름은 " + name + " 나이는 " + age + " 성별은 " + sex + " 학년은 " + level + " 반은 " + ban + " 키는 " + height + " 이메일은 " + mail);
		
	}
}
