package com.dm.springboot.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.dm.springboot.model.vo.Member;

public interface MemberDao {
	List<Member> selectMemberAll(SqlSessionTemplate session);
	
	Member selectByMemberbyId(SqlSessionTemplate session, String id);
	
}
