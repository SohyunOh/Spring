package com.team404.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team404.command.FreeBoardVO;

import lombok.experimental.PackagePrivate;

@RestController //RequestBody + @ResponeBody 이 합쳐진 형태의 어노테이션
public class RestBasicController {

	//1. RestController는 기본적으로 return값이 리졸버 뷰로 전달되는게 아니라, 요청된 주소로 반환됩니다.
	//produces(생산자)는 타입을 지정해주면, 해당 타입으로 사용자에게 응답하겟다는 뜻 -- 단반향의 보내는측
	@GetMapping(value = "/getTest" ,produces = "test/plain; charset=utf-8")
	public String  getTest() {
		
		System.out.println("Rest API 실행됨");
		
		return "안녕하세요";
	}
	
	//객체반환 (produces는 객체를 보낼 때 기본형으로 json 형태을 가집니다)
	//jackson-data-bind가 반드시 필요
	@GetMapping("/getObject" )
	public FreeBoardVO getObject() {
		
		return new FreeBoardVO(10, "헬로", "테스트", "테스트", null, null);
	}
	
	//값을 받고 객체형태로 반환A
	//get방식에서는 requestParam읋 필수값을 지정해줄수 있습니다.
	//http://localhost:8282/myweb/getCollection?bno=1
	@GetMapping("/getCollection")
	public ArrayList<FreeBoardVO> getCollection(@RequestParam("key") String key,
												@RequestParam("bno") int bno ){
		System.out.println("브라우저애서 넘어온 값:" + key); //필수값이 됨
		System.out.println("브라우저애서 넘어온 값:" + bno); //필수값이 됨
		ArrayList<FreeBoardVO> list = new ArrayList<>();
		for(int i =1;i <=10; i++ ) {
			FreeBoardVO vo = new FreeBoardVO();
			vo.setBno(i);
			vo.setTitle("테스트"+i);
			vo.setContent("테스트"+i);
			list.add(vo);
		}
		return list; 
	}
	
	// 값/값/값 url형식으로 받고 Map 을 반환
	//http://localhost:8282/myweb/getPath/desc/23/sdf
	@GetMapping("/getPath/{sort}/{rank}/{page}")
	public HashMap<String, Object> getPath(@PathVariable("sort") String sort,
											@PathVariable("rank") String rank,
											@PathVariable("page") String page){
		System.out.println(sort);
		System.out.println(rank);
		System.out.println(page);
		//....처리
		
		HashMap<String, Object> map = new HashMap<>();
		FreeBoardVO vo = new FreeBoardVO(1, "테스트", "테스트" , "테스트", null, null);
		map.put("info",vo);
				
		return map;
	}
	
	
	//post 형식의 Json형식의 값을 받음, 객체로 반환
	//1. 화면에서 json 형식으로넘어올때 데이터를 @RequestBody 어노테이션으로 맵핑
	//2.화면에서는 데이터보낼 때 Content-Type을 선언해서 제이터의 유형을 알려줘야합니다
	//http://localhost:8282/myweb/getJson
	
	//크로스도메인정책 - 서버가 다른 경우 , 스프링은 기본적으로 받아주지 않는데, 이런 요청을 허용시키는 옵션입니다
	@CrossOrigin(origins = "http://127.0.0.1:5502")//@CrossOrigin(origins="*")//어떵 요청이든 허용-- 전세계 오픈
	@PostMapping("/getJson")
	public ArrayList<FreeBoardVO> getJson(@RequestBody FreeBoardVO vo){
		
		System.out.println(vo.toString());
		
		//...처리
		ArrayList<FreeBoardVO> list = new ArrayList<>();
		FreeBoardVO fvo = new FreeBoardVO();
		fvo.setTitle("반환결과입니다");
		list.add(fvo);
		
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
}
