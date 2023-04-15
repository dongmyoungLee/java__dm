package com.dm.spring.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.dm.spring.board.model.vo.Attachment;
import com.dm.spring.board.model.vo.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Override
	public List<Board> boardList(SqlSessionTemplate session, int cPage, int numPerpage) {
		// TODO Auto-generated method stub

		RowBounds rb = new RowBounds((cPage-1)*numPerpage ,numPerpage);
				
		return session.selectList("board.boardList", null, rb);
	}

	@Override
	public int insertBoard(SqlSessionTemplate session, Board b) {
		// TODO Auto-generated method stub
		return session.insert("board.insertBoard", b);
	}

	@Override
	public int selectBoardCount(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectOne("board.boardCount");
	}

	@Override
	public int updateBoardReadCount(SqlSessionTemplate session, int pk) {
		// TODO Auto-generated method stub
		return session.update("board.updateReadCount", pk);
	}

	@Override
	public int insertAttachment(SqlSessionTemplate session, Attachment a) {
		// TODO Auto-generated method stub
		return session.insert("board.insertAttachment", a);
	}

	@Override
	public Board findByNo(SqlSessionTemplate session, int pk) {
		// TODO Auto-generated method stub
		return session.selectOne("board.findByNo", pk);
	}
	
	
}
