package com.dm.spring.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dm.spring.jpa.common.MemberLevel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="jpa_member")
@SequenceGenerator(name = "seq_jpaMember", sequenceName = "seq_jpaMember", initialValue = 1, allocationSize = 1)
public class JpaMember {
	/*
	 컬럼에 대한 설정을 하는 어노테이션 -> 필드 선언부에 선언 
	 @Id : 아래 필드를 pk 컬럼으로 사용 설정 * 한개의필드에 반드시생성
	 @GeneratedValue : 기본키의 값을 자동생성해서 부여하게 하는 설정
	   sequence 와 연동하여 처리하는데 DB마다 설정하는것이 다름
	   속성
	   
	   strategy(전략) :
		   GenerationType.IDENTITY : auto_increment 기능을 쓸수있는 DB에서는 씀, * mssql,mysql,maria,postgre
		   GenerationType.SEQUENCE : sequence 객체를 이용해서 부여, * oracle, postgreSQL
		   GenerationType.TABLE : 전체 다 적용 별도의 Sequence 테이블을 생성해서 활용
 		   GenerationType.AUTO : 설정한 방언 전략 방식에 따라서 자동으로 결정.
 		   
 	   generator : 선언한 sequnceGenerator name을 설정함
	 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_jpaMember")
	private Long memberNo;
	
	// @Column : 필드와 매핑되는 테이블컬럼을 설정하는 어노테이션
	// 속성
	// name : 필드와 매핑될 컬럼의 이름 설정
	// insertTable : true(default), false /  false면 필드값을 DBㅇ에 저장하지 않는 설정
	// updateTable : 수정시 수정을 하지 않는 것 true(default), false
	// nullable : 컬럼에 null 제약조건 설정 true : null, false : not null
	// unique : 컬럼에 unique 제약조건 설정 true: 설정, false: 미설정
	// columnDefinition : 컬럼에 대한 종합적인 설정 DB에서 컬럼설정한내용을 작성함
	// 예 ) "varchar2(200) not null default "tt"
	// length : 문자열 길이에 대한 설정
	// precision : Number형에 대한 전체 자리수 설정
	// scale : number 형에 대한 소수점 자리수 설정
	
	@Column(name="member_id", nullable = false, unique = true, length = 50)
	private String memberId;
	
	@Column(name="member_pwd", columnDefinition = "varchar2(80) not null")
	private String memberPwd;
	
	@Column(name="age", precision = 20, scale = 0)
	private Integer age;
	
	@Column(insertable = false)
	private double height;
	
	// 컬럼타입을 설정하는 어노테이션
	// @Enumerated : java의 EnumType과 매핑할때 사용하는 어노테이션
	// 속성
	// value
	//	EnumType.ORDINAL : DB에 저장할때 Enum의 숫자를 저장
 	//  EnumType.String : DB에 저장할때 Enum의 문자열을 저장 * 권장
	// @Temporal : java 의 Date 타입과 매필할때 사용하는 어노테이션
	// 속성 : value
	//			TemporalType.DATE : DB에 DATE타입과 매핑해서 저장
	//          TemporalType.TIMESTAMP : DB에 TIMESTAMP 타입과 매핑해서 저장
	// @Lob : DB의 blob, clob 타입으로 저장할때 사용하는 어노테이션
	// 필드타입에 따라서 blob, clob 이 결정이된다.
	// String, String[] : clob
	// byte[] : blob
	
	@Enumerated(value = EnumType.STRING)
	private MemberLevel memberLevel; 
	
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date enrollDate;
	
	@Lob
	private String info;
	
	@Lob
	private byte[] data;
 }


















