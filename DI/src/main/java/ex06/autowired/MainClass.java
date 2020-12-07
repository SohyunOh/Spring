package ex06.autowired;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		
		GenericXmlApplicationContext ctx
		= new GenericXmlApplicationContext("autowired-context.xml");
		
		Printer pt1 = ctx.getBean(Printer.class);
		
		System.out.println(pt1.getDocument().data);

		
		
	}

}
