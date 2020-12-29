package com.simple.controller;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.MultipartFilter;

import com.simple.command.MultiUploadVO;
import com.simple.command.UploadVO;

import oracle.net.aso.l;

@Controller
@RequestMapping("/fileupload")
public class UploadController {
	
	public static final String UPLOAD_PATH = "D:\\spring\\upload"; 

	//화면처리
	@RequestMapping("/upload")
	public String upload() {
		
		return "fileupload/upload";
	}
	
	@RequestMapping("/upload_ok")
	public String upload_ok(@RequestParam("file") MultipartFile file ) {
		
		try {
			String fileRealName = file.getOriginalFilename();//파일의 실제이름
			long size = file.getSize();//파일 크기
			String fileExtention= fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
			
			System.out.println("파일실제이름:"+fileRealName);
			System.out.println("파일크기"+size);
			System.out.println("파일확장자:"+fileExtention);
			
			
			File saveFile = new File(UPLOAD_PATH+ "\\" + fileRealName);
			file.transferTo(saveFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fileupload/upload_ok";
	}
	
	
	
	//다중파일 처리1
	@RequestMapping("/upload_ok2")
	public String upload_ok2(MultipartHttpServletRequest files ) {

		List<MultipartFile> list =files.getFiles("files"); 
			
		try {
			for(int i =0; i <list.size(); i++) {
				String fileRealName = list.get(i).getOriginalFilename();//파일의 실제이름
				long size = list.get(i).getSize();//파일 크기
				String fileExtention= fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
				
				System.out.println("파일실제이름:"+fileRealName);
				System.out.println("파일크기"+size);
				System.out.println("파일확장자:"+fileExtention);
				
				
				File saveFile = new File(UPLOAD_PATH+ "\\" + fileRealName);
				list.get(i).transferTo(saveFile);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  "fileupload/upload_ok"; 
	}
	
	
	//다중파일처리2
	@RequestMapping("/upload_ok3")
	public String upload_ok3(@RequestParam("file") List<MultipartFile> list) {
		
		try {
			for(int i =0; i <list.size(); i++) {
				// isEmpty - 비어 있으면 논리값 1 ( true )을 반환
				if(!list.get(i).isEmpty()) {//MultipartFile값이 비어있지 않을 때만 실행
					
					
					String fileRealName = list.get(i).getOriginalFilename();//파일의 실제이름
					long size = list.get(i).getSize();//파일 크기
					
					String fileExtention= fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
					
					System.out.println("파일실제이름:"+fileRealName);
					System.out.println("파일크기"+size);
					System.out.println("파일확장자:"+fileExtention);
					
					
					File saveFile = new File(UPLOAD_PATH+ "\\" + fileRealName);
					list.get(i).transferTo(saveFile);
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return  "fileupload/upload_ok"; 
	}
	
	//다중파일처리3
		@RequestMapping("/upload_ok4")
		public String upload_ok4(MultiUploadVO vo) {
			
			//System.out.println(vo.getList().toString());
//			System.out.println(names.toString());
//			System.out.println(files.toString());
			
			List<UploadVO> list = vo.getList();
			
			try {
				for(int i =0 ; i < list.size() ; i++) {
					
					String name = list.get(i).getName();
					String fileRealName = list.get(i).getFile().getOriginalFilename();//파일의 실제이름
					long size = list.get(i).getFile().getSize();//파일 크기
					
					String fileExtention= fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
					
					System.out.println("파일실제이름:"+fileRealName);
					System.out.println("파일크기"+size);
					System.out.println("파일확장자:"+fileExtention);
					
					
					File saveFile = new File(UPLOAD_PATH+ "\\" + fileRealName);
					list.get(i).getFile().transferTo(saveFile);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			return  "fileupload/upload_ok"; 
		}
	
	
}
