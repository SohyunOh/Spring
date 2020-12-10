package com.simple.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreService;


@Controller
@RequestMapping("/service")
public class ScoreController {
	
	//1st 
//	private ScoreService service = new ScoreServiceImpl();
			
	//2nd
	//스트링 컨테이너에 직접 bean 으로 생성하고 자동주입명령
	//@Autowired 
//	@Resource(name="service")
//	private ScoreService service;

	//3nd
//	@Autowired
//	@Qualifier("xx")
	@Resource(name="xx")
	private ScoreService service;
	
	
	//접수 입력 화면처리
	@RequestMapping("/scoreRegist")
	public String score() {
		return "service/scoreRegist";
	}
	
	//점수입력 폼처리
	@RequestMapping("/scoreForm")
	public String scoreFore(ScoreVO vo) {
		
		service.scoreRegist(vo);
		
		return "service/scoreResult";//결과화면
	}
	
	// 점수목록 요청
	@RequestMapping("/scoreList")
	public String socoreList(Model model) {
		
		ArrayList<ScoreVO> list = service.getlist();
		
		model.addAttribute("list", list); //모델 list 저장
		return "service/scoreList";// 점수목록 화면
		
	}

	
	
	
	
	
}
