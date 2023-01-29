package com.member.controller;

import java.util.List;

import com.member.model.service.MemberService;
import com.member.model.vo.Member;
import com.member.view.MainView;

public class MemberController {
	
	//private MemberDao dao = new MemberDao();
	private MemberService service = new MemberService();
	
	
	public void searchAll() {
		List<Member> members = service.searchAll();
		
		new MainView().printMembers(members);
	}
	
	public void searchId() {
		String id = new MainView().searchData("ID");
		List<Member> members = service.searchId(id);
		
		new MainView().printMembers(members);
	}
	
	public void searchName() {
		String name = new MainView().searchData("이름");
		List<Member> members = service.searchName(name);
		
		new MainView().printMembers(members);
		
	}
	
	public void insertMember() {
		Member m = new MainView().inputMember();
		int result = service.insertMember(m);
		
		new MainView().printMsg(result > 0 ? "회원가입 성공" : "회원가입 실패");
	}
	
	public void updateMember() {
		// 업데이트 내용을 받아서 처리할거임..
		
		Member m = new MainView().updateMember();
		int result = service.updateMember(m);
		
		new MainView().printMsg(result > 0 ? "회원수정 성공" : "회원수정 실패");
	}
	
	public void deleteMember() {
		String id = new MainView().deleteMember("ID");
		
		int result = service.deleteMember(id);

		new MainView().printMsg(result > 0 ? "회원삭제 성공" : "회원삭제 실패");
	}
	

	
	
}
