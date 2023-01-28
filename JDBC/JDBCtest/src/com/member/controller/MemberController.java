package com.member.controller;

import java.util.List;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;
import com.member.view.MainView;

public class MemberController {
	
	private MemberDao dao = new MemberDao();
	
	public void mainMenu() {
		
	}
	
	public void searchAll() {
		List<Member> members = dao.searchAll();
		
		new MainView().printMembers(members);
	}
	
	public void searchId() {
		
	}
	
	public void searchName() {
		String name = new MainView().searchData("이름");
		List<Member> members = dao.searchName(name);
		
		new MainView().printMembers(members);
		
	}
	
	public void insertMember() {
		Member m = new MainView().inputMember();
		int result = dao.insertMember(m);
		
		new MainView().printMsg(result > 0 ? "회원가입 성공" : "회원가입 실패");
	}
	
	public void updateMember() {
		
	}
	
	public void deleteMember() {
		
	}
	

	
	
}
