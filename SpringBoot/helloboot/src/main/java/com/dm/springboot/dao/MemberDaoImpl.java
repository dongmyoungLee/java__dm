package com.dm.springboot.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.dm.springboot.model.vo.Member;

@Primary
@Repository
public class MemberDaoImpl implements MemberDao {
	
	

	@Override
	public List<Member> selectMemberAll(SqlSessionTemplate session) {
		// TODO Auto-generated method stub
		return session.selectList("member.selectMemberAll");
	}

	@Override
	public List<Member> selectByMemberbyId(SqlSessionTemplate session, String id) {
		// TODO Auto-generated method stub
		
		return session.selectList("member.selectByMemberbyId", id);
	}

}
