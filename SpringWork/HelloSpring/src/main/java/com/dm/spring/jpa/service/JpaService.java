package com.dm.spring.jpa.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.spring.jpa.dao.JpaDao;
import com.dm.spring.jpa.entity.Dev;
import com.dm.spring.jpa.entity.JpaMember;
import com.dm.spring.jpa.entity.JpaTest;

@Service
public class JpaService {
	
	private JpaDao dao;
	private EntityManager manager;
	
	@Autowired
	public JpaService(JpaDao dao, EntityManager manager) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
		this.manager = manager;
		
	}
	
	
	public JpaTest basicTest() {
		return dao.basictest(manager);
	}
	
	public JpaMember insertJpa() {
		return dao.insertJpa(manager);
	}
	
	public JpaMember searchMemberByNo(int no) {
		return dao.searchMemberByNo(manager, no);
	}
	
	public List<JpaMember> searchAllMember() {
		return dao.searchAllMember(manager);
	}
	
	public Dev searchDev() {
		return dao.searchDev(manager);
	}
	
	public List<JpaMember> searchMemberBy(int age) {
		return dao.searchMemberBy(manager, age);
	}
	
	public void insertMember(JpaMember m) {
		// jpa 에서 DML (INSERT, UPDATE, DELETE) 구문을 실행할 때
		// 트랜잭션으로 관리해줘야함. COMMIT, ROLLBACK -> 영속성 컨텍스트에 저장된 내용을 DB에 반영
		// (flush() -> commit() 메소드를 호출하면 실행됨)
		EntityTransaction transaction = manager.getTransaction();
		
		// 트랜잭션 시작하기 -> begin() 메소드를 이용
		transaction.begin();
		dao.insertMember(manager, m);
		transaction.commit(); // flush() 메소드 호출
	}
	
	public void updateMember(Map param) {
		 EntityTransaction et=manager.getTransaction();
	     et.begin();
	     JpaMember m = dao.searchMemberByNo(manager, Integer.parseInt((String)param.get("memberNo")));
	     dao.updateMember(manager,m,param);
	     et.commit();   
	}
	
	public void deleteMember(int memberNo) {
		EntityTransaction et = manager.getTransaction();
		et.begin();
		JpaMember deleteMember = dao.searchMemberByNo(manager, memberNo);
		dao.deleteMember(manager, deleteMember);
		et.commit();
	}
	
	public void insertOneToOneData() {
		EntityTransaction et = manager.getTransaction();
		et.begin();
		dao.insertOneToOneData(manager);
		et.commit();
	}
}








