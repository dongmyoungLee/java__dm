package com.dm.spring.model.service;

import java.util.List;

import com.dm.spring.demo.model.vo.Demo;

public interface DemoService {
	
	int insertDemo(Demo demo);
	
	List<Demo> selectDemoAll();
}
