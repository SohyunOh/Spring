package com.team404.controller;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team404.command.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//주소 API승인키
	//devU01TX0FVVEgyMDIwMTIyMzE1MzUyMTExMDU4Njg=
	
	@RequestMapping("/userJoin")
	public String userJoin() {
		return "user/userJoin";
	}
	
	@RequestMapping("/userLogin")
	public String userLogin() {
		return "user/userLogin";
	}
	
	//일반컨트롤러에서는 비동기요청 메서드는 @ResponseBody를 붙입니다
	@ResponseBody //응답요청을 viewResolve로 반환하느 ㄴ것이 아닌, 요청이 들어온 곳으로 Response  Header정보를 만들어서 보내준다
	@RequestMapping(value = "/idCheck" , method = RequestMethod.POST)
	public int idCheck(@RequestBody UserVO vo) {
		
		System.out.println(vo.toString());
		
		//화원 중복체크
		
		return 1;
	}
	
}
