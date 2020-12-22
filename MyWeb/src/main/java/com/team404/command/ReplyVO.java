package com.team404.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //겟터,셋터
@AllArgsConstructor //모든 멤버변수를 초기화화는 생성자
@NoArgsConstructor //기본생성자
public class ReplyVO {
	
	private int bno; //글번호
	private int rno; //댓글번호
	private String reply; //글내용
	private String replyId; //아이디
	private String replyPw; //비밀번호
	private Timestamp replydate; //등록일
	private Timestamp updatedate; //수정일
}
