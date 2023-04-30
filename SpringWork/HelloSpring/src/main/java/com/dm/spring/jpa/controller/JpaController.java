package com.dm.spring.jpa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dm.spring.jpa.common.MemberLevel;
import com.dm.spring.jpa.entity.Club;
import com.dm.spring.jpa.entity.Dev;
import com.dm.spring.jpa.entity.JpaMember;
import com.dm.spring.jpa.entity.JpaTest;
import com.dm.spring.jpa.entity.Locker;
import com.dm.spring.jpa.entity.Student;
import com.dm.spring.jpa.entity.Subject;
import com.dm.spring.jpa.service.JpaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class JpaController {
	
	private JpaService service;
	
	public JpaController(JpaService service) {
		this.service = service;
	}
	
	@RequestMapping("/jpa/basicJpa")
	public @ResponseBody JpaTest testBasicJpa() {
		
		return service.basicTest();
	}
	
	@RequestMapping("/jpa/insertJpa")
	public @ResponseBody JpaMember insertJpa() {
		
		
		return service.insertJpa();
	}
	
	@RequestMapping("/jpa/member")
	public @ResponseBody JpaMember searchMember(int no) {
		
		return service.searchMemberByNo(no);
	}
	
	@RequestMapping("/jpa/members")
	public @ResponseBody List<JpaMember> searchAllMember() {
		return service.searchAllMember();
	}
	
	@RequestMapping("/jpa/dev")
	public @ResponseBody Dev searchDev(int no) {
		return service.searchDev();
	}
	
	@RequestMapping("/jpa/searchAge")
	public @ResponseBody List<JpaMember> searchMemberBy(int age) {
		return service.searchMemberBy(age);
	}
	
	@RequestMapping("/jpa/insertMember")
	public @ResponseBody String insertMember(JpaMember member) {
		
		member.setMemberLevel(MemberLevel.BRONZE);
		service.insertMember(member);
		
		return "";
	}
	
	@RequestMapping("/jpa/updateMember")
	public @ResponseBody void updateMember(@RequestParam Map param) {

		service.updateMember(param);
	}
	
	@RequestMapping("/jpa/deleteMember")
	public @ResponseBody void deleteMember(int memberNo) {

		service.deleteMember(memberNo);
	}
	
	@RequestMapping("/jpa/oneToOne")
	public @ResponseBody String oneToOneText() {
		service.insertOneToOneData();
		return "redirect:/";
	}
	
	@RequestMapping("/jpa/student/{studentNo}")
	@ResponseBody
	public Student selectStudent(@PathVariable(name="studentNo") Long no) {
		return service.selectStudent(no);
	}
	
	@RequestMapping("/jpa/locker/{lockerNo}")
	@ResponseBody
	public Locker selectLocker(@PathVariable(name="lockerNo") Long no) {
		return service.selectLocker(no);
	}
	
	@RequestMapping("/jpa/club/{clubNo}")
	@ResponseBody
	public Club selectClub(@PathVariable(name="clubNo") Long no) {
		return service.selectClub(no);
	}
	
	@RequestMapping("/jpa/subject")
	public String insertSubject() {
		service.insertSubject();
		return "redirect:/";
	}
	
	@RequestMapping("/jpa/selectSubject/{subjectNo}")
	public Subject selectSubject(@PathVariable long no) {
		return service.selectSubject(no);
	}
	
}














