package com.mybatis.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
	private int studentNo;
	private String name;
	private String phone;
	private String email;
	private String address;
}
