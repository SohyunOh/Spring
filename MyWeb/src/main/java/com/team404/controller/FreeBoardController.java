package com.team404.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("freeBoard")
public class FreeBoardController {
	
	
	//글 목록
	@RequestMapping("/freeList")
	public String freeList() {
		return "freeBoard/freeList";
	}
	
	
	//글 등록
	@RequestMapping("freeRegist")
	public String freeRegist() {
		return "freeBoard/freeRegist";
	}
	
	

}
