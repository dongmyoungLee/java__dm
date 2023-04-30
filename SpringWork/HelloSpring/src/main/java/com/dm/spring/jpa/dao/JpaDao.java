package com.dm.spring.jpa.dao;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Repository;

import com.dm.spring.jpa.common.MemberLevel;
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

}
