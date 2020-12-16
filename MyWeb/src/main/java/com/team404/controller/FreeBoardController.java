package com.team404.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team404.command.FreeBoardVO;
import com.team404.freeboard.service.FreeBoardService;

import oracle.net.aso.m;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {


	@Autowired
	@Qualifier("freeBoardService")
	private FreeBoardService freeBoardService;

	//글 목록
	@RequestMapping("/freeList")
	public String freeList(Model model) {
		//화면으로 넘어갈 때 들 정보를 가지고 갈 수 있도록 처리 getList()로 조회한 결과를 리스트화면에 출력

		ArrayList<FreeBoardVO> list = freeBoardService.getList();
		model.addAttribute("list", list);

		return "freeBoard/freeList";
	}


	//글 등록 화면
	@RequestMapping("/freeRegist")
	public String freeRegist() {
		return "freeBoard/freeRegist";
	}

	//글 등록
	@RequestMapping(value="/registForm", method = RequestMethod.POST)
	public String registForm(FreeBoardVO vo,
			RedirectAttributes ra) {

		freeBoardService.regist(vo);
		ra.addFlashAttribute("msg", "정상적으로 등록처리 됐습니다");//메시지를 리스트화면으로 전달

		return "redirect:/freeBoard/freeList";
	}

	//	//글 상세
	//		@RequestMapping(value = "/freeDetail", method = RequestMethod.GET)
	//		public String freeDetail(@RequestParam("bno") int bno , Model model) {
	//			
	//			// 화면으로 넘어갈 때 bno 기반의 데이터를 가지고 상세화면으로 가도록 getContent()로 처리 
	//			
	//			FreeBoardVO vo = freeBoardService.getContent(bno);
	//			System.out.println(vo.toString());
	//			model.addAttribute("vo", vo); //bno게시글
	//			
	//			return "freeBoard/freeDetail";
	//		}
	//		
	//글변경화면 -- 글 상세랑 기능이 같음
	//		@RequestMapping(value = "/freeModify", method = RequestMethod.GET)
	//		public String freeModify(@RequestParam("bno") int bno , Model model){
	//			
	//			FreeBoardVO vo = freeBoardService.getContent(bno);
	//			System.out.println(vo.toString());
	//			model.addAttribute("vo", vo); //bno게시글
	//			
	//			return "freeBoard/freeModify";
	//		}

	//글수정 글상세의 기능이 같아서 하나로 묶음.
	@RequestMapping(value={"/freeModify", "/freeDetail"}, method = RequestMethod.GET)
	public void freeModify(@RequestParam("bno") int bno,
			Model model) {
		FreeBoardVO vo = freeBoardService.getContent(bno);
		model.addAttribute("vo", vo);	

		//void형 메서드는 요청의 결과가 디스패쳐 서블릿으로 return됩니다.			
	}

	//글 업데이트
	@RequestMapping(value = "/freeUpdate", method = RequestMethod.POST)
	public String freeUpdate(FreeBoardVO vo, RedirectAttributes RA){

		int result = freeBoardService.update(vo);

		if(result == 1) { //업데이트 성공
			RA.addFlashAttribute("msg", "정상적으로 수정");
		}else {
			RA.addFlashAttribute("msg", "수정에 실패했습니다");
		}
		return "redirect:/freeBoard/freeList";

	}
	//글 삭제
	@RequestMapping(value = "/freeDelete", method = RequestMethod.POST)
	public String freeDelete(@RequestParam("bno") int bno, RedirectAttributes RA){
		int result	= freeBoardService.delete(bno);

		if(result == 1) { //삭제 성공
			RA.addFlashAttribute("msg", bno+ "번 게시물이 삭제 되었습니다");
		}else {
			RA.addFlashAttribute("msg", "게시글 삭제에 실패했습니다");
		}
		return "redirect:/freeBoard/freeList";


	}
}


