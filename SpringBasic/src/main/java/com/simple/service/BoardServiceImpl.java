package com.simple.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
import com.simple.dao.BoardDAO;

@Service("boardService") //component스캔 확인
public class BoardServiceImpl implements BoardService {
	
	@Resource(name = "boardDAO")
	private BoardDAO boardDAO;
	
	
	@Override
	public void boardRegist(BoardVO vo) {
		
		boardDAO.boardRegist(vo);
	}

	@Override
	public ArrayList<BoardVO> getList() {
	
		return boardDAO.getList();
	}

	@Override
	public void boardDelete(int num) {
		
		boardDAO.boardDelete(num);
	}

}
