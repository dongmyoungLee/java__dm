package com.dm.spring.jpa.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity // JPA가 알아서 table생성해줌
public class JpaTest {
	
	@Id // Primary key
	private long testNo;
	private String testName;
	private int testNumber;
	private Date testDate;
	private double testAvg;
	private String testMsg;
	
}
