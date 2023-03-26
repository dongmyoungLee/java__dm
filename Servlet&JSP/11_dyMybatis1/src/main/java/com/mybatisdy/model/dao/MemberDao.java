package com.mybatisdy.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class MemberDao {
	public List<Map> selectMemberList(SqlSession session) {
		return session.selectList("member.memberList");
	}
}
