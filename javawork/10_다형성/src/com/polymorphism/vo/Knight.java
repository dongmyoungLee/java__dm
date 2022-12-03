package com.polymorphism.vo;



public class Knight extends Character {
	
	private int power;
	private String weapon;
	
	public Knight(int hp, String name, int power, String weapon) {
		super(name, hp);
		this.power = power;
		this.weapon = weapon;
	}

	
	public void attack() {
		System.out.println("기사 실행");
	}
	

}
