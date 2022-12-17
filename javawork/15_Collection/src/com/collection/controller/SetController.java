package com.collection.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.collection.model.vo.Animal;

public class SetController {
	public static void main(String[] args) {
		// 다수의 데이터(객체)를 저장할 수 있는 클래스
		// HashSet, LinkedHashSet, treeSet
		// 데이터를 중복해서 저장하지 않는다.
		// 저장된 특정데이터만 가져올수는 없음. * 데이터를 지칭하는 이름이 없음
		
		// 1.HashSet, 
		HashSet set = new HashSet();
		
		// 추가
		set.add("이동명");
		set.add("윤주");
		set.add("김태훈");
		set.add("김성훈");
		set.add("박세훈");
		
		System.out.println(set);
		
		// set 에 있는 데이터를  출력하기 위해서는 전체를 가져와 처리해야한다.-> Iterator 를 이용
		Iterator it = set.iterator();
		
		/*
		while(it.hasNext()) {
			// 저장
			Object o = it.next();
			// 출력
			System.out.println(o);
		}
		*/
		
		//forEach 도 가능함
		for(Object o : set) {
			System.out.println(o);
		}
		
		System.out.println();
		
		//forEach 메소드
		set.forEach(o -> System.out.println(o));
		
		System.out.println();
		
		// set 에는 중복값을 저장하지 않음..
		// 저장되는 클래스에 equals, hashCode 메소드가 오버라이드가 되어있어야한다...
		set.add("갓갓갓");
		set.add("갓갓갓");
		set.add("갓갓갓");
		set.add("갓갓갓");
		set.add("갓갓갓");
		set.add("갓갓갓");

		set.forEach(o -> System.out.println(o));
		
		Set animals = new HashSet();
		animals.add(new Animal("뽀삐", 5.2, 5, "강아지"));
		animals.add(new Animal("뽀삐2", 7, 10, "강아지"));
		animals.add(new Animal("뽀삐3", 8, 2, "강아지"));
		animals.add(new Animal("뽀삐3", 8, 3, "강아지"));
		animals.add(new Animal("뽀삐3", 8, 4, "강아지"));		
		animals.add(new Animal("뽀삐3", 8, 25, "강아지"));
		
		for(Object o : animals) {
			System.out.println(o);
		}
		
		// set 메소드로 데이터 확인하기
		// 1. 저장된 데이터 개수 확인
		System.out.println(animals.size());
		
		// 2. 저장된 데이터가 있는지 없는지 확인
		System.out.println(animals.isEmpty());
		
		// 3. 데이터 포함여부
		System.out.println(animals.contains(new Animal("뽀삐3", 8, 25, "강아지")));
		
		// 4. 데이터 삭제하기
		animals.remove(new Animal("뽀삐3", 8, 25, "강아지"));
		System.out.println();
		for(Object o : animals) {
			System.out.println(o);
		}
		System.out.println();
		
		// 5. List , Set 호환관계 ( set 을 list 로 변경 )
		List animalsList = new ArrayList(animals);
		
		System.out.println(animalsList.get(0));
		
		System.out.println();
		animalsList.add(new Animal("뽀삐3", 8, 25, "강아지"));
		animalsList.add(new Animal("뽀삐3", 8, 25, "강아지"));
		animalsList.add(new Animal("뽀삐3", 8, 25, "강아지"));
		animalsList.add(new Animal("뽀삐3", 8, 25, "강아지"));
		
		animalsList.forEach(o -> System.out.println(o));
		// list -> set 으로 넘겨서 중복제거..
		Set temp = new HashSet(animalsList);
		
		System.out.println();
		for(Object o : temp) {
			System.out.println(o);
		}
		
		System.out.println();
		
		HashSet lotto = new HashSet();
		
		while(lotto.size() != 6) {
			lotto.add((int)(Math.random() * 45)+1);
		}
		
		for(Object o : lotto) {
			System.out.println(o);
		}
		
		System.out.println();
		
		ArrayList list2 = new ArrayList(lotto);
		list2.sort((pre,next) -> (int)pre - (int)next);
		System.out.println(list2);
		
		// 순서 기억
		LinkedHashSet linkSet = new LinkedHashSet();
		linkSet.add(1);
		linkSet.add(2);
		linkSet.add(5);
		linkSet.add(6);
		linkSet.add(2);
		linkSet.add(10);
		System.out.println(linkSet);
		
		for(Object o : linkSet) {
			System.out.println(o);
		}
		
		System.out.println();
		
		// 정렬기능을 이용할수 있음 (  tree 는 객체를 구분할 수 있는 순서가 있어야함... animal class 에서 Comparable 인터페이스가 구현되어 있어야 함....)
		TreeSet tSet = new TreeSet();
		tSet.add(1);
		tSet.add(5);
		tSet.add(6);
		tSet.add(8);
		tSet.add(3);
		tSet.add(2);
		
		System.out.println(tSet);
		
		tSet = new TreeSet(animals);
		
		for(Object o : tSet) {
			System.out.println(o);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



