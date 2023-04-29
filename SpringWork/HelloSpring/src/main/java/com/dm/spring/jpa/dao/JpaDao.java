package com.dm.spring.jpa.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.dm.spring.jpa.entity.JpaTest;

@Repository
public class JpaDao {
	
	public JpaTest basictest(EntityManager em) {
		// jpa가 제공하는 EntityManager 를 이용해서 DB에 있는 데이터 조회하기
		// pk 값을 기준으로 한개의 row를 조회할 수 있다.
		// EntityManager 는 조회하는 메소드를 제공한다.
		// find()
		
		return em.find(JpaTest.class, 1L);
	}
}
