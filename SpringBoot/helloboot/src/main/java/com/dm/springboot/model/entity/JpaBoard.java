package com.dm.springboot.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "seq_jpaboardno", sequenceName = "seq_jpaboardno", allocationSize = 1)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class JpaBoard {
	@Id
	@GeneratedValue(generator = "seq_jpaboardno", strategy = GenerationType.SEQUENCE)
	private Long boardNo;
	
	@Column(nullable = false, length = 200)
	private String boardTitle;

	private String boardContent;
	
	@ManyToOne
	@JoinColumn(name="board_writer")
	private JpaMember writer;
	
	@Temporal(TemporalType.DATE)
	private Date boardDate;
}






