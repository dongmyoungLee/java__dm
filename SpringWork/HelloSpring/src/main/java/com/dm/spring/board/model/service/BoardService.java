package com.dm.spring.board.model.service;

import java.util.List;

import com.dm.spring.board.model.vo.Board;

public interface BoardService {
	List<Board> boardList(int cPage, int numPerpage);
	
	int insertBoard(Board b);
	
	Board findByNo(int pk);
	
	int selectBoardCount();
}
