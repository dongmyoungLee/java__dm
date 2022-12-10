package com.api.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateController {
	public static void main(String[] args) {
		// 날짜를 처리하는 클래스
		// java.util.Date 클래스 -> 일반 자바 사용
		// java.sql.Date 클래스 -> DB와 연결된 사용 날짜 타입
		// Calendar, GregodianCalendar 클래스를 이용
		
		// 8버전 이상 java
		// LocalDate, LocalTime, LocalDateTime 클래스 이용함
		
		// 현재날짜
		Date today = new Date();
		System.out.println(today);
		// 사용 ㄴ
		//today = new Date(2022,12,10);
		
		today = new Date(1671554866511L);
		System.out.println(today);
		
		//Calendar 클래스 이용하기
		//Calendar 는 추살클래스로 자체 생성이 불가능하다.
		//Calendar 클래스는 calendar 클래스를 생성해주는 메소드 이용
		
		// 현재날짜
		Calendar c = Calendar.getInstance();
		
		// 날짜를 출력할때는 Calendar 의 값에 접근해서 출력해야한다.
		/*
		System.out.println(c.get(Calendar.YEAR) + "년");
		System.out.println((c.get(Calendar.MONTH)+1) + "월");
		System.out.println(c.get(Calendar.DATE) + "일");
		System.out.println(c.get(Calendar.HOUR) + "시");
		System.out.println(c.get(Calendar.MINUTE) + "분");
		System.out.println(c.get(Calendar.SECOND) + "초");
		*/
		
		// 원하는날짜 저장하기
		Calendar birthDay = Calendar.getInstance();
		birthDay.set(Calendar.YEAR, 1992);
		birthDay.set(Calendar.MONTH, (3-1));
		birthDay.set(Calendar.DATE, 45);
		
		System.out.println(birthDay.get(Calendar.YEAR));
		
		// GregorianCalendar
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.get(Calendar.YEAR));
		
		// 생성과 동시에 날짜를 설정
		gc = new GregorianCalendar(1998,2,26);
		System.out.println(gc.get(Calendar.YEAR));
		
		// 날짜형 데이터를 원하는 형식의 문자열로 변경해주는 클래스..
		// SimpleDateFormat
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 DD일");
		
		String result = sdf.format(today);
		
		System.out.println(result);
		
		// GregorianCalendar 를 Date 클래스로 변환하기
		// new Date(long); -> GregorianCalendar long을 변환해주는 메소드 이용
		Date changeDate = new  Date(gc.getTimeInMillis());
		result = sdf.format(changeDate);
		System.out.println(result);
		
		// front 에서  날짜를 전달하게 되면 문자열로 전송이 된다.
		// 문자열 형식 : 년-월-일 예) 2022-12-10
		String d = "2022-12-10";
		String[] dayData = d.split("-");
		System.out.println(dayData[0]);
		System.out.println(dayData[1]);
		System.out.println(dayData[2]);
		
		GregorianCalendar webDate = new GregorianCalendar(
				Integer.parseInt(dayData[0]),
				Integer.parseInt(dayData[1])-1,
				Integer.parseInt(dayData[2]));
		
		// SimpleDateFormat 에서 제공하는 메소드를 이용할 수 있음.
		// parse() 메소드
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			today = sdf2.parse(d);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(sdf.format(today));
		
		
		// 8버전 이후 날짜를 처리하는 클래스
		// LocalDate, LocalTime, LocalDateTime
		// 생성하기
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		// 원하는 날짜를 셋팅하기
		ld = LocalDate.of(2022, 8, 25);
		System.out.println("년 : " + ld.getYear());
		System.out.println("월 : " + ld.getMonthValue());
		System.out.println("일 : " + ld.getDayOfMonth());
		
		// 시간
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		
		// 날짜 + 시간
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		ldt = LocalDateTime.of(ld, lt);
		System.out.println(ldt);
		
		ld = LocalDate.parse("1998-03-05");
		System.out.println(ld);
		
		// 날짜사이 기간을 계산해주는 메소드. (년월일 가능)
		// ChronnoUnit ㄴ
		long between = ChronoUnit.DAYS.between(LocalDate.of(2022, 12, 1), LocalDateTime.now());
		System.out.println(between);
		
		// DB time 을 위해 자주 사용함.
		// LocalDateTime 을 Date 로 변환하기
		Date temp = java.sql.Date.valueOf(LocalDate.now());
		System.out.println(temp);
		java.sql.Timestamp temp2 = java.sql.Timestamp.valueOf(ldt);
		System.out.println(temp2);
		
		// Date를 LocalDate, LocalDateTime 으로 변경
		LocalDate ld2 = new java.sql.Date(temp.getTime()).toLocalDate();
		LocalDateTime ldt2 = new java.sql.Timestamp(temp2.getTime()).toLocalDateTime();
		System.out.println(ld2);
		System.out.println(ldt2);
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
