package com.dm.spring.memo.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.dm.spring.memo.model.dao.MemoDao;
import com.dm.spring.memo.model.vo.Memo;

@Service
public class MemoServiceImpl implements MemoService {
	private MemoDao dao;
	private SqlSessionTemplate session;
	
	public MemoServiceImpl(MemoDao dao, SqlSessionTemplate session) {
		super();
		this.dao = dao;
		this.session = session;
	}

	@Override
	public List<Memo> selectMemoAll() {
		// TODO Auto-generated method stub
		return dao.selectMemoAll(session);
	}

	@Override
	public int insertMemo(Memo m) {
		// TODO Auto-generated method stub
		return dao.insertMemo(session, m);
	}

}
