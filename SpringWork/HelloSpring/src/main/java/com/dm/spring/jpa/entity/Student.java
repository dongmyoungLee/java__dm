package com.dm.spring.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "seq_studentNo", sequenceName = "seq_studentNo", initialValue = 1, allocationSize = 1)
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_studentNo")
	private Long studentNo;
	private String studentName;
	private Integer grade;
	private Integer classNumber;
	private String gender;
	
	// 다른 클래스와의 연관관계를 표시하는 jpa 어노테이션!
	// @OneToOne,
	// @OneToMany,
	// @ManyToOne,
	// @ManyToMany,
}
