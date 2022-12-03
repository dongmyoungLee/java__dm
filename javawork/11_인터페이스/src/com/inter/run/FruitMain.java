package com.inter.run;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.inter.common.FruitFilter;
import com.inter.model.vo.Fruit;

public class FruitMain {
	public static void main(String[] args) {
		Fruit[] fruits = new Fruit[] {
			new Fruit("사과", "빨강", 15000, 5.2),
			new Fruit("바나나", "노랑", 8000, 5.2),
			new Fruit("초록사과", "초록", 10000, 4.2),
			new Fruit("보라사과", "보라", 15481, 4.0),
			new Fruit("바나나2", "노랑", 21211, 5.7),
			new Fruit("주황색사과", "주황", 14478, 9.7),
			new Fruit("줄무늬사과", "줄무늬", 545822, 548.55),
		};
		
		Fruit[] result = searchColor(fruits, "빨강");
		
		// 배열과 메소드 정의문을 넣어줌..
		result = searchFruit(fruits, (f) -> f.getColor().equals("노랑"));
		printFruit(result);
		
		// 배열과 메소드 정의문을 넣어줌..
		result = searchFruit(fruits, (f) -> f.getPrice() > 50000);
		printFruit(result);
		
		
		// sample
		List<Fruit> list = Arrays.asList(fruits).stream()
		.filter((f) -> f.getColor().equals("빨강"))
		.collect(Collectors.toList());
		System.out.println(list);
		
	}
	
	private static void printFruit(Fruit[] fruit) {
		for (Fruit f : fruit) {
			if (f != null) {
				System.out.println(f);
			}
		}
	}
	
	
	// Fruit 배열과 FunctionalInterface 를 매개변수로 넘겨줌...
	public static Fruit[] searchFruit(Fruit[] data, FruitFilter filter) {
		// 들어온 데이터만큼 배열 만듬...
		Fruit[] result = new Fruit[data.length];
		
		int index = 0;
		
		for(int i = 0; i < data.length; i++) {
			if (filter.filter(data[i])) {
				result[index] = data[i];
				index++;
			}
		}
		
		return result;
	}
	
	public static Fruit[] searchColor(Fruit[] data, String color) {
		Fruit[] result = new Fruit[data.length];
		
		int index = 0;
		
		for (int i = 0; i < data.length; i++) {
			if (data[i].getColor().equals(color)) {
				result[index++] = data[i];
			}
		}
		
		return result;
	}
}
