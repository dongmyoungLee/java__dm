package com.dm.spring.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;

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
}
