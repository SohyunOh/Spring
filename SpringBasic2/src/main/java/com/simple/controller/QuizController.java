package com.simple.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	//quiz01  화면처리
	@RequestMapping("quiz01")
	public String quiz01() {
		return "/quiz/quiz01";
	}
	
	@RequestMapping(value = "/sendBirth", method = RequestMethod.POST)
	public String sendBirth(@ModelAttribute("info") Quiz01VO vo) {
		System.out.println(vo.getYear()+vo.getMonth()+vo.getDay());
		return "quiz/quiz01_ok";
	}

	
	//quiz02  화면처리
	@RequestMapping("quiz02")
	public String quiz02() {
		return "/quiz/quiz02";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join (@ModelAttribute("info") Quiz01VO vo) {
		return "quiz/quiz02_ok";
	}
	
	//quiz03  화면처리
//	@RequestMapping("quiz03")
//	public String quiz03() {
//		return "/quiz/quiz03";
//	}
//	
//	@RequestMapping(value = "/join2", method = RequestMethod.POST)
//	public String join2 (@RequestParam("id") String id,
//						 @RequestParam("pw") String pw,
//						 @RequestParam("pw_check") String pw_check,
//						 	RedirectAttributes RA,
//						 	Model model
//						) {
//		
//		if(id=="") {
//			RA.addFlashAttribute("msg", "아이디를 입력하세요");
//			return "redirect:/quiz/quiz03";
//
//		}else if (!(pw.equals(pw_check))){
//			RA.addFlashAttribute("msg", "비밀번호를 확인하세요");
//			return "redirect:/quiz/quiz03";
//		}else {
//			
//			model.addAttribute("id", id);
//			return "quiz/quiz03_ok";
//		}
//		
//	}
//	
	//======풀이====
	
//	 quiz01, quiz02, quiz03 화면 동시 처리
//	반환유형 void 형으로 맞추고 맵핑값을 배열로 전달하면
//	 뷰에 대한 처리에 한에서만 배열로 사용이 가능
	@RequestMapping({"/quiz01", "/quiz02", "/quiz03"})
	public void views() {
		
	}
	
	@RequestMapping("/join2")
	public String join2 ( @RequestParam(value = "id", required = false, defaultValue = "") String id,
							@RequestParam(value = "pw") String pw ,
							@RequestParam(value = "pw_check") String pw_check,
							RedirectAttributes RA,
							Model model
			) {
		if(id.equals("")) {
			RA.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";

		}else if (!pw.equals(pw_check)){
			RA.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		}else {//정상처리된 경우
			model.addAttribute("id", id);// 다음 화면 으로 id를 넘김
			return "quiz/quiz03_ok";
		}
	}
	
	
}
