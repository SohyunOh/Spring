package com.team404.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team404.command.SnsBoardVO;
import com.team404.command.UserVO;
import com.team404.snsboard.service.SnsBoardService;

@Controller
@RequestMapping("/snsBoard")
public class SnsBoardController {
	
	@Autowired
	@Qualifier("snsBoardService")
	private SnsBoardService snsBoardService;
		

	@RequestMapping("/snsList")
	public String snsList() {
		return "snsBoard/snsList";
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file,
						 @RequestParam("content") String content, 
						 HttpSession session) {
		
		try {
			
			UserVO userVO = (UserVO)session.getAttribute("userVO");
			String writer = userVO.getUserId(); //작성자정보
			
//			System.out.println(file);
//			System.out.println(content);
			
			//1. 날짜별로 폴더로 관리
			Date date  = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String fileLoca = sdf.format(date);
						
			//2. 저장할 폴더
			String uploadPath = "D:\\spring\\upload\\" + fileLoca;
			
			File folder = new File(uploadPath);
			if(!folder.exists() ) {
				folder.mkdir(); //폴더생성
			}
			
			//3. 서버에 저장할 파일 이름
			String fileRealName = file.getOriginalFilename(); //파일이름 
			Long size = file.getSize(); //파일사이즈
			String fileExtension = fileRealName.substring( fileRealName.lastIndexOf(".") , fileRealName.length()); //확장자
						
			UUID uuid = UUID.randomUUID();
			String uuids = uuid.toString().replaceAll("-", "");
			
			String fileName = uuids + fileExtension ;//변경해서 저장할 파일이름
			
			System.out.println("=================");
			System.out.println("저장할폴더:" + uploadPath);
			System.out.println("파일실제이름:" + fileRealName);
			System.out.println("파일사이즈:" + size);
			System.out.println("파일확장자:" + fileExtension);
			System.out.println("변경해서저장할파일명:" + fileName);
			
			//4. 파일 업로드처리
			File saveFile = new File(uploadPath + "\\" + fileName);
			file.transferTo(saveFile); //스프링의 업로드처리
			
			//5. DB에 insert작업
			SnsBoardVO vo = new SnsBoardVO(0, writer, content, uploadPath, fileLoca ,fileName, fileRealName, null);
			boolean result = snsBoardService.insertFile(vo); //성공시 true, 실패시 false
			
			if(result) { //성공
				return "success";
			} else {
				return "fail";
			}
			
			
		} catch (NullPointerException e) {
			System.out.println("세션정보가 없음");
			return "fail";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}

	}
	
	
	@RequestMapping("/getList")
	@ResponseBody
	public ArrayList<SnsBoardVO> geList(){
		
		ArrayList<SnsBoardVO> list = snsBoardService.getList();
		
		System.out.println(list.toString());
		
		
		return list;
		
	}
	
	//이미지처리 메서드
	/*
	@RequestMapping("/display/{fileLoca}/{fileName:.+}") //fileName뒤에 특수문자를 받는 문법
	@ResponseBody
	public byte[] display(@PathVariable("fileLoca") String fileLoca,
						  @PathVariable("fileName") String fileName) {
		
		System.out.println(fileLoca);
		System.out.println(fileName);
		
		String uploadPath = "D:\\course\\spring\\upload\\" + fileLoca;
		
		//참조할 경로
		File file = new File(uploadPath + "\\" + fileName);
		
		byte[] result = null;
		try {
			//스프링에서 파일데이터를 복사해서 바이트배열타입으로 리턴해주는 메서드
			result = FileCopyUtils.copyToByteArray(file);
		
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
	*/
	@RequestMapping("/display/{fileLoca}/{fileName:.+}") //fileName뒤에 특수문자를 받는 문법
	@ResponseBody
	public ResponseEntity<byte[]> display(@PathVariable("fileLoca") String fileLoca,
						  @PathVariable("fileName") String fileName) {
		
		System.out.println(fileLoca);
		System.out.println(fileName);
		
		String uploadPath = "D:\\spring\\upload\\" + fileLoca;
		
		//참조할 경로
		File file = new File(uploadPath + "\\" + fileName);
		
		
		ResponseEntity<byte[]> result = null;		
		try {
			//1. 헤더정보
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath() )); //컨텐츠타입: 해당 경로 파일에 마임타입을 저장
			
			//2. body에 담을 내용
			//스프링에서 파일데이터를 복사해서 바이트배열타입으로 리턴해주는 메서드
			byte[] arr = FileCopyUtils.copyToByteArray(file);
		
			result = new ResponseEntity<byte[]>(arr, header, HttpStatus.OK); //(바디에 담을 데이터, 헤더정보, 상태코드)
					
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	//다운로드 - 비동기처리
	@RequestMapping("/download/{fileLoca}/{fileName:.+}")
	@ResponseBody
	public ResponseEntity<byte[]> download(@PathVariable("fileLoca") String fileLoca,
						   @PathVariable("fileName") String fileName) {
		
		
		String uploadPath = "D:\\spring\\upload\\" + fileLoca;
		//참조할 경로
		File file = new File(uploadPath + "\\" + fileName);
		
		//파일 다운로드는 응답문서에 브라우저가 어떻게 처리해야되는지에 대한 내용을 담아서 보냅니다.
		ResponseEntity<byte[]> result = null;
		try {
			//1. Content-Disposition이 attachment인 경우 파일 다운로드가 실행됩니다.
			//브라우저 마다 Content-Disposition의 작성내용이 조금씩 다릅니다.
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Disposition", "attachment; filename=" + fileName );
			
			//2. 바디에 담을 데이터
			byte[] arr = FileCopyUtils.copyToByteArray(file);
			
			result = new ResponseEntity<byte[]>(arr, header, HttpStatus.OK);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
//		byte[] result = null;
//		try {
//			result = FileCopyUtils.copyToByteArray(file);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
						
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}