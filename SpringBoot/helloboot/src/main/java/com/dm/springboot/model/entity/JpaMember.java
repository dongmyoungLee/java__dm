package com.dm.springboot.model.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
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
@Table(name="member")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class JpaMember {
	
	@Id
	@Column(name="USERID")
	private String userId;
	
	private String password;
	
	@Column(name="USERNAME")
	private String userName;
	private String gender;
	private int age;
	private String email;
	private String address;
	private String hobby;
	
	@Column(name="ENROLLDATE")
	private Date enrollDate;
	
	@OneToMany(mappedBy = "writer")
	List<JpaBoard> boards;
}


