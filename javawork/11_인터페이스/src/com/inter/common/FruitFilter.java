package com.inter.common;

import com.inter.model.vo.Fruit;

@FunctionalInterface
public interface FruitFilter {
	boolean filter(Fruit f);
}
