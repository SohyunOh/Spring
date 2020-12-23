package com.simple.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/session")
public class SessionController {

	@RequestMapping("/login")
	public String login() {
		return "session/login";
	}
	
	@RequestMapping("/join")
	public String join() {
		return "session/join";
	}
	
	
	@RequestMapping("/main")
	public String main() {
		return "session/main";
	}
	
	@RequestMapping("/mypage")
	public String mypage(HttpSession session) {
		
		//인터셉터를 이용한 세션처리
		//마이페이지에서 세션정보가 없으면 Redirect를 이용해서 로그인 페이지
		//이렇게 처리할 페리지가 20개면?
//		if(session.getAttribute("user_id") == null) {
//			return "redirect:/session/login";
//		}
		
		return "session/mypage";
	}
	
	//form 처리
	@RequestMapping(value = "/joinForm", method = RequestMethod.POST)
	public String joinForm (@RequestParam("id") String id,
							@RequestParam("pw") String pw,
							@RequestParam("name") String name){
		
		return "redirect:/session/main"; //컨트롤러를 태워서 보냄.
	}
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.POST)
	public String loginForm (@RequestParam("id") String id,
							@RequestParam("pw") String pw,
							HttpSession session,
							RedirectAttributes RA) {
		
		//아이이다 admin, 비밀번호 1234라면 로그인 성공
		if(id.equals("admin") && pw.equals("1234")) {//로그인 성공
			//세션에 vo나 id 저장
			session.setAttribute("user_id", "admin");
			session.setAttribute("user_name", "홍길동");
			
			return "redirect:/session/mypage";
			
		}else {//로그인 실패
			
			return "redirect:/session/login";
		}
			
		
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id"); //특정세션값 삭제
		session.invalidate();//세션정보 삭제
		
		return "redirect:/"; //홈화면으로
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
