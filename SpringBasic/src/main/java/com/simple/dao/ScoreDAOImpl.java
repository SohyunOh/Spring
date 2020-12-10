package com.simple.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

// @Repository = @service = @Component (역할을 구분을 위한 단어들 기능은 같음)
@Repository("scoreDAO")//scoreDAO 이름으로  bean 생성 
public class ScoreDAOImpl implements ScoreDAO {

	// 싱글톤
	private ArrayList<ScoreVO> list = new ArrayList<>();
	
	
	//DB관련된 작업....
	@Override
	public void scoreRegist(ScoreVO vo) {
		
		System.out.println(vo.toString());
		list.add(vo); //db추가 작업...
	}


	@Override
	public ArrayList<ScoreVO> getlist() {
		
		return list;
	}

}
