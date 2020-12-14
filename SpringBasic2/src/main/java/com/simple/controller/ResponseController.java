package com.simple.controller;

import java.util.Date;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	
	@RequestMapping("/res_ex01") // ---> /response/res_ex01 로 경로가 들어옴
	public String res_ex01() {
		
		return "response/res_ex01";
	}

	//model 전달자 - 메서드매개변수로  Model or ModelMap 선언 - (키, 값)
	@RequestMapping("/res_ex02") 
	public String res_ex02(Model model) {
		
		model.addAttribute("serverTime", new Date());//serverTime 이름으로 날짜를 저장
		model.addAttribute("name", "홍길동") ;
		model.addAttribute("addr", "서울시") ;
		return "response/res_ex02";
	}
	
	//ModelAndView 객체 - Model에 대한 정보와 , 화면에 대한 정보를 한번에 저장
	@RequestMapping("/res_ex03")
	public ModelAndView res_ex03() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("serverTime", new Date());//데이터 저장
		mv.addObject("name", "이순신");
		
		mv.setViewName("response/res_ex03");// 화면정보 저장
		
		return mv;
	}
	
	//@ModeAttribute()- request, model 합쳐진 상태
	//단일값 가능 , vo 객체도 가능
	@RequestMapping("/res_ex04")
	public String res_ex04(@ModelAttribute("num") String num,
							@ModelAttribute("name") String name ) {
							
		System.out.println("넘온값:"+ num);
		System.out.println("넘온값:"+ name);
		
		return "response/res_ex04";
	}
	
	@RequestMapping("/res_ex05")
	public String res_ex05(@ModelAttribute("info") ReqVO vo ) {
							
		System.out.println(vo.getId());
		System.out.println(vo.getName());
		
		return "response/res_ex05";
	}
	
	
	//================리다이렉트와 리다이렉트 어트리뷰트 ========================

	
	//화면처리
	@RequestMapping("/res_redirect")
	public String res_redirect() {
		return "response/res_redirect";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						RedirectAttributes RA
							) {
		
		if(id.equals(pw)) {//로그인 성공(성공페이지)
			return "response/res_redirect_ok";
			
		}else {//틀린 경우 다시 로그인 페이지로
			
			RA.addFlashAttribute("msg", "아이디 비밀번호 확인하세요");
			
			// * "redirect:/ 절대경로" - 다시 컨트롤러를 타게함.
			// 이떄 화면에 1회성 데이터로 값을 전달하고 싶으면
			//RedirectAttributes 객체를 사용하면 됩니다 (리다이렉트시 모델을 전달 할 수 있음)
			
//			return "response/res_redirect"; // forword 형식으로 보냄
			return "redirect:/response/res_redirect"; // * 다시 컨트롤러를 태움
			//다시 브라우저로 새롭게 절대경로로 요청보냄.- forword 형식이 아님- 새로운 창
			//모델을 사용못함-- 모델은 다음 화면까지만 유효한데  리다이렉트는 두번의 화면 이동
			//RedirectAttribute 객체일화성 일시적 전달용/ addFlashAttribute()
						
		}	
	}
	
	//===============================문제=================================
	
	// 화면처리
	@RequestMapping("/res_quiz01")
	public void res_quiz01() {
//		return "response/res_quiz01";
	}
	
	@RequestMapping(value = "/res_login", method = RequestMethod.POST)
	public String res_login (
			@ModelAttribute("id") String id, //받고 보냄 --다음 화면 까지 일어남
			@ModelAttribute("pw") String pw
//			@RequestParam("id") String id,
//			@RequestParam("pw") String pw,
//			Model model
				) {
		
		if(id.equals("kim12") && pw.equals("1234") ) {
			
//			ModelAndView mv = new ModelAndView();
//			mv.addObject("id", "kim12" );//데이터 저장
//			mv.addObject("pw", "1234");
//			
//			mv.setViewName("response/res_quiz02");// 화면정보 저장
//			
//			return mv;
//			
			
			return "response/res_quiz02"; //성공페이지
		}else {
			
			return "response/res_quiz03"; //실패페이지
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
