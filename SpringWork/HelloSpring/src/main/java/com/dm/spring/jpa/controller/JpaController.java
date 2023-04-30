package com.dm.spring.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dm.spring.jpa.entity.JpaMember;
import com.dm.spring.jpa.entity.JpaTest;
import com.dm.spring.jpa.service.JpaService;

@Controller
public class JpaController {
	
	private JpaService service;
	
	public JpaController(JpaService service) {
		this.service = service;
	}
	
	@RequestMapping("/jpa/basicJpa")
	public @ResponseBody JpaTest testBasicJpa() {
		
		return service.basicTest();
	}
	
	@RequestMapping("/jpa/insertJpa")
	public @ResponseBody JpaMember insertJpa() {
		
		
		return service.insertJpa();
	}
	
	@RequestMapping("/jpa/member")
	public @ResponseBody JpaMember searchMember(int no) {
		
		return service.searchMemberByNo(no);
	}
}
