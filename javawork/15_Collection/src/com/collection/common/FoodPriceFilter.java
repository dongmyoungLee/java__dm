package com.collection.common;

import java.util.Comparator;

import com.collection.model.vo.Food;

public class FoodPriceFilter implements Comparator{

	@Override
	public int compare(Object pre, Object next) {
		// Food의 가격을 기준으로 내림차순 정렬하기
		Food preFood = (Food)pre;
		Food nextFood = (Food)next;
		
		if(preFood.getPrice() > nextFood.getPrice()) {
			return +1;
		} else if (preFood.getPrice() < nextFood.getPrice()) {
			return -1;
		} else {
			return 0; // 값이 동일할 경우
		}
		
	}
	
}
