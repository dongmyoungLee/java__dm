package com.inter.model.vo;

import com.inter.common.BasicInterface;
import com.inter.common.BasicInterface2;

// 쉼표써서 인터페이스 다중구현 가능..
public class BasicInterfaceClass implements BasicInterface, BasicInterface2 {
	
	
	
	

	// 인터페이스에 선언된 추상메소드 모두 Override 해야 함
	@Override
	public void test() {
		System.out.println("인터페이스 재정의");
	}
	
	@Override
	public int calc(int x,int y) {
		
		return x + y;
	}
	
	@Override
	public String sum(String str1, String str2) {
		
		return str1 + str2;
	}
	
	@Override
	public boolean result(String str) {
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				return true;
			}
		}
		
		return false;
	}
}
