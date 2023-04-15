package com.dm.spring.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.dm.spring.board.model.vo.Attachment;
import com.dm.spring.board.model.vo.Board;

public interface BoardDao {
	List<Board> boardList(SqlSessionTemplate session, int cPage, int numPerpage);
	
	int insertBoard(SqlSessionTemplate session, Board b);
	
	int insertAttachment(SqlSessionTemplate session, Attachment a);
	
	Board findByNo(SqlSessionTemplate session, int pk);
	
	int selectBoardCount(SqlSessionTemplate session);
	
	int updateBoardReadCount(SqlSessionTemplate session, int pk);
}
