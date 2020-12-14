package com.simple.mapper;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreMapper {

	public void scoreRegist(ScoreVO vo); //등록 메서드
	public ArrayList<ScoreVO> getList(); //목록
	public void scoreDelete(int index); //삭제
		
	
	
	
}
