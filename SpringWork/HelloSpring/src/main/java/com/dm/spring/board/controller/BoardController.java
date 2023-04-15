package com.dm.spring.board.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dm.spring.board.model.service.BoardService;
import com.dm.spring.board.model.vo.Attachment;
import com.dm.spring.board.model.vo.Board;
import com.dm.spring.common.PageBarFactory;
import com.dm.spring.member.model.vo.Member;

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
	
	@RequestMapping("/boardDetail.do")
	public String boardDetail(int pk, Model m) {
		
		
		m.addAttribute("board", service.findByNo(pk));
	
		
		return "board/boardDetail";
	}
	
	@RequestMapping("boardWrite.do")
	public String boardWrite() {
		
		return "board/boardWrite";	
	}
	
	@RequestMapping("/boardWriteEnd.do")
	public String insertBoard(MultipartFile[] upFile, String boardTitle, String boardContent, String boardWriter, HttpSession session, Model m) {

		//log.debug("{}", upFile.getName());
		//log.debug("{}", upFile.getSize());
		//log.debug("{}", upFile.getOriginalFilename());
		//log.debug(boardTitle + " " + boardContent + " " + boardWriter);
		
		// 파일 업로드 처리하기..

		
		// 1. 저장할 위치 선정 -> 절대경로 가져오기
		// session.getServletContext() -> src - webapp..
		String path = session.getServletContext().getRealPath("/resources/upload/board/");
	
		
		// 2. 저장할 위치가 있는지..? 확인하고 없으면 생성하기
		File dir = new File(path);
		
		if (!dir.exists()) {
			dir.mkdirs();
		}
			
		// 3. MultipartFile 클래스를 이용해서 업로드 처리하기
		// 1) 파일명 rename 처리..
		// 2) rename 된 파일명으로 파일 서버에 저장하기.. -> MultipartFile.transTo() 이용..
		
		List<Attachment> files = new ArrayList();
		
		for(MultipartFile f : upFile) {
			
			if (f != null && !f.isEmpty()) {
				// 파일 rename 만들기..
				String originalFilename = f.getOriginalFilename();
				
				String ext = null;
				
				try {
					ext = originalFilename.substring(originalFilename.lastIndexOf("."));
				} catch (StringIndexOutOfBoundsException e) {
					ext = null;
				}
				
				
				// 중복없게 파일명 만들기
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
				int rnd = (int)(Math.random()*10000) + 1;
				String renamedFilename = sdf.format(System.currentTimeMillis()) + "_" + rnd + ext;
				
				// 파일저장 처리하기 -> 지정된 위치(폴더)에 저장
				
				try {
					f.transferTo(new File(path, renamedFilename));
					
					files.add(Attachment.builder()
							.originalFileName(originalFilename)
							.renamedFileName(renamedFilename)
							.build());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		Board b = Board.builder()
				.boardTitle(boardTitle)
				.boardWriter(Member.builder().userId(boardWriter).build())
				.boardContent(boardContent)
				.files(files)
				.build();
		
		int result = 0;
		
		try {
			result = service.insertBoard(b);
		} catch(RuntimeException e) {
			// 업로드된 데이터 삭제
			for(Attachment a : files) {
				File f = new File(path + "/" + a.getRenamedFileName());
				
				if (f.exists()) {
					f.delete();
				}
			}
		}
		
		
		
		String msg = "";
		String loc = "";
		
		if (result > 0) {
			msg = "게시글 등록 성공";
			loc = "/board/boardList.do";
		} else {
			msg = "게시글 등록 실패";
			loc = "/board/boardWrite.do";
		}
		
		m.addAttribute("msg", msg);
		m.addAttribute("loc", loc);
		
		return "common/msg";
	}
	
	@RequestMapping("/filedownload.do")
	public void fileDownload(String og, String re) {
		
	}
	
	
}






