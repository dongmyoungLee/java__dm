package com.dm.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dm.spring.board.model.service.BoardService;
import com.dm.spring.board.model.vo.Board;
import com.dm.spring.common.PageBarFactory;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {
	private BoardService service;
	
	@Autowired
	public void setService(BoardService service) {
		this.service = service;
	}
	
	@RequestMapping("/boardList.do")
	public String boardList(
			@RequestParam(value="cPage", defaultValue="1") int cPage,
			@RequestParam(value="numPerpage", defaultValue="10") int numPerpage,
			Model m
			) {
		
		/* paging 값 안넘겨주면 exception 처리 되므로 default 넣어주자.. */
		
		int totalData = service.selectBoardCount();
		
		List<Board> boards = service.boardList(cPage, numPerpage);
		
		m.addAttribute("boards", boards);
		m.addAttribute("totalContents", totalData);
		m.addAttribute("pageBar", PageBarFactory.getPageBar(cPage, numPerpage, totalData, "boardList.do"));
		
		return "board/board";
	}
	
	
}
