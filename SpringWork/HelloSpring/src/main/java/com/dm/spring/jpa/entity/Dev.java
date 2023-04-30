package com.dm.spring.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Dev")
public class Dev {
	@Id
	private int devNo;
	private String devName;
	private int devAge;
	private String devEmail;
	private String devGender;
	private String devLang;
}
