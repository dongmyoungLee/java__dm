package com.dm.spring.jpa.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity // JPA가 알아서 table생성해줌
@Table(name="jpa_test",
	uniqueConstraints = {@UniqueConstraint(name="uq_nameNumber",columnNames= {"testName", "testNumber"})})
@SequenceGenerator(name = "seq_jpaTest", sequenceName = "seq_jpaTest", initialValue = 1, allocationSize = 1)
/*
 * name : java 에서 사용하는 명칭
 * squenceName : 오라클에서 사용할 명칭
 * initialValue : 초기값 *기본 1(수정 가능)
 * allocationSize : cashe *기본 50
 * */
public class JpaTest {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_jpaTest")
	private long testNo;
	private String testName;
	private int testNumber;
	private Date testDate;
	private double testAvg;
	private String testMsg;
	
}
