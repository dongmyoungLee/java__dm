package com.extra.controller;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.extra.common.Gender;
import com.extra.model.dao.StudentDao;
import com.extra.model.vo.Student;

public class StreamController {
	public static void main(String[] args) {
		// Stream 이용해서 데이터 정제하기
		// Collection 에 저장된 데이터를 가지고 활용을 많이 한다.
		
		List<Student> students = StudentDao.getStudents();
		System.out.println(students.size());
		
		for(Student s : students)  {
			//System.out.println(s);
		}
		
		//남학생 조회하기
		List<Student> menStudent = new ArrayList();
		List<String> wStudent = new ArrayList();
		/*
		for(Student s : students) {
			if(s.getGender() == Gender.M) {
				menStudent.add(s);
			}
		}
		*/
		//남학생 조회
		//menStudent.forEach(s -> System.out.println(s));
		//System.out.println(menStudent.size());
		
		System.out.println();
		
		// Stream 이용해서 처리하기..
		// filter 사용
		System.out.println();
		menStudent = students.stream()
				.filter(s -> s.getGender() == Gender.M)
				.filter(s -> s.getAge() > 40)
				.sorted((pre,next) -> pre.getAge() - next.getAge())
				.limit(3)
				.collect(Collectors.toList());
		
		menStudent.forEach(s -> System.out.println(s));
		
		
		// 여학생중 나이가 30세 이상인 학생의 이름만 조회
		// map() 메소드 : 반환하는 데이터를 종합
		// stream 타입이기 때문에 collect 이걸씀
		wStudent = students.stream().filter(s -> s.getGender() == Gender.F && s.getAge() >= 30)
									.map(s -> s.getName())
									.collect(Collectors.toList());
		//wStudent.forEach(s -> System.out.println(s));
		
		// 나이평균
		double ageAvg = students.stream().collect(Collectors.averagingDouble(s -> s.getAge()));
		System.out.println(ageAvg);
		
		// 키 평균
		double heightAvg = students.stream().collect(Collectors.averagingDouble(s -> s.getHeight()));
		System.out.println(heightAvg);
		
		// 나이에 대한 합계, 평균, 갯수를 구하는 메소드
		// Collectors.summarizingInt();
		IntSummaryStatistics iss = students.stream().collect(Collectors.summarizingInt(s -> s.getAge()));
		System.out.println(iss.getAverage());
		System.out.println(iss.getSum());
		System.out.println(iss.getMax());
		
		// 데이터를 구룹별로 종합
		// 학생을 나이대별 집계하기
		Map<String, List<Student>> studentGroup = students.stream()
				.collect(Collectors.groupingBy(s -> {
					if(s.getAge() >= 10 && s.getAge() < 20) {
						return "10대";
					}
					else if(s.getAge() >= 20 && s.getAge() < 30) {
						return "20대";
					}
					else if(s.getAge() >= 30 && s.getAge() < 40) {
						return "30대";
					}
					else if(s.getAge() >= 40 && s.getAge() < 50) {
						return "40대";
					}
					else if(s.getAge() >= 50 && s.getAge() < 60) {
						return "50대";
					}
					else {
						return "고령자";
					}
				}));
		
		for(Map.Entry<String, List<Student>> entry : studentGroup.entrySet()) {
			if(entry.getKey().contains("30")) {
				for(Student s : entry.getValue()) {
					System.out.println(s);
				}
			}
		}
		
		// 병렬처리
		//students.parallelStream()
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
