package ex07.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {

			
			GenericXmlApplicationContext ctx = 
					new GenericXmlApplicationContext("autowired-context.xml");
			
			Computer com = ctx.getBean(Computer.class);
			com.ComouterInfo();
			
			
			
	}

}
