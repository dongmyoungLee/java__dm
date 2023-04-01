package com.dm.spring.model.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
// 어노테이션으로 spring bean 등록
@Component("food")
public class Food {
	private String name;
	private int price;	
}
