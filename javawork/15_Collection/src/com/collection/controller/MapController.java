package com.collection.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.collection.model.vo.Animal;
import com.collection.model.vo.Food;

public class MapController {
	public static void main(String[] args) {
		// 저장구조 : key 와 value 의 쌍으로 구성되어 있음.
		// key : Object 자료형, value : Object 자료형
		
		// key 값은 중복이 불가능..
		
		// key 값 일반적으로 String, int형(Integer)을 사용
		
		// Map 인터페이스를 구현한 클래스를 이용해서 사용
		// HashMap, TreeMap, Properties..
		
		HashMap map = new HashMap();
		
		// 데이터 저장
		map.put("뽀삐", new Animal("뽀삐", 5.2, 10, "강아지"));
		map.put("야옹이", new Animal("야옹이", 4.2, 2, "고양이"));
		map.put("개코", new Animal("개코", 32, 4, "원숭이"));
		
		// 가져오기
		Object o = map.get("뽀삐");
		System.out.println(o);
		o = map.get("개코");
		System.out.println(o);

		// key 값은 중복을 허용하지 않음.
		// 동일한 key 값으로 put() 메소드를 실행하면 key 에 있는 값을 덮어쓰기 해버림.
		map.put("뽀삐", new Food("국밥", 10000, "한식"));
		o = map.get("뽀삐");
		System.out.println(o);
		
		// map 데이터 삭제
		map.remove("뽀삐");
		o = map.get("뽀삐");
		System.out.println(o);
		
		// Map 에 저장되어 있는 객체의 데이터를 수정
		// 개코의 나이를 수정하기
		o = map.get("개코");
		((Animal)o).setAge(20);
		System.out.println(o);
		
		// map 저장된 데이터 수 확인
		System.out.println(map.size());
		
		// map에 저장된 데이터 조회하기
		map.put("킥킥1", new Animal("킥킥1", 5.2, 10, "강아지"));
		map.put("킥킥2", new Animal("킥킥2", 5.2, 10, "강아지"));
		map.put("킥킥3", new Animal("킥킥3", 5.2, 10, "강아지"));
		map.put("킥킥4", new Animal("킥킥4", 5.2, 10, "강아지"));
		
		System.out.println(map);
		System.out.println();
		
		//map 에 저장된 모든 데이터를 출력하기
		// 1. key 값을 먼져 가져옴. -> keySet() 메소드를 이용한다. key 값을 set 방식으로 반환해주는 로직
		// 2. 가져온 key 값으로 value 가져와 출력함. -> get(key)
		
		Set keys = map.keySet();
		System.out.println(keys);
		
		Iterator it = keys.iterator();

		/*
		while(it.hasNext()) {
			Object k = it.next(); // key값을 변수에 저장
			System.out.println(k + " : " +map.get(it.next()));
		}
		*/
		
		System.out.println();
		
		
		for(Object k : keys) {
			System.out.println(k + " : " + map.get(k));
		}
		
		System.out.println();
		
		// key 와 value 를 한번에반환해주는 메소드를 제공
		Set entry = map.entrySet();
		System.out.println(entry);
		
		System.out.println();
		
		Iterator it2 = entry.iterator();
		while(it2.hasNext()) {
			Map.Entry e = (Map.Entry)it2.next();
			// key 값 출력 : Map.Entry getKey();
			//	value 값 출력 : Map.Entry getValue();
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}
		System.out.println();
		System.out.println("forEach..");
		System.out.println();
		
		for(Object entry1 : map.entrySet()) {
			Map.Entry e = (Map.Entry)entry1;
			
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}
		
		System.out.println();
		
		// 불변의 map을 생성할 수 있음.
		// of() 메소드 사용
		Map test = Map.of("name", "유병승", "age", 19, "gender", 'M');
		System.out.println(test);
		
		// 특정 key 값이 있는지 확인하는 메소드
		System.out.println(map.containsKey("킥킥1"));	
		
		// 특정 값이 있는 지 확인하는 메소드
		System.out.println(map.containsValue("음메"));
		
		// values를 이용하면 value에 저장된 값을 Collection으로 반환
		Collection c = map.values();
		
		List a = new ArrayList(c);
		System.out.println(a.get(0));
		
		
		// List 에 Map을 저장해서 관리하는 방법
		List members = new ArrayList();
		members.add(Map.of("id", "admin", "pass", "1234", "name", "관리자"));
		members.add(Map.of("id", "user01", "pass", "1234", "name", "철수"));
		members.add(Map.of("id", "user02", "pass", "1234", "name", "영희"));
		members.add(Map.of("id", "user03", "pass", "1234", "name", "맹구"));
		
		System.out.println(members);
		System.out.println();
		for(Object m : members) {
			System.out.println("아이디" + " " +((Map)m).get("id")); 
			System.out.println("이름" + " " + ((Map)m).get("name")); 
		}
		
		
		
	}

















}
