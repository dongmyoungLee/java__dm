package com.bs.variable;

import java.util.Scanner;

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
		
		System.out.printf("오늘 %s 수업은 %d 점 %f입니다. \n", "java", 80, 54.3);
		// %5s -> 5칸확보 
		// %-5s -> 앞자리부터 5칸확보, %.2f -> 소수점 2자리표현
		System.out.printf("오늘 %5s 수업은 %3d 점 %.2f입니다.\n", "java", 80, 54.3);
		
		// 문자열에  escape 문 출력하기
		// 개행, 자바사용하는 기호를 사용, 특정공간을 띄우는 것
		
		// 개행 : \n
		// tap : \t
		// 역슬러쉬 : \\
		// 큰따옴표 : \"
		// 작은따옴표 : \'
		
		String temp = "안녕\n 오늘 첫 수업이었어 \t\t 다들 열심히 듣는 것 같아. \"호호\"";
		System.out.println(temp);
		temp = "다운로드 경로 : c:\\Users\\user";
		System.out.println(temp);
		
		temp = "<p onclick=\"alert(\'test\')\">이거클릭해봐</p>";
		System.out.println(temp);
		
		// 사용자가 키보드에 입력하는 데이터 받아오는 방법
		// 1. import java.util.Scanner; 선언
		// 2. Scanner sc = new Scanner(System.in);
		// 3. 입력받을 데이터의 자료형에 맞춰서 입력을 받기 -> 이용하는 사람으로 부터...
		// 4. 입력받은 내용을 사용자에게 출력..
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 ?: ");
		int age2 = sc.nextInt();
		//System.out.println(age2);
		
		System.out.print("키 ?: ");
		double height = sc.nextDouble();
		
		
		// sc.next() : 입력받는 값에 띄어 쓰기가 없는경우
		// sc.nextLine() : 입력받는 값에 띄어쓰기가 있는 경우
 		
		System.out.print("주소 ?: ");
		sc.nextLine();
		// nextLine() 쓸 경우엔 nextLine 이 아닌 다른 메소드를 nextLine이 나오기 전에 실행했다면 sc.nextLine(); 을 선언해서 buffer 를 비워줘야 함..
		String address = sc.nextLine();
		System.out.println("나이는 " + age2 + " 키는 " +  height + " 주소는 " + address);
		
		
		
	}
	
}
