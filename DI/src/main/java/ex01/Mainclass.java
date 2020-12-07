package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Mainclass {

	public static void main(String[] args) {
		
//		SpringText st = new SpringText();
//		st.test();
		
		GenericXmlApplicationContext ctx
		= new GenericXmlApplicationContext("application-context.xml");

		
		SpringTest st = ctx.getBean(SpringTest.class);
		
		st.test();
		
		//스트링 설정파일에서 반을 사용할 떄마다 기본적으로 싱글톤형식을 가지고 잇씁니다.
		SpringTest st2 = ctx.getBean(SpringTest.class);
		System.out.println(st == st2);
	}

}
