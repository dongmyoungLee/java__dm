package com.inter.run;

import com.inter.common.BasicInterface;

public class AnnoMain {
	public static void main(String[] args) {
		// 인터페이스 익명 클래스 이용하기
		// 1회로 이용할건데 implements 선언하고 거기서 선언한 method를 쓰고 있는 class 또 생성하고 하기 귀찮음
		BasicInterface bif = new BasicInterface() {
			
			@Override
			public void test() {
				
			}
			
			@Override
			public int calc(int x, int y) {
				return x * y;
			}
			
		};
		
		// 사용가능
		bif.test();
		System.out.println(bif.calc(20, 10));
	}
}
