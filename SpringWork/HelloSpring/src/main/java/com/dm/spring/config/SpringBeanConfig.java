package com.dm.spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dm.spring.model.vo.Food;
import com.dm.spring.model.vo.Person;
import com.dm.spring.model.vo.Phone;

// XML 파일과 유사한 기능을 하는 클래스
@Configuration
public class SpringBeanConfig {
	
	@Bean
	public Food food() {
		Food f = new Food();
		f.setName("햄버거");
		f.setPrice(10000);
		
		return f;
	}
	
	@Bean
	@Qualifier("p")
	public Phone phone2() {
		return new Phone("아이폰", "01054542211");
	}
}
