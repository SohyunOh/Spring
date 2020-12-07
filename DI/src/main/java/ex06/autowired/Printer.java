package ex06.autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class Printer {

	
	/*
	 * @Autowired- 자동주입 명령
	 * 타입으로 주입 -> id 이름으로 주입
	 * -생성자, 세터, 멤버변수에 사용이 가능
	 */
	
	
	private Document document;

	//생성자
	@Autowired
	public Printer(Document document) {
		super();
		this.document = document;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	
	
	
}
