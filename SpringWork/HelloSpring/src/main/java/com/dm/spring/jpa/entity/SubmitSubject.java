package com.dm.spring.jpa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@SequenceGenerator(name = "seq_submitSubjectNo", sequenceName = "seq_submitSubjectNo", initialValue = 1, allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
//복합키 설정..
@IdClass(StudentSubjectId.class)
public class SubmitSubject {

	
	@Id
	@ManyToOne
	@JoinColumn(name="student_no")
	private Student student;
	
	@Id
	@ManyToOne
	@JoinColumn(name="subject_no")
	private Subject subject;
	
	private Date submitDate;
	
}
