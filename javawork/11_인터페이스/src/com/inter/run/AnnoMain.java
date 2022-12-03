package com.inter.run;

import com.inter.common.BasicInterface;
import com.inter.common.TestLambda;

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
		
		// 인터페이스에 선언된 추상메소드가 한개인것은 functional 인터페이스이다..
		// 람다표현식을 적용할 수 있음.. (화살표함수랑 같음)
		
		TestLambda tl = new TestLambda() {
			@Override
			public String checkStr(String str, char ch) {
				return str;
			}
		};
		
		// Lambda 식으로 다시 재정의..
		tl = (str, ch) -> "안녕";
		
		// Lambda 식으로 다시 재정의..
		tl = (str, ch) -> {
			int index = 1;
			
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ch) {
					return "있다";
				}
			}
			
			return "없다";
		};
		
		System.out.println(tl.checkStr("banana", 'q'));
		
		
	}
}
