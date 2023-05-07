package com.dm.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dm.springboot.model.entity.JpaMember;

//boot 에서 hibernate 를 이용해서 sql문 처리하기
//인터페이스 생성하기 -> jpaRepository인터페이스를 상속받음
public interface JpaMemberDao extends JpaRepository<JpaMember, String>,
							  PagingAndSortingRepository<JpaMember, String>{
	
	// jpaRepository 가 정해놓은 패턴에 의해서 메소드를 생성할 수 있음
	
	// select -> findBy필드명(필드명데이터) -> 필드명과 일치하는 값을 조회하는 메소드 설정
	
	// 부분검색(like) -> findBy필드명Like(필드명데이터) -> 필드명을 like로 조회
	
	// 다수항목으로 조회 -> findBy필드명(And||Or)필드명(첫번째 필드값, 두번째 필드값) -> 두개 항목으로 조회하는 메소드 설정
	
	// null -> findBy필드명IsNull||IsNotNull()
	
	// 순서정렬해서 조회하기 findBy필드명OrderBy필드명Asc||Desc(필드명)
	
	List<JpaMember> findByUserNameLike(String name);
	
	// Jpa 에서 페이징 처리하기
	Page<JpaMember> findAll(Pageable p);
}