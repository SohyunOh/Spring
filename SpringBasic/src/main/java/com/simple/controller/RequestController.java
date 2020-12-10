package com.simple.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqVO;

@Controller //컴포넌트 스캔이 읽어서 빈으로 생성
@RequestMapping("/request")
public class RequestController {
	
	//req_ex01화면처리 메서드
	//void  형 메서드는 들어온 경로 그대로 뷰리졸버로 값이 반환됩니다
//	@RequestMapping("/kkkk")
//	public void req_ex01() {
//		System.out.println("실행됨");
//	}
	
	@RequestMapping("req_ex01")
	public String req_ex01() {
		return "request/req_ex01";
	}
	
	//basic 요청처리 (get방식만 허용)
	@RequestMapping(value = "/basic1", method = RequestMethod.GET)
	public void basic1() {
		System.out.println("basic1요청");
	}
	
	//basic2 요청처리 (Post반식만 허용)
	@RequestMapping(value = "/basic2", method = RequestMethod.POST)
	public void basic2() {
		System.out.println("basic2요청");
	}
	
	//basic3 요청처리 (get방식만 허용)-- string 4버젼
	@GetMapping("/basic3")
	public void basic3() {
		System.out.println("basic3요청");
	}
	
	//basic4 요청처리 (Post반식만 허용)
	@PostMapping("/basic4")
	public void basic4() {
		System.out.println("basic4요청");
	}
	
	//=====================요청 파라미터 처리================
	
	//req_ex02화면처리
	@RequestMapping("req_ex02")
	public String req_ex02() {
		return "request/req_ex02";
	}
	
//	//1st
//	@RequestMapping("/param")
//	public String param(HttpServletRequest request) {
//		
//		System.out.println( request.getParameter("id"));
//		System.out.println( request.getParameter("pw"));
//		return "request/req_ex02_result";
//	}
	
	
//	//2st - 어노테이션 방법
//	@RequestMapping("/param")
//	public String param(@RequestParam("id") String id,
//						@RequestParam("pw") String pw,
//						@RequestParam("name") String name,
//						@RequestParam("age") int age,
//						@RequestParam(value = "inter", required = false , defaultValue = "" ) ArrayList<String> list
//						) {
//		
//		System.out.println(id);
//		System.out.println(pw);
//		System.out.println(name);
//		System.out.println(age);
//		System.out.println(list.toString());
//
//		// 필수가 아닌 파라미터일경우에는 required = false 옵션을 저장할 수 있습니다
		//
//		return "request/req_ex02_result";
//	}
	
	//3nd
	//커맨드 객체를 사용하는 방법 
	@RequestMapping("/param")
	public String param(ReqVO vo) {
		
		System.out.println(vo.getId());
		System.out.println(vo.getPw());
		System.out.println(vo.getName());
		System.out.println(vo.getAge());
		System.out.println(vo.getInter().toString());
		
		return "request/req_ex02_result";
	}
	
	
	
	//==============문제===================
	
	//req_quiz01화면처리
	@RequestMapping("req_quiz01")//들어오는 요청  -  request/req_quiz01 -로그인 창
	public String req_quiz01() {
		return "request/req_quiz01"; // 화면으로 내보내는 요청   -- view/request/req_quiz01
	}
	
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@RequestParam("id") String id,
//						@RequestParam("pw") String pw
//						) {
//		
//		if(id.equals("abc123") &&  pw.equals("xxx123")) {
//			return "request/req_quiz01_ok";
//		}else {			
//			return "request/req_quiz01_no";
//		}
//		
//	}
	
	//메소드 먼저 쓰고 어노테이션 붙여주기
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ReqVO vo) {
		if(vo.getId().equals("abc123") && vo.getPw().equals("xxx123")) {
			return "request/req_quiz01_ok"; // 성공
		}else {			
			return "request/req_quiz01_no";// 실패
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
