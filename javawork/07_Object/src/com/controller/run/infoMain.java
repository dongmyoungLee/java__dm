package com.controller.run;

import com.obj.model.vo.Score;

public class infoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Score th = new Score();
		
		th.setMath(70);
		th.setKor(90);
		th.setEng(100);
		th.setCoding(100);
		
		/*
		System.out.println(th.getMath());
		System.out.println(th.getKor());
		System.out.println(th.getEng());
		System.out.println(th.getCoding());
		*/
		
		//th.infoScorePrint();
		//System.out.println(th.infoScore());
		
		
		Score sh = new Score("123");
		sh.setMath(51);
		sh.setKor(27);
		sh.setEng(15);
		sh.setCoding(59);
		
		//System.out.println(sh.getStudentId());
		//System.out.println(sh.infoScore());
		
		//합계반환
		th.sum();
		sh.sum();
		
		//평균반환
		th.average();
		sh.average();
		
		
		// 자동차를 관리하는 클래스 만들기
		// 제조사, 년식(년도, int), 명칭, 탑승인원, 배기량, 색상
		// 3개의 객체를 생성 검색해서 데이터를 대입할 것
		// 1. 객체는 매개변수에 있는 생성자로 사용
		// 2~3 객체는 setter를 이용해서 생성
		// 저장된 데이터 출력
		
		
		// 학생 관리 프로그램 (MVC)
		// 1. 학생등록
		// 2. 학생조회
		// 3. 이름조회
		// 4. 학년조회
		// 5. 학생수정
		// 6. 학생삭제
		// 7. 프로그램 종료
		
		
	}

}
