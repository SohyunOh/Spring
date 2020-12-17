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
import com.team404.common.util.Criteria;
import com.team404.common.util.PageVO;
import com.team404.freeboard.service.FreeBoardService;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired
	@Qualifier("freeBoardService")
	private FreeBoardService freeBoardService;
	
	
	//글 목록
	@RequestMapping("/freeList")
	public String freeList(Model model, Criteria cri) {
		
		//화면으로 넘어갈 때 글정보를 가지고 갈수 있도록 처리 getList()로 조회한 결과를 리스트화면에 출력.
		
		//1.기본방식		
		//ArrayList<FreeBoardVO> list = freeBoardService.getList();
		//model.addAttribute("list", list);
		
		//2.페이지방식
//		int total = freeBoardService.getTotal();
//		System.out.println(total);
//		PageVO pageVO = new PageVO(cri, total);
//		ArrayList<FreeBoardVO> list = freeBoardService.getList(cri);
		
		//3.검색 과 페이지
//		System.out.println(cri.toString());
		
		ArrayList<FreeBoardVO> list = freeBoardService.getList(cri);
//		System.out.println(list.toString());
		
		
		int total = freeBoardService.getTotal(cri);//전체 게시물 수 
//		System.out.println(total);
		PageVO pageVO = new PageVO(cri, total);
		
		
		//화면에 전달할 값
		model.addAttribute("list", list);
		model.addAttribute("pageVO", pageVO);
		
		
		return "freeBoard/freeList";
	}
	
	
	
	
	

	
	//글 등록 화면
	@RequestMapping("/freeRegist")
	public String freeRegist() {
		return "freeBoard/freeRegist";
	}
	
	//글 등록
	@RequestMapping(value = "/registForm", method = RequestMethod.POST)
	public String registForm(FreeBoardVO vo, RedirectAttributes RA) {
		
		freeBoardService.regist(vo); //insert실행
		RA.addFlashAttribute("msg", "정상적으로 등록처리 되었습니다"); //메시지를 리스트 화면으로 전달

		return "redirect:/freeBoard/freeList";
	}
	
//	//글상세
//	@RequestMapping(value = "/freeDetail", method = RequestMethod.GET)
//	public String freeDetail(@RequestParam("bno") int bno, Model model) {
//		
//		//화면으로 넘어갈때 bno기반의 데이터를 가지고 상세화면으로 가도록 getContent()로 처리
//		FreeBoardVO vo = freeBoardService.getContent(bno);
//		model.addAttribute("vo", vo); //bno게시글에 대한 정보
//		
//		return "freeBoard/freeDetail";
//	}
//	
//	//글변경화면
//	@RequestMapping(value = "/freeModify", method = RequestMethod.GET)
//	public String freeModify(@RequestParam("bno") int bno, Model model ) {
//		
//		//화면으로 넘어갈때 bno기반의 데이터를 가지고 상세화면으로 가도록 getContent()로 처리
//		FreeBoardVO vo = freeBoardService.getContent(bno);
//		model.addAttribute("vo", vo); //bno게시글에 대한 정보
//		
//		return "freeBoard/freeModify";
//	}
	
	//상세화면과 변경화면이 기능이 같기 때문에 하나로 묶어서 사용합니다.
	@RequestMapping(value = {"/freeDetail", "/freeModify"}, method = RequestMethod.GET)
	public void freeModify(@RequestParam("bno") int bno, Model model ) {
		
		//화면으로 넘어갈때 bno기반의 데이터를 가지고 상세화면으로 가도록 getContent()로 처리
		FreeBoardVO vo = freeBoardService.getContent(bno);
		model.addAttribute("vo", vo); //bno게시글에 대한 정보

		//void형 메서드는 요청의 결과가 디스패쳐서블릿으로 return됩니다.
	}
	
	//글 업데이트
	@RequestMapping(value = "/freeUpdate", method = RequestMethod.POST)
	public String freeUpdate(FreeBoardVO vo, RedirectAttributes RA) {
		
		int result = freeBoardService.update(vo);		
		
		if(result == 1) { //업데이트 성공
			RA.addFlashAttribute("msg", "정상적으로 수정되었습니다");
		} else { //업데이트 실패
			RA.addFlashAttribute("msg", "수정에 실패했습니다");
		}
		
		return "redirect:/freeBoard/freeList";
	}
	
	
	@RequestMapping(value = "/freeDelete", method = RequestMethod.POST)
	public String freeDelete(@RequestParam("bno") int bno, RedirectAttributes RA) {
		
		int result = freeBoardService.delete(bno);
		
		if(result == 1) {
			RA.addFlashAttribute("msg", bno + "번 게시글이 삭제 되었습니다");
		} else {
			RA.addFlashAttribute("msg", "게시글 삭제에 실패했습니다");
		}
		
		return "redirect:/freeBoard/freeList";
	}
	
	
}







