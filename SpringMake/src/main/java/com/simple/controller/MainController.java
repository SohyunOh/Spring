package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //해당 어노테이션이 붙어잇는 클래스를  bean으로 생성
public class MainController {
	
	public MainController() {
		System.out.println("생성됨");
	}

	// '/'요청으로 들어왔을 때 해당 메서드 연결
	@RequestMapping("/")//빈으로 만들어져 있는 상태에서 분기점으로 나눠줌
	public String home() {
		System.out.println("실행됨");
		//실행시킬 코드를 작성...
//		return "/WEB-INF/views/home.jsp";//디스패쳐서블릿으로 반환
	
		return "home";
	}
}
