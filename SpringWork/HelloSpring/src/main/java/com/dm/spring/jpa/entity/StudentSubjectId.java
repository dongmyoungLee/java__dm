package com.dm.spring.jpa.entity;

import java.io.Serializable;

import lombok.Data;

// 조건
// 복합키를 식별하게 해주는 클래스
// 1. 기본생성자
// 2. 클래스가 public 접근제한자를 사용해야함..
// 3. Serilizable 인터페이스 구현
// 4. equals, hashcode 메소드가 오버라이딩 되어있어야한다.

@Data
public class StudentSubjectId implements Serializable {

	private static final long serialVersionUID = 1309711942751740662L;
	
	// 복합키로 사용하는 내용을 필드로 선언함.
	private Long student;
	private Long subject;
	
}
