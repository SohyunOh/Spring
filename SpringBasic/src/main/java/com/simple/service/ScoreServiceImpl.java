package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;
import com.simple.mapper.ScoreMapper;

@Service("xx") //scoreService이름으로 bean생성
public class ScoreServiceImpl implements ScoreService{

//	@Autowired
//	@Qualifier("scoreDAO")
//	private ScoreDAO scoreDAO;
//	
//	@Override
//	public void scoreRegist(ScoreVO vo) {
//		scoreDAO.scoreRegist(vo);
//	}
//
//	@Override
//	public ArrayList<ScoreVO> getList() {
//			
//		return scoreDAO.getList();
//	}
//
//	@Override
//	public void scoreDelete(int index) {
//		
//		scoreDAO.scoreDelete(index);
//	}
	//================아미바티스 연결====================
	
	@Autowired
	private ScoreMapper scoreMapper; 
	
	@Override
	public void scoreRegist(ScoreVO vo) {
		scoreMapper.scoreRegist(vo);
	}

	@Override
	public ArrayList<ScoreVO> getList() {

		return scoreMapper.getList();
	}

	@Override
	public void scoreDelete(int index) {
		scoreMapper.scoreDelete(index);
		
	}

}
