package com.dm.springboot.model.service;

import java.util.List;

import com.dm.springboot.model.entity.JpaBoard;
import com.dm.springboot.model.entity.JpaMember;

public interface JpaService {
	List<JpaMember> selectMemberAll();
	
	JpaMember selectMemberById(String id);
	
	List<JpaMember> selectMemberByName(String name);
	
	List<JpaMember> selectBoardAll();
	
	JpaMember insertMember(JpaMember member);
	
	JpaBoard selectBoard(Long id);
	
	List<JpaBoard> selectBoardByContent(String keyword);
	
	
}
