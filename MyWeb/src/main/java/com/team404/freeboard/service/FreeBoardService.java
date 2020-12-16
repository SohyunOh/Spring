package com.team404.freeboard.service;

import java.util.ArrayList;

import com.team404.command.FreeBoardVO;

public interface FreeBoardService {
	
	//추상메서드
	public void regist(FreeBoardVO vo);
	public ArrayList<FreeBoardVO> getList();// 조회
	public FreeBoardVO getContent(int bno);//상세정보
	public int update(FreeBoardVO vo);//글 수정
	public int delete(int bno);//삭제
}
 