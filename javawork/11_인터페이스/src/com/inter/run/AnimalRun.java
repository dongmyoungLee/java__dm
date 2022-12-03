package com.inter.run;

import com.inter.common.animal.inter.FlyAble;
import com.inter.common.animal.inter.MoveAble;
import com.inter.common.animal.inter.WaterMoveAble;
import com.inter.model.vo.Animal;
import com.inter.model.vo.Dog;
import com.inter.model.vo.Pigeon;
import com.inter.model.vo.Whale;

public class AnimalRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Dog d =	new Dog("바둑이", 1, 1, "강아지", "경기도 시흥시");
		Pigeon p = new Pigeon("닭둘기", 1, 1, "비둘기", "둥지");
		Whale w = new Whale("고래고래", 1, 1, "고래", "바다");
		
		fly(p);
		System.out.println(d.getX() +  " : " + d.getY());
		move(d, 100, 100);
		System.out.println(d.getX() +  " : " + d.getY());
		swim(w);
		System.out.println(p.getX() +  " : " + p.getY());
		move(p, 50, 50);
		System.out.println(p.getX() +  " : " + p.getY());
		
		
		// array
		MoveAble[] move = {p, d};
	}
	
	public static void fly(FlyAble fly) {
		fly.fly();
	}
	
	public static void move(MoveAble move, int x, int y) {
		move.move(x, y);
	}
	
	public static void swim(WaterMoveAble w) {
		w.swim();
	}

}
