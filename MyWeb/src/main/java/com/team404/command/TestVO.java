package com.team404.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//롬복을 설치하면 @data 사용가능
@Data //게터 //세터 자동
@AllArgsConstructor//모든 멤버변수를 초기화는 생성자
@NoArgsConstructor// 기본생성자
public class TestVO {

	private String id;
	private String pw;
	
	//게터, 세터, 생성자
	
}
