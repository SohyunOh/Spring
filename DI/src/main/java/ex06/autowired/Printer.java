package ex06.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Printer {
	
	/*
	@Autowired - 자동주입 명령
	타입으로 주입 -> id이름으로 주입
	- 생성자, 세터, 멤버변수에 사용이 가능합니다.
	
	required = false옵션은 
	스프링이 주입할 빈이 없으면 자동으로 에러를 발생시키는데,
	이를 무시하고 지나가 주세요. 라는 속성입니다
	
	Qualifier - 빈 강제 연결
	컨테이너 안에 객체가 여러개 있을 때 id이름으로 강제 연결해주는 어노테이션.
	
	*/

	@Autowired(required = false)
	@Qualifier("xxxxxx")
	private Document document;
	
	//기본생성자
	public Printer() {}
	
	//생성자
	public Printer(Document document) {
		super();
		this.document = document;
	}
	
	public void setDocument(Document document) {
		this.document = document;
	}

	//게터, 세터
	public Document getDocument() {
		return document;
	}

	
}
