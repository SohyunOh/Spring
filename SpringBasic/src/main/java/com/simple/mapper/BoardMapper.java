package com.simple.mapper;

import java.util.ArrayList;

import com.simple.command.BoardVO;

public interface BoardMapper {
	
	//service에서 BoardMapper로 연결해서 정상적으로 동작되도록 변경
	
	public void boardRegist(BoardVO vo); //board 등록 메서드
	public ArrayList<BoardVO> getList(); //모든 게시물 가져오기
	public void boardDelete(int num); //게시글 삭제 메서드
	
	//위 메서드를 구현하는 클래스 BoardServiceImpl을 생성하고 오버라이딩하세요 


}
