package com.polymorphism.vo;

public class Archer extends Character {
	private String weapon;
	private int count;

	
	
	public Archer(String name, int hp, String weapon, int count) {
		super(name, hp);
		this.weapon = weapon;
		this.count = count;
	}



	public void attack() {
		System.out.println("궁수 실행");
	}
	
}

