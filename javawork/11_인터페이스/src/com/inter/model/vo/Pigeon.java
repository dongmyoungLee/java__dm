package com.inter.model.vo;

import com.inter.common.animal.inter.FlyAble;
import com.inter.common.animal.inter.MoveAble;

public class Pigeon extends Animal implements FlyAble, MoveAble {
	
	public Pigeon(String name, int x, int y, String area, String type) {
		super(name, x, y, area, type);
	}
	
	@Override
	public void fly() {
		System.out.println("파닥파닥");
	}
	
	@Override
	public void move(int x, int y) {
		setX(x);
		setY(y);
	}
}
