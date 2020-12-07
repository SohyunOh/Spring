package ex02.construct;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		//호텔은 생성될때 반드시 Chef 를 필요로 한다
		//호텔 -> 한테 의존적이다
		
//		Chef c = new Chef();
//		
//		Hotel h = new Hotel(c);
//		
//		h.getChef().cookin();
//	

		
			GenericXmlApplicationContext ctx =
					new GenericXmlApplicationContext("application-context.xml");
		
			Hotel h = ctx.getBean(Hotel.class);
			h.getChef().cookin();
	}

}
