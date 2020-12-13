package com.simple.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreService;
import com.simple.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ScoreController {
	
	//1st
	//private ScoreService service = new ScoreServiceImpl();
	
	//2nd
	//스프링컨테이너에 직접 bean으로 생성하고 자동주입명령
	//@Autowired
	//@Resource(name = "service")
	//private ScoreService service;
	
	//3nd
	@Autowired
	@Qualifier("xx")
	//@Resource(name = "xx")
	private ScoreService service;
	
	
	//점수입력 화면처리
	@RequestMapping("/scoreRegist")
	public String scoreRegist() {
		return "service/scoreRegist";
	}
	
	//점수입력 폼처리
	@RequestMapping("/scoreForm")
	public String scoreForm(ScoreVO vo) {
		
		service.scoreRegist(vo);
		
		return "service/scoreResult"; //결과화면
	}
	
	//점수목록 요청
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		
		
		ArrayList<ScoreVO> list = service.getList();
		
		model.addAttribute("list", list); //모델에 list저장
		
		return "service/scoreList"; //점수목록화면
	}
	
	//점수 삭제 요청
	@RequestMapping("/scoreDelete")
	public String scoreDelete(@RequestParam("num")  int index ) {
		
		service.scoreDelete(index);		
		
		
		return "redirect:/service/scoreList"; //목록컨트롤러
	}
	
	
	
	
	
}
