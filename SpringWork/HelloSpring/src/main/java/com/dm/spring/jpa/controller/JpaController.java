package com.dm.spring.jpa.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dm.spring.jpa.entity.Dev;
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
	
	@RequestMapping("/jpa/members")
	public @ResponseBody List<JpaMember> searchAllMember() {
		return service.searchAllMember();
	}
	
	@RequestMapping("/jpa/dev")
	public @ResponseBody Dev searchDev(int no) {
		return service.searchDev();
	}
}
