package com.polymorphism.run;

import java.util.Scanner;

import com.polymorphism.vo.Archer;
import com.polymorphism.vo.Character;
import com.polymorphism.vo.Knight;
import com.polymorphism.vo.Wizard;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===== 다형성 게임 =====");
		System.out.println("===== 캐릭터 선택 =====");
		System.out.println("1. 기사");
		System.out.println("2. 궁수");
		System.out.println("3. 마법사");
		System.out.print("선택 : ");
		int cho = sc.nextInt();
		
		/*
		Knight k = null;
		Archer a = null;
		Wizard w = null;
		*/
		
		Character c = null;
		
		
		switch(cho) {
			case 1 : 
				c = new Knight(200, "BS기사", cho, "나무칼");
			break;
			
			case 2 : 
				c = new Archer("BS기사", 100 , "나무활", 10);
			break;
			
			case 3 : 
				c = new Wizard("BS법사", 100 , "나무지팡이", 10);
			break;
		}
		
		c.attack();
		

		
		
	}

}
