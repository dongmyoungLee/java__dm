package com.dm.springboot.model.service;

import java.util.List;

import com.dm.springboot.model.vo.Member;

public interface MemberService {
	List<Member> selectMemberAll();
	
	Member selectByMemberbyId(String id);
}
