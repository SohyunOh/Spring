package com.team404.freeboard.service;

import java.util.ArrayList;
import com.team404.command.FreeBoardVO;
import com.team404.common.util.Criteria;

public interface FreeBoardService {

	//추상메서드 선언
	public void regist(FreeBoardVO vo);
	//public ArrayList<FreeBoardVO> getList(); //조회
	public ArrayList<FreeBoardVO> getList(Criteria cri); //페이징 조회
	public int getTotal(Criteria cri);//전체게시글 수
	
	public FreeBoardVO getContent(int bno); //상세
	public int update(FreeBoardVO vo); //업데이트 
	public int delete(int bno); //삭제
	
}
