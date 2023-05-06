package com.dm.springboot.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dm.springboot.model.service.MemberService;
import com.dm.springboot.model.vo.Member;
import com.dm.springboot.model.vo.Test;

import lombok.extern.slf4j.Slf4j;

@Controller
public class BasicController {
	
	private MemberService service;
	
	//spring framework 4.2 버전 이후에는 매개변수 있는 생성자 한개만 있는경우 @Autowired 어노테이션을 설정하지 않아도 자동으로 해줌..	
	public BasicController(MemberService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/member")
	@ResponseBody
	public List<Member> selectMemberAll() {
		
		return service.selectMemberAll(); 
	}
}
