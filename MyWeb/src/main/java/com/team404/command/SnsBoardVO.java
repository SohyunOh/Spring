package com.team404.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SnsBoardVO {

	private int bno;
	private String writer;
	private String content;
	private String uploadPath;
	private String fileLoca;
	private String fileName;
	private String fileRealName;
	private Timestamp regdate;
	
}
