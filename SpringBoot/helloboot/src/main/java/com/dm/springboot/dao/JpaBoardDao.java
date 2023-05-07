package com.dm.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dm.springboot.model.entity.JpaBoard;


public interface JpaBoardDao extends JpaRepository<JpaBoard, Long>,
							  PagingAndSortingRepository<JpaBoard, Long>{
	
	List<JpaBoard> findByBoardContentLike(String keyword);
}