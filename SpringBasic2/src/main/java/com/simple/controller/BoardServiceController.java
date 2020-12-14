package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.BoardVO;
import com.simple.service.BoardService;

@Controller
@RequestMapping("/service")
public class BoardServiceController {
	
	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	
	//화면처리
	@RequestMapping("/boardRegister")
	public void boardRegister() {
		
	}
	
	//등록요청
	@RequestMapping(value = "/boardForm", method = RequestMethod.POST)
	public String boardForm(BoardVO vo) {
		
		boardService.boardRegist(vo);
		
		return "service/boardResult";
	}
	
	//목록요청
	@RequestMapping("/boardList")
	public String boardList(Model model) {
				
		ArrayList<BoardVO> list = boardService.getList();
		model.addAttribute("list", list);
		
		return "service/boardList";
	}
	
	//삭제요청
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") int num) {
		
		boardService.boardDelete(num);
		
		return "redirect:/service/boardList";
	}
	
	
	
	
}
