package com.dm.spring.board.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dm.spring.board.model.dao.BoardDao;
import com.dm.spring.board.model.vo.Attachment;
import com.dm.spring.board.model.vo.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public Board findByNo(int pk) {
		// 조회수 증가로직..
		Board b = dao.findByNo(session, pk);
		
		if (b != null) {
			int result = dao.updateBoardReadCount(session, pk);
			//if(result == 0) new RuntimeException(); 
		}
		
		
		return b;
	}


	@Override
	public int insertBoard(Board b) {
		int result = dao.insertBoard(session, b);
		
		log.debug("생성된 게시글 번호 {}", b.getBoardNo());
		
		if (result > 0 && b.getFiles() != null) {
			
			for(Attachment a : b.getFiles()) {
				a.setBoardNo(b.getBoardNo());
				result = dao.insertAttachment(session, a);
			}
			
		}
		
		return result;
	}


	@Override
	public int selectBoardCount() {
		// TODO Auto-generated method stub
		return dao.selectBoardCount(session);
	}
	
	
	
}
