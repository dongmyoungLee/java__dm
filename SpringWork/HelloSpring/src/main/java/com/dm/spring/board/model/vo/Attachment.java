package com.dm.spring.board.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attachment {
	private long attachmentNo;
	private int boardNo;
	private String originalFileName;
	private String renamedFileName;
	private Date uploadDate;
	private int downloadCount;
}
