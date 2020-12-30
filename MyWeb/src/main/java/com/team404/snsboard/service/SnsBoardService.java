package com.team404.snsboard.service;

import java.util.ArrayList;

import com.team404.command.SnsBoardVO;

public interface SnsBoardService {

	public boolean insertFile(SnsBoardVO vo);
	public ArrayList<SnsBoardVO> getList();
	
}
