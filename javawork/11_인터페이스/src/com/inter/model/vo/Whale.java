package com.inter.model.vo;

import com.inter.common.animal.inter.WaterMoveAble;

public class Whale extends Animal implements WaterMoveAble {
	
	public Whale (String name, int x, int y, String area, String type) {
		super(name, x, y, area, type);
	}
	
	@Override
	public void swim() {
		System.out.println("첨벙첨벙");
	}
}
