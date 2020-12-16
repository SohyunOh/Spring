package com.team404.freeboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.mapper.FreeBoardMapper;

//커넬표기법으로 표기하기
@Service("freeBoardService")// 이 패키지가 읽히는지 확인(컴포넌트스캔)-servlet-context.xmldp 빈 스캔너 추가해주기
public class FreeBoardServiceImpl implements FreeBoardService{

	@Autowired
	private FreeBoardMapper freeBoardMapper;
		
	@Override
	public void regist(FreeBoardVO vo) {
		
		freeBoardMapper.regist(vo);
		
	}

	@Override
	public ArrayList<FreeBoardVO> getList() {
		
		return freeBoardMapper.getList();
	}

	@Override
	public FreeBoardVO getContent(int bno) {
		
		return freeBoardMapper.getContent(bno);
	}

	@Override
	public int update(FreeBoardVO vo) {
		return freeBoardMapper.update(vo);
	}

	@Override
	public int delete(int bno) {
		return freeBoardMapper.delete(bno);
	}

}
