package com.dm.spring.demo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.dm.spring.demo.model.vo.Demo;

public interface DemoDao {
	int insertDemo(SqlSessionTemplate session, Demo demo);
	
	List<Demo> selectDemoAll(SqlSessionTemplate session);
}
