package com.polymorphism.vo;

public class Wizard extends Character {
	private String weapon;
	private int mp;	
	

	
	public Wizard(String name, int hp, String weapon, int mp) {
		super(name, hp);
		this.weapon = weapon;
		this.mp = mp;
	}



	public void attack() {
		System.out.println("마법사 실행");
	}
	
	
}
