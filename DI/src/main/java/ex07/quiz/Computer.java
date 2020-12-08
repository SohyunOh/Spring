package ex07.quiz;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Computer {

	//키보드, 마우스 , 모니터에 대한 맴버변수를 만들고, Resource, Autowired를 사용해서 자동주입
	//main에서 computer 의 info기을 확인
	
	@Autowired
	@Qualifier("mouse")
	private Mouse mouse ;
	
	@Autowired
	@Qualifier("monitor")
	private Monitor monitor ;
	

	@Resource(name = "keyboard")
	private Keyboard keyboard;

	public void ComouterInfo() {
		
		mouse.info();
		monitor.info();
		keyboard .info();
	} 
	
	
	
	

}
