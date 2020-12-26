package com.team404.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.UserVO;
import com.team404.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	
	//주소API승인키
	//devU01TX0FVVEgyMDIwMTIyMzE1MzQyMTExMDU4Njc=
	
	@RequestMapping("/userJoin")
	public String userJoin() {
		return "user/userJoin";
	}
	
	@RequestMapping("/userLogin")
	public String userLogin() {
		return "user/userLogin";
	}
	
	@RequestMapping("/userMypage")
	public String userMypage() { 
		return "user/userMypage";
	}
	
	
	//일반컨트롤러에서는 비동기요청 메서드는 ResponseBody를 붙입니다.
	@ResponseBody //응답요청을 viewResolve로 반환하는 것이 아닌, 요청이 들어온곳으로 Response Header정보를 만들어서 보내준다.
	@RequestMapping(value = "/idCheck", method=RequestMethod.POST)
	public int idCheck(@RequestBody UserVO vo) {
	
		//회원가입중복체크
		//result는 중복이 아니면 0, 중복이라면 1
		int result = userService.idCheck(vo);
		
		
		return result;
	}
	
	
	//join
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(UserVO vo, RedirectAttributes RA) {
		
		
		int result = userService.join(vo);
			
		if(result == 1) { //가입 성공
			RA.addFlashAttribute("msg", "가입을 축하합니다");			
		} else { //가입 실패
			RA.addFlashAttribute("msg", "가입에 실패했습니다. 다시시도하세요");
		}
		
		return "redirect:/user/userLogin";
		
	}
	
	
	//Login
	@ResponseBody
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(@RequestBody UserVO vo,
						RedirectAttributes RA,
						HttpSession session
						) {
		
		
		int result = userService.login(vo);
		
		if(result == 1) { //로그인 성공
			session.setAttribute("UserVO", vo.getUserId() );
			return "redirect:/user/userMypage";
		} else { //로그인 실패
			RA.addFlashAttribute("msg", "로그인 실패했습니다. 다시시도하세요");
			return "redirect:/user/userLogin";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
