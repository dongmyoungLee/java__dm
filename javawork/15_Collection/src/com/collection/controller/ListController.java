package com.collection.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.collection.model.vo.Animal;
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
		
		//System.out.println(names.contains("a7"));
		
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
		//System.out.println(data);
		
		// List.of() -> 선언과 동시에 초기화 * 불변의 리스트!
		data = List.of(1,2,3,4,5);
		//System.out.println(data);
		
		// ArrayList 에 data가 있는지 확인.. isEmpty();
		
		
		
		// Animal 클래스를 선언
		// 이름, 몸무게, 나이, 종류
		// 뽀삐 5.2, 3, 10, 강아지
		// 야옹이 4.2 , 5, 고양이
		// 킥킥이 15.3, 8, 원숭이
		// 하하 200, 3, 9, 하마
		
		// 1. 모두출력
		// 2. 이름,나이,몸무게만 출력
		// 3.몸무게 10 이상 이름,종류,몸무게 출력
		// 4. 나이가 5 이상인 데이터 전체출력
		// 5. 저장된 데이터의 나이를 1살씩 추가 한후 모든데이터 출력
		// 학생관리 ArrayList 사용해서 구현
		
		ArrayList animalList = new ArrayList();
		// 1
		animalList.add(new Animal("뽀삐", 5.2, 10, "강아지"));
		animalList.add(new Animal("야옹이", 4.2, 5, "고양이"));
		animalList.add(new Animal("킥킥이", 15.3, 8, "원숭이"));
		animalList.add(new Animal("하하", 200, 9, "하마"));
		//System.out.println(animalList);
		
		//2
		Animal[] tmp = new Animal[animalList.size()];
	
		for (int i = 0; i < animalList.size(); i++) {
			tmp[i] = (Animal)animalList.get(i);
			//System.out.println(tmp[i].getName() + " " + tmp[i].getAge() + " " + tmp[i].getWeight());
		}
		
		//3
		
		for (int i = 0; i < animalList.size(); i++) {
			tmp[i] = (Animal)animalList.get(i);
			
			if (tmp[i].getWeight() > 10) {
				//System.out.println(tmp[i].getName() + " " + tmp[i].getAge() + " " + tmp[i].getWeight());
			}
		}
		
		//4 
		
		for (int i = 0; i < animalList.size(); i++) {
			tmp[i] = (Animal)animalList.get(i);
			
			if (tmp[i].getAge()  > 5) {
				//System.out.println(tmp[i].toString());
			}
		}
		
		//5
		for (int i = 0; i < animalList.size(); i++) {
			tmp[i] = (Animal)animalList.get(i);
			
			tmp[i].setAge(tmp[i].getAge()+1);	
		}
		//System.out.println(animalList);
		listTest2();
		
		
	}
	
	private static void printArrayList(List list) {
		for(int i = 0; i < list.size(); i++) {
			//System.out.println(list.get(i));
		}
	}
	
	public static void listTest2() {
		// arrayList 추가 메소드
		// forEach(Consumer(functional인터페이스))
		
		ArrayList foods = new ArrayList(); // 저장공간 생성
		foods.add(new Food("자장면", 9000, "중식"));
		foods.add(new Food("치킨", 21000, "한식"));
		foods.add(new Food("김밥", 2000, "한식"));
		foods.add(new Food("초밥", 25000, "일식"));
		
		// 1번째 방법 ( 클래스직접 만들었음 )
		//foods.forEach(new Test());
		
		// 2번째 방법
		
//		foods.forEach(new Consumer() {
//			@Override
//			public void accept(Object o) {
//				Food f = (Food)o;
//				if(f.getType().equals("한식")) {
//					System.out.println(f);
//				}
//			}
//		});
		
		// 3번째 방법 lambda
		//foods.forEach((o) -> {System.out.println(o);});
		
		// 4번째 방법 lambda를 풀어서 씀
//		foods.forEach((o)-> {
//			Food f = (Food)o;
//			if(f.getType().equals("한식")) {
//				System.out.println(f);
//			}
//		});
		
		// 리스트에 저장된 데이터는 순서를 가지고 있음
		// 정렬 기준을 제공하는 클래스, 인터페이스를 구현.
		// 값을 정렬하는 기준 : 메소드의 리턴값을 기준으로 설정함..
		// 양수 : 앞뒤 순서를 변경
		// 음수 : 변경하지 않음
		// 0 : 변경하지 않음
		
		// 1. Comparator 인터페이스를 구현한 클래스를 이용하는 방식 -> 정렬을 처리하는 전용클래스를 생성
		foods.forEach(o -> System.out.println(o));
		
		System.out.println();
		
		//Collections.sort(foods, new FoodPriceFilter());
		Collections.sort(foods, (pre,next) -> {
			Food f2 = (Food)pre;
			Food f1 = (Food)next;
			return f1.getPrice() - f2.getPrice();
		});
		
		foods.forEach(o -> System.out.println(o));
		// 2. Comparable 인터페이스를 구현함 -> vo 클래스에 구현함
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
}
