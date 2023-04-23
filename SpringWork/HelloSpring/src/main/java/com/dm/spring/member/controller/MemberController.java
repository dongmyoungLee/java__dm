package com.dm.spring.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.dm.spring.member.model.service.MemberService;
import com.dm.spring.member.model.vo.Member;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Controller
@SessionAttributes({"loginMember"})
@RequestMapping("/member")
@Slf4j
public class MemberController {
	
	private MemberService service;
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public void setPasswordEncoder(BCryptPasswordEncoder encoder) {
		this.passwordEncoder = encoder;
	}
	
	@Autowired
	public void setService(MemberService service) {
		this.service = service;
	}
	
	@RequestMapping("/login")
	public String login(String userId, String password, Model model) {
		
		Member m = service.selectMemberById(userId);

		if (m != null && passwordEncoder.matches(password, m.getPassword())) {
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
		// 매개 변수로 넘어온 password 값을 암호화처리하자..
		String password = m.getPassword();
		String encPass = passwordEncoder.encode(password);
		
		m.setPassword(encPass);
		
		
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
	
	@RequestMapping("/duplicateId.do")
	public void basicAjax(String userId, HttpServletResponse res, PrintWriter out) throws IOException, ServletException {
		
		Member m = service.selectMemberById(userId);
		
		//res.setContentType("text/csv;charset=utf-8");
		//res.getWriter().print(m != null ? true: false);
		
		//out.print(m!=null ? true : false);
		
		ObjectMapper mapper = new ObjectMapper();
		res.setContentType("application/json;charset=utf-8");
		out.print(mapper.writeValueAsString(m));
		
	}
	
	// json 방식의 데이터를 응답하는 메소드는 @ResponseBody 어노테이션 이용 -> restful 구현했을때 적용..
	
	@RequestMapping("/duplicateId2.do")
	public @ResponseBody Member jacksonBinder(String userId) {
		
		Member m = service.selectMemberById(userId);
		
		return m;
	}
	
	@RequestMapping("/selectMemberAll.do")
	public @ResponseBody List<Member> selectMemberAll() {
		
		return service.selectMemberAll();
	
	}
	
	// json 방식으로 전송 된 데이터 저장하기
	@RequestMapping(value="/ajax/insert", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Member insertAjax(@RequestBody Member m) {
		
		log.debug("{}", m);
		
		return m;
	}
	
}









