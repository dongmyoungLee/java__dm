package com.generic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.collection.model.vo.Food;

public class GenericController {
	public static void main(String[] args) {
		// generic 은 한마디로 type 에 대한 변수이다..
		
		List<String> names = new ArrayList();
		names.add("유병승");
		String str = names.get(0);
		
		for(String data: names) {
			System.out.println(data);
		}
		
		//List names2 = new ArrayList();
		
		MyGeneric<String> my = new MyGeneric();
		my.setData("유병승");
		String data = my.getData();
		System.out.println(data);
		
		System.out.println();
		
		MyGeneric<Integer> my1 = new MyGeneric<Integer>();
		my1.setData(19);
		int age = my1.getData();
		System.out.println(age);
		
		List<Food> food = new ArrayList();
		food.add(new Food("햄버거", 19000, "양식"));
		food.add(new Food("햄버거1", 8000, "중식"));
		food.add(new Food("햄버거2", 7000, "양식"));
		food.add(new Food("햄버거3", 6000, "한식"));
		food.add(new Food("햄버거4", 5000, "양식"));
		
		for(Food f : food) {
			if(f.getPrice() > 10000) {
				System.out.println(f);
			}
		}
		
		// HashSet..
		Set<Food> foodSet = new HashSet(food);
		Iterator<Food> it = foodSet.iterator();
		
		while(it.hasNext()) {
			Food f = it.next();
			System.out.println(f);
		}
		
		// HashMap
		HashMap<String, Food> foodMap = new HashMap();
		foodMap.put("햄버거", new Food("햄버거", 9000, "양식"));
		foodMap.put("햄버거1", new Food("햄버거1", 19000, "양식"));
		foodMap.put("햄버거2", new Food("햄버거2", 29000, "양식"));
		foodMap.put("햄버거3", new Food("햄버거3", 39000, "양식"));
		foodMap.put("햄버거4", new Food("햄버거4", 94000, "양식"));
		foodMap.put("햄버거5", new Food("햄버거5", 59000, "양식"));
		
		Set<String> keys = foodMap.keySet();
		Iterator<String> mapIt = keys.iterator();
		
		while(mapIt.hasNext()) {
			String k = mapIt.next();
			Food f = foodMap.get(k);
			System.out.println(k);
			System.out.println(f);
			
		}
		System.out.println();
		Set<Map.Entry<String, Food>> entry = foodMap.entrySet();
		Iterator<Map.Entry<String, Food>> itFood = entry.iterator();
		
		while(itFood.hasNext()) {
			Map.Entry<String, Food> d = itFood.next();
			System.out.println(d.getKey());
			System.out.println(d.getValue());			
		}
		
		System.out.println();
		
		for(String k : foodMap.keySet()) {
			Food f = foodMap.get(k);
		}
		
		System.out.println();
		
		for(Map.Entry<String, Food> d : foodMap.entrySet()) {
			String k = d.getKey();
			Food f = d.getValue();
			System.out.println(k);
			System.out.println(f);
		}
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
