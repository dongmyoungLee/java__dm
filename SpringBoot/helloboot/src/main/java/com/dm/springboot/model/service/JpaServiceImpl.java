package com.dm.springboot.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dm.springboot.dao.JpaMemberDao;
import com.dm.springboot.model.entity.JpaBoard;
import com.dm.springboot.model.entity.JpaMember;

@Service
public class JpaServiceImpl implements JpaService {
	
	
	private JpaMemberDao dao;

	public JpaServiceImpl(JpaMemberDao dao) {
		this.dao = dao;
	}
	
	@Override
	public List<JpaMember> selectMemberAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public JpaMember selectMemberById(String id) {
		// null 이면 JpaMember 빈객체로 반환
		return dao.findById(id).orElse(JpaMember.builder().build());
	}
	
	@Override
	public JpaMember insertMember(JpaMember member) {
		// TODO Auto-generated method stub
		return dao.save(member);
	}
	
	@Override
	public List<JpaMember> selectMemberByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByUserNameLike("%" + name + "%");
	}

	@Override
	public List<JpaMember> selectBoardAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public JpaBoard selectBoard(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JpaBoard> selectBoardByContent(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}