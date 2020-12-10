package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;

@Service("xx")//scerService이름으로  bean 생성
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	@Qualifier("scoreDAO")
	private ScoreDAO scoreDAO;
	
	//등록
	@Override
	public void scoreRegist(ScoreVO vo) {
		
		scoreDAO.scoreRegist(vo);
		
	}

	// 목록
	@Override
	public ArrayList<ScoreVO> getlist() {
		
		return scoreDAO.getlist();
	}

}
