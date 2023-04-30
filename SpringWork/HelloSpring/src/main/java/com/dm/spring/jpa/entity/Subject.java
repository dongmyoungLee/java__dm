package com.dm.spring.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "seq_subjectNo", sequenceName = "seq_subjectNo", initialValue = 1, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Subject {
	
	@Id
	@GeneratedValue(generator = "seq_subjectNo", strategy = GenerationType.SEQUENCE)
	private Long subjectNo;
	private String subjectName;
	private String teacherName;
	
	/*
	@ManyToMany(mappedBy = "subjects")
	List<Student> students;
	*/
	
	@OneToMany(mappedBy = "subject")
	private List<SubmitSubject> submitSubject;
	
}
