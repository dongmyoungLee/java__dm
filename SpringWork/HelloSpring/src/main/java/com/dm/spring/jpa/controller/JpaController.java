package com.dm.spring.jpa.controller;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
