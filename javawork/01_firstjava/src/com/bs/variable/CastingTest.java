package com.bs.variable;

public class CastingTest {
	public static void main(String[] args) {
		// 자동 형 변환
		// 자료형의 범위가 작은 것 에서 큰 것으로 저장 할때는 자동으로 변환을 해준다 ..
		// 산술연산 시 (+,-,*,/) 두개의 자료형이 다를 경우 더 큰자료형으로 자동변환을 해준다.
		
		int score = 80;
		double dscore = score;
		// 자동형변환 Casting 변환됨..
		//System.out.println(dscore);
		
		// double = 8byte, int = 4byte, 더 작은곳으로 옮길 수 없음.
		// int total = score + 10.2; -> type을 double로 받거나 강제 형변환을 해줘야함.
		double total = score + 10.2;
		//System.out.println(total);
		
		
		// 강제형변환
		// 데이터 손실을 주의해야한다.
		int num = 290;
		byte bnum = (byte)num;
		
		// 앞에있는 비트를 다 잘라서 데이터 손실이 발생했음
		//System.out.println(bnum);
		
		int kor,eng,math;
		kor = 90;
		eng = 100;
		math = 100;
		
		// 평균 (+,/)
		double result = ((double)kor + eng + math) / 3;
		// 원래 96.6666666667 이 나와야함..  그런데 int 형이기 때문에 소수점표현을 못함 -> 그걸 double 로 받았기 때문에 96.0 이 나옴.
		// 그래서 강제 형 변환을 해준다.
		//System.out.println(result);
		
		// char 의 형변환
		int chNum = 67;
		// 강제 변환함
		char ch = (char)chNum;
		//System.out.println(ch);
		
		chNum = 'C';
		//System.out.println(chNum);
		
		for(int i = 0; i < 20; i++) {
			//ascii 코드로 인해 출력이됨.
			//System.out.println((char)chNum++);
		}
		// 객체의 다형성을 활용할 때 많이 사용을 한다 .
		
		// System.out.printf() 활용하기
		// 출력 양식을 문자열로 작성하고 값이 대입되는 부분에는 지정된 문구를 대입함
		// 나의 이름은 %s 나이는 %d
		
		//System.out.printf("나의 이름은 %s 나의 나이는 %d 입니다", "이동명", 28);
		
		// 문자열 : %s
		// 정수 : %d
		// 실수 : %f
		// 문자 : %c
		
		System.out.printf("오늘 %s 수업은 %d 점 입니다.", "java", 80);
		
		
	}
	
}
