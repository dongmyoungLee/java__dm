package com.dm.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.dm.spring.member.model.service.MemberService;
import com.dm.spring.member.model.vo.Member;

@Controller
@SessionAttributes({"loginMember"})
@RequestMapping("/member")
public class MemberController {
	
	private MemberService service;
	
	@Autowired
	public void setService(MemberService service) {
		this.service = service;
	}
	
	@RequestMapping("/login")
	public String login(String userId, String password, Model model) {
		
		Member m = service.selectMemberById(userId);

		if (m != null && m.getPassword().equals(password)) {
			// 로그인 성공
			//session.setAttribute("loginMember", m);
			
			model.addAttribute("loginMember", m);
		} else {
			model.addAttribute("msg", "로그인 실패 다시 시도하세요.");
			model.addAttribute("loc", "/");
			return "common/msg";
		}
		
		
		return "redirect:/";
	}
	
	@RequestMapping("/logout.do")
	public String logout(SessionStatus session) {
		//HttpSession session
		
		/*
		 * if (session != null) { session.invalidate(); }
		 */	
		
		if (!session.isComplete()) {
			session.setComplete();
		}
		return "redirect:/";
	}
	
	@RequestMapping("/enrollMember.do")
	public String enrollMemberView() {
		
		
		return "member/enrollMember";
	}
	
	@RequestMapping("/enrollMemberEnd.do")
	public String enrollMemberEnd(Member m, Model model) {
		
		int result = service.insertMember(m);
		
		if (result > 0) {
			model.addAttribute("msg", "회원가입이 완료 되었습니다.");
			model.addAttribute("loc", "/");
		
		} else {
			model.addAttribute("msg", "회원가입 실패");
			model.addAttribute("loc", "/member/memberEnroll.do");
		}
		
		return "common/msg";
	}
	
}


