package com.object.controller;

import java.util.Arrays;
import java.util.Scanner;
import com.object.model.vo.Person;



public class ObjArrController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] persons = new Person[5];
		
		
		
		// 객체배열은 객체를 저장할 수 있는 변수를 만든것으로 변수에 객체를 생성 후 사용..
		persons[0] = new Person("ree", 23, "ewew");
		
		// 배열에 저장된 객체에 값을 대입하려면  .. ?
		persons[0].setName("tttttttttt");
		//System.out.println(persons[0].infoPerson());
		
		// persons 배열에 사용자에게 입력받은 사람의 정보를 저장하기
		persons = new Person[3];
		
		Scanner sc = new Scanner(System.in);
		
		/*
		for(int i = 0; i < persons.length; i++) {
			persons[i] = new Person();
			
			System.out.print("이름 : ");
			persons[i].setName(sc.next());
			System.out.print("나이 : ");
			persons[i].setAge(sc.nextInt());
			System.out.print("주소 : ");
			persons[i].setAddress(sc.next());
		}
		*/
		
		/*
		for(Person p:persons) {
			System.out.println(p.getName() + " " + p.getAge() + " " + p.getAddress());
		}
		*/
		
		// 객체배열 선언과 동시에 초기화하기
		int[] intArr = {1,2,3,4,5};
		
		Person[] persons2 = {
				new Person(),
				new Person("이동명", 19, "경기도"),
				new Person("이순신", 23, "하하하"),
				new Person("이순신3", 42, "하하하"),
				new Person("이순신4", 49, "하하하"),
		};
		
		persons = new Person[] {new Person(), new Person()};
		
		// person2 에서 나이가 40대 이상인 사람 찾기 출력
		
		/*
		for (int i = 0; i < persons2.length; i++) {
			
			if (persons2[i].getAge() > 40) {
				System.out.println(persons2[i].infoPerson());
			}
		}
		*/
		
		
		
	}

}
