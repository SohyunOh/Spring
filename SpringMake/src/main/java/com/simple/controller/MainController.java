package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //�ش� ������̼��� �پ��մ� Ŭ������  bean���� ����
public class MainController {
	
	public MainController() {
		System.out.println("������");
	}

	// '/'��û���� ������ �� �ش� �޼��� ����
	@RequestMapping("/")//������ ������� �ִ� ���¿��� �б������� ������
	public String home() {
		System.out.println("�����");
		//�����ų �ڵ带 �ۼ�...
//		return "/WEB-INF/views/home.jsp";//�����ļ������� ��ȯ
	
		return "home";
	}
}
