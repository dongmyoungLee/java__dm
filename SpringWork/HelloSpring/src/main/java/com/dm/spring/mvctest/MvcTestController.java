package com.dm.spring.mvctest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcTestController {
	private MvcTestService service;
	
	public MvcTestController(MvcTestService service) {
		this.service = service;
	}
	
	@RequestMapping("/mvctest")
	public String mvcTest() {
		service.mvcTest();
		return "test";
	}
}
