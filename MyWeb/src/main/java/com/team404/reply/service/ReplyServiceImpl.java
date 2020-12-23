package com.team404.reply.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team404.command.ReplyVO;
import com.team404.common.util.Criteria;
import com.team404.reply.mapper.ReplyMapper;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyMapper replyMapper;
	
	
	@Override
	public int replyRegist(ReplyVO vo) {
		return replyMapper.replyRegist(vo);
	}


	@Override
	public ArrayList<ReplyVO> getList(int bno, Criteria cri) {
		
		return replyMapper.getList(bno, cri);
	}

	@Override
	public int getTotal(int bno) {
		
		return replyMapper.getTotal(bno);
	}


	@Override
	public int update(ReplyVO vo) {
		//1.sql문 두번 실행
		//2.sql 문을 한번에 실행
		return replyMapper.update(vo);
	}

	@Override
	public int pwCheck(ReplyVO vo) {
		
		return replyMapper.pwCheck(vo);
	}

	@Override
	public int delete(ReplyVO vo) {

		return replyMapper.delete(vo);
	}


}
