package com.dm.spring.mvctest;

import org.springframework.stereotype.Service;

@Service
public class MvcTestService {
	
	private MvcTestDao dao;
	
	
	public MvcTestService(MvcTestDao dao) {
		this.dao = dao;
	}
	
	
	public void mvcTest() {
		System.out.println("service 실행");
		dao.mvcTest();
	}
}
