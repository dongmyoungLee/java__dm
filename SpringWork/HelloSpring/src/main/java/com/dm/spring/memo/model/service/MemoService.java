package com.dm.spring.memo.model.service;

import java.util.List;

import com.dm.spring.memo.model.vo.Memo;


public interface MemoService {
	List<Memo> selectMemoAll();
	
	int insertMemo(Memo m);
}
