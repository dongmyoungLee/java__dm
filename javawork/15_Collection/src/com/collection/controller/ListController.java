package com.collection.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.collection.model.vo.Food;

public class ListController {
	public static void main(String[] args) {
		//List 는 Collection 인터페이스를 상속받은 인터페이스
		// 클래스를 다수 저장, 관리하는 기능을 정의한 인터페이스
		// 구현한객체
		
		
		// ArrayList 클래스
		// -> list 데이터를 자주 수정되지 않을 때 ..많이사용
		
		// LinkedList 클래스
		// -> 데이터가 자주 수정될 때
	
		// 배열과 동일하게 데이터의 인덱스번호를 관리함.
		// 데이터 순서가 있음.
		// 삽입, 수정, 삭제에 대한 메소드를 제공한다.
		// 클래스이기 때문에 연산자가 아닌 메소드로 데이터를 조작한다.
		
		// ArrayList Class..
		
		ArrayList list = new ArrayList();
		
		// 1. 데이터 저장 add
		list.add(true);
		list.add(19);
		list.add("유병승");
		list.add(new Date());
		
		//System.out.println(list);
		
		// add(index, 값); - 원하는 index에 넣기.
		list.add(1, "tetetet");
		//System.out.println(list);
		
		
		// 2. ArrayList 에서 데이터 출력하기
		// get(index번호) :인덱스 번호에 해당하는 값을 가져온다.
		int age = (int)list.get(2);
		//System.out.println(age);
		
		
		// 3. list에 저장된 데이터의 수 확인
		//System.out.println(list.size());
		
		// 반복문으로 출력
		for(int i = 0; i < list.size(); i++) {
			//System.out.println(list.get(i));
		}
		
		// 다수의 vo 객체를 저장관리 할때 ..
		ArrayList foods = new ArrayList();
		foods.add(new Food("뼈다귀해장국", 10000, "한식"));
		foods.add(new Food("만두국", 8000, "한식"));
		foods.add(new Food("햄버거", 8500, "양식"));
		
		Food f = (Food)foods.get(2);
		//System.out.println(f.getPrice());
		
		// 특정인덱스 값을 수정
		foods.set(1, new Food("짬뽕", 9000, "양식"));
		f = (Food)foods.get(1);
			
		//System.out.println(f);
		
		
		// list 데이터 삭제하기.
		// remove(인덱스번호), remove(객체)
		// 전체데이터 삭제 clear()
		
		foods.remove(2);
		//printArrayList(foods);
		// 동일한 결과 .. equals,hashcode  override 해줘야할듯
		foods.remove(new Food("짬뽕", 9000, "양식"));
		//printArrayList(foods);
		
		
		foods.clear();
		
		// ArrayList 클래스에서 데이터 저장, 수정,삭제,조회
		
		// List에 저장된 데이터를 찾아주는 메소드 contains, indexOf, lastIndexOf
		ArrayList names = new ArrayList();
		names.add("a1");
		names.add("a2");
		names.add("a3");
		names.add("a4");
		names.add("a5");
		names.add("a6");
		names.add("a7");
		
		System.out.println(names.contains("a7"));
		
		// List에 추가적인 메소드
		foods.add(new Food("탕수육", 25000, "중식"));
		foods.add(new Food("부대지개", 10000, "한식"));
		Food newFood = new Food("초밥", 20000, "일식");
		
		if(!foods.contains(newFood)) {
			foods.add(newFood);
		}
	
		// 객체를 찾아 인덱스번호를 가져오기
		// 초밥의 인덱스 번호를 찾기
		int index = foods.indexOf(newFood);
		System.out.println();
		
		
		// 추가메소드
		// ArrayList 를 배열로 변경해주는 메소드 : toArray();
		Object[] objFoods = foods.toArray();
		
		// Collection, List 인터페이스, ArrayList 가 구현한 인터페이스.
		Collection c = new ArrayList();
		List l = new ArrayList();
		// List 인터페이스는 타입으로 많이 활용을 함
		
		l = foods;
	
		// 배열을 List로 변경해주는 메소드 : Arrays.asList();
		Integer[] nums = new Integer[] {1,2,3,4,5};
		List numbers = Arrays.asList(nums);
		
		// 만들면서 초기화
		List data = Arrays.asList(new String[] {"a1","a2","a3"});
		System.out.println(data);
		
		// List.of() -> 선언과 동시에 초기화 * 불변의 리스트!
		data = List.of(1,2,3,4,5);
		System.out.println(data);
		
		
		
		
		
		
		
		
		
	}
	
	private static void printArrayList(List list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
		
}
