package com.dm.spring.demo.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Demo {
	private String devName;
	private int devAge;
	private String devGender;
	private String devEmail;
	private String[] devLang;
}
