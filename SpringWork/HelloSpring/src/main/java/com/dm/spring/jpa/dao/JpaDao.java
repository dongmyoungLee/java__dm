package com.dm.spring.jpa.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.dm.spring.jpa.common.MemberLevel;
import com.dm.spring.jpa.entity.Dev;
import com.dm.spring.jpa.entity.JpaMember;
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
	
	public JpaMember insertJpa(EntityManager em) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		JpaMember jm = null;
		
		for(int i = 0; i < 10; i++) {
				jm = JpaMember.builder()
					.memberId("test" + i)
					.memberPwd("1234")
					.age(10 + i)
					.height(180.5 + i)
					.memberLevel(MemberLevel.PRETINUM)
					.enrollDate(new Date(System.currentTimeMillis())).build();
			em.persist(jm);
		}
		
		et.commit();
		
		return jm;
	}
	
	public JpaMember searchMemberByNo(EntityManager em, int no) {
		// Entitiy DB 에서 조회할때는 EntitiyManager가 제공하는 메소드를 이용해서 조회..
		// 단 EntityManager 가 기본적으로 제공하는 메소드는 pk 값을 기준으로 한개의 row만 조회하는 기능임
		
		JpaMember m = em.find(JpaMember.class, Long.valueOf(no));
		return m;
	}
	
	public List<JpaMember> searchAllMember(EntityManager em) {
		// 다수의 row를 조회해보자..
		// EntityManager 에서는 다수의 row를 조회하는 구문을 제공하지 않는다..
		// JPQL 구문을 이용해서 직접 SQL문을 작성하고 그 결과를 받아와야함..
		// EntityManager 가 제공하는 createQuery("JPQL") 함수를 이용해서 작성을 함..
		
		Query sql = em.createQuery("select m from JpaMember m", JpaMember.class);
		// Query 클래스에서 제공하는 getResultList() 메소드를 이용..
		return sql.getResultList();
	}
	
	public Dev searchDev(EntityManager em) {
		
		return em.find(Dev.class, 1);
	}
}














