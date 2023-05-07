package com.dm.springboot.contoller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.springboot.model.entity.JpaBoard;
import com.dm.springboot.model.entity.JpaMember;
import com.dm.springboot.model.service.JpaService;

import ch.qos.logback.core.status.Status;

@RestController // Controller + ResponseBody
@RequestMapping("/jpa")
public class JpaController {
	
	// rest 방식으로 요청받기
	/*
	 * @GetMapping
	 * 
	 * @PostMapping
	 * 
	 * @PutMapping
	 
	 * 
	 * @DeleteMapping
	 */
	
	private JpaService service;
	private BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	
	public JpaController(JpaService service) {
		this.service = service;
	}
	
	@GetMapping("/member")
	public List<JpaMember> selectMemberAll() {
		return service.selectMemberAll();
	}
	
	@GetMapping("/member/{id}")
	public JpaMember selectMemberById(@PathVariable String id) {
		return service.selectMemberById(id);
	}
	
	@GetMapping("/member/name/{name}")
	public List<JpaMember> selectMemberByName(@PathVariable String name) {
		return service.selectMemberByName(name);
	}
	
	@GetMapping("/member/page")
	public Page<JpaMember> selectMemberPage() {
		return service.selectMemberPage();
	}
	
	@GetMapping("/board")
	public ResponseEntity<List<JpaBoard>> selectBoardAll() {
		List<JpaBoard> boards = service.selectBoardAll();
		ResponseEntity<List<JpaBoard>> response = new ResponseEntity<>(boards, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/board/{id}")
	public JpaBoard selectBoard(@PathVariable Long id) {
		System.out.println(id);
		return service.selectBoard(id);
	}
	
	@GetMapping("/board/content/{keyword}")
	public List<JpaBoard> selectBoardByContent(@PathVariable String keyword) {
		return service.selectBoardByContent(keyword);
	}
	
	@PostMapping("/member")
	public JpaMember insertMember(JpaMember member) {
		member.setPassword(pwEncoder.encode(member.getPassword()));
		
		return service.insertMember(member);
	}
}






