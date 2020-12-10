package com.simple.dao;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreDAO {
	
	public void scoreRegist(ScoreVO vo); //등록 메서드
	public ArrayList<ScoreVO> getlist(); 

}
