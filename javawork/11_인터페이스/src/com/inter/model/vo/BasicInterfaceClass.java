package com.inter.model.vo;

import com.inter.common.BasicInterface;

public class BasicInterfaceClass implements BasicInterface {
	
	
	
	

	// 인터페이스에 선언된 추상메소드 모두 Override 해야 함
	@Override
	public void test() {
		System.out.println("인터페이스 재정의");
	}
	
	@Override
	public int calc(int x,int y) {
		
		return x + y;
	}
}
