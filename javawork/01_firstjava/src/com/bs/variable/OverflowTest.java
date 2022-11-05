package com.bs.variable;

public class OverflowTest {
	
	public static void main(String[] args) {
		// 데이터 오버플로우 현상
		// 값의 범위를 넘어서 계산이 된 경우 예상과 다른 값이 출력되는 것.
		byte bnum = 100;
		
		// 127 에서 1이 부호비트로 넘어가서 -128로 변환함. 따라서 음수계산식으로 계산이 됨. 127 + 1 = -128 으로 현상이 발생함. 해결법은 타입 변경.
		for (int i = 0; i < 200; i++) {
			bnum++;
//			System.out.println(bnum);
		}
		
		// 강제형변환
		double d = 3.14;
		int a = 4;

		System.out.println((int)d - a);

		
		
		
		
		
		
		
//		<=$:{.@qwertyuioplkjhgfdsazxcvbnm_QWERTYUIOPLKJHGFDSAZXCVBNM
// 자동완성 코드
		
	}
	
}
