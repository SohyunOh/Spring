package com.team404.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
	public String userMypage(HttpSession session, Model model) { 
		//조인데이터 대한 처리방법
		UserVO vo= (UserVO) session.getAttribute("userVO");
		String userId = vo.getUserId();
		
		
		//1:N관계 맵핑으로 결과처리
		UserVO userInfo = userService.getInfo(userId);
		model.addAttribute("userInfo", userInfo);
		
		
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
//	@RequestMapping(value = "login", method=RequestMethod.POST)
//	public String login(@RequestParam("id") String id,
//						@RequestParam("pw") String pw,
//						RedirectAttributes RA,
//						HttpSession session
//						) {
//		
//		UserVO vo = userService.login(id,pw);
//		
//		if(vo == null) { //로그인 성공
//			RA.addFlashAttribute("msg", "로그인 실패했습니다. 다시시도하세요");
//			return "redirect:/user/userLogin";
//		} else { //로그인 실패
//			session.setAttribute("UserVO", vo);
//			RA.addFlashAttribute("vo", vo );
//			return "redirect:/user/userMypage";
//		}
//		
//	}
//	
	
	//login
	//postHandle로 처리 : 컨트롤러에서 돌아오는 인터셉터 
//	@RequestMapping(value = "login", method=RequestMethod.POST)
//	public String login(UserVO vo,
//						Model model,
//						HttpSession session
//							) {
////		System.out.println(vo.toString());
//
//		//로그인 성공시 회원정보를 받아오고, 로그인 실패시 null을 반환
//		UserVO result = userService.login(vo);
////		System.out.println(result);
//		
//		if(result == null) { //로그인 실패
//			model.addAttribute("msg", "아이디 비밀번호를 확인하세요");
//			return "user/userLogin"; //다시 로그인화면
//		} else {
//			//세션에 회원정보를 저장
//			session.setAttribute("userVO", result);
//			
//			return "redirect:/";
//		}
//		
//		
//		}
	
	//login 처리(인터셉터처리)
	@RequestMapping(value = "login", method=RequestMethod.POST)
	public ModelAndView login(UserVO vo,
						Model model,
						HttpSession session
							) {
		
		//로그인 성공시 회원정보를 받아오고, 로그인 실패시 null을 반환
		UserVO result = userService.login(vo);	

		ModelAndView mv = new ModelAndView(); //뷰 와 model 정보를 동시에 저장하는 객체
		mv.setViewName("/user/userLogin"); //로그인 실패시 경로
		
		//로그인 성공시 회원정보 저장, 실패시 msg 정보 저장
		if(result != null) { //로그인 
			mv.addObject("login", result);//로그인 이름으로 result 객체 담기
		}else {//로그인 실패
			mv.addObject("msg", "아이디, 비밀번호 확인하세요");
		}
			return mv; //postHandle 를 거쳐서 디스펫쳐 서블릿으로 돌아감
		
		}
		
	
		//로그아웃
	@RequestMapping("userLogout")
	public String userLogout(HttpSession session) {
		
		session.invalidate();
		
		
		return "redirect:/"; //홈
	}
	
	
	
		//로그인 구현 -> 권한처리 (인터셉터처리)
	
	
	
	
	
	
	
	
	
	
	
}
