package com.dm.springboot.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.dm.springboot.model.vo.Member;

@Mapper
public interface MemberMapper {
	// 기본 sql문을 작성하는 메소드 선언하기
	@Select("SELECT * FROM MEMBER")
	List<Member> selectMember();
	
	@Select("SELECT * FROM MEMBER WHERE USERID LIKE '%'||#{id}||'%'")
	List<Member> selectMemberById(String id);
}
