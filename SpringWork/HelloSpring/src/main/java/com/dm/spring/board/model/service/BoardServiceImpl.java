package com.dm.spring.board.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.spring.board.model.dao.BoardDao;
import com.dm.spring.board.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardDao dao;
	private SqlSessionTemplate session;
	
	@Autowired
	public BoardServiceImpl(BoardDao dao, SqlSessionTemplate session) {
		super();
		this.dao = dao;
		this.session = session;
	}
	
	
	@Override
	public List<Board> boardList(int cPage, int numPerpage) {
		// TODO Auto-generated method stub
		return dao.boardList(session, cPage, numPerpage);
	}

	@Override
	public int findByNo(int pk) {
		// TODO Auto-generated method stub
		return dao.findByNo(session, pk);
	}


	@Override
	public int insertBoard(Board b) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int selectBoardCount() {
		// TODO Auto-generated method stub
		return dao.selectBoardCount(session);
	}
	
	
	
}
