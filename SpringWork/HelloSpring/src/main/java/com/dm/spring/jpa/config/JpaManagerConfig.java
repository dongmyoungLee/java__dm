package com.dm.spring.jpa.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaManagerConfig {
	// jpa를 이용해서 DB를 이용하려면 jpa가 제공하는 EntityManager 클래스를 생성해야 한다.

	// Persistence 클래스의 createEntityManagerFactory() static 메소드를 이용해서 EntityManagerFactory클래스를 먼저 생성함..
	// -> 매개변수로 persistence.xml 에 설정한 persistence-unit name 값을 전달한다.

	// EntityManagerFactory 클래스가 제공하는 createEntityManager() 메소드를 이용해서 EntityManager 클래스를 생성함.
	
	// EntityManagerFactory를 생성하는 과정은 비용이 크기 때문에 애플레케이션에서 한번만 생성하는게 좋다.
	
	
	
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		// persistence.xml 에 설정한 name 값으로 Factory를 생성
		// resources/META-INF/persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dmtest");
		
		return emf;
	}
	
	@Bean
	public EntityManager entityManager() {
		
		return entityManagerFactory().createEntityManager();
	}
}







