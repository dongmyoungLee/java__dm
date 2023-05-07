package com.dm.springboot.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dm.springboot.dao.JpaBoardDao;
import com.dm.springboot.dao.JpaMemberDao;
import com.dm.springboot.model.entity.JpaBoard;
import com.dm.springboot.model.entity.JpaMember;

@Service
public class JpaServiceImpl implements JpaService {
	
	
	private JpaMemberDao dao;
	private JpaBoardDao dao2;
	
	@Autowired
	public JpaServiceImpl(JpaMemberDao dao, JpaBoardDao dao2) {
		this.dao = dao;
		this.dao2 = dao2;
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
	
	// 페이징처리한 데이터 가져오기
	@Override
	public Page<JpaMember> selectMemberPage() {
		// TODO Auto-generated method stub
		return dao.findAll(PageRequest.of(0, 5, Sort.by("userId").descending()));
	}

	
	@Override
	public List<JpaMember> selectMemberByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByUserNameLike("%" + name + "%");
	}

	@Override
	public List<JpaBoard> selectBoardAll() {
		// TODO Auto-generated method stub
		return dao2.findAll();
	}

	
	@Override
	public JpaBoard selectBoard(Long id) {
		// TODO Auto-generated method stub
		return dao2.findById(id).orElse(JpaBoard.builder().build());
	}

	@Override
	public List<JpaBoard> selectBoardByContent(String keyword) {
		// TODO Auto-generated method stub
		return dao2.findByBoardContentLike("%" + keyword + "%");
	}

}
