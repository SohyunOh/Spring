package com.team404.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //게터세터
@AllArgsConstructor //모든생성자
@NoArgsConstructor //기본생성자
public class FreeBoardVO {
	//컬럼명과 동일하게 멤버변수 선언
	private int bno;
	private String title;
	private String writer;
	private String content;
	private Timestamp regdate;
	private Timestamp updatedate;
	
}
