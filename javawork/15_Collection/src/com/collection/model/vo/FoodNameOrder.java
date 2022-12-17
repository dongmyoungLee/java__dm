package com.collection.model.vo;

import java.util.Comparator;

public class FoodNameOrder implements Comparator {

	@Override
	public int compare(Object pre, Object next) {
		// 이름순으로 정렬하기
		Food preFood = (Food)pre;
		Food nextFood = (Food)next;
		
		return preFood.getName().compareTo(nextFood.getName());
	}
	
}
