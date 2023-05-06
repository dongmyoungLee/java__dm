package com.dm.springboot.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dm.springboot.model.service.MemberService;
import com.dm.springboot.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BasicController {
	
	@Value("${linux.base}")
	private String linuxBaseDir;
	
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
	
	@RequestMapping("/member/memberAll.do")
	public String selectMemberAll2(Model model) {		
		List<Member> list = service.selectMemberAll();
		model.addAttribute("members", list);
		
		return "member/memberList";
	}
	
	@RequestMapping("/member/searchMember.do")
	public String searchMember(Model model, String id) {
		List<Member> list = service.selectByMemberbyId(id);
		model.addAttribute("members", list);
		
		return "member/memberList";	
	}
	
	@RequestMapping("/fileupload")
	public String uploadFile(MultipartFile upfile) {
		
		log.info("파일크기 : " + upfile.getSize());
		log.info("파일이름 : " + upfile.getOriginalFilename());
		return "redirect:/";
	}
}







