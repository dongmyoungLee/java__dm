package com.dm.spring.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.spring.demo.model.dao.DemoDao;
import com.dm.spring.demo.model.vo.Demo;

@Service
public class DemoServiceImpl implements DemoService {
	
	private DemoDao dao;
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	public DemoServiceImpl(DemoDao dao, SqlSessionTemplate session) {
		this.dao = dao;
		this.sqlSession = session;
	}
	
	@Override
	public int insertDemo(Demo demo) {
		// TODO Auto-generated method stub
		return dao.insertDemo(sqlSession, demo);
	}

	@Override
	public List<Demo> selectDemoAll() {
		// TODO Auto-generated method stub
		return dao.selectDemoAll(sqlSession);
	}

}
