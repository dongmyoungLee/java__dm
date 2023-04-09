package com.dm.spring.memo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.dm.spring.memo.model.vo.Memo;

public interface MemoDao {
	List<Memo> selectMemoAll(SqlSessionTemplate session);
	
	int insertMemo(SqlSessionTemplate session, Memo m);
}
