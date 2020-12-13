package com.simple.dao;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreDAO {
	
	public void scoreRegist(ScoreVO vo); //등록
	public ArrayList<ScoreVO> getList(); //목록
	public void scoreDelete(int index); //삭제
}
