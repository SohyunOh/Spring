package ex04.quiz;

import org.springframework.context.support.GenericXmlApplicationContext;

import ex03.setter.DatabaseDev;

public class MainClass {

	public static void main(String[] args) {
		// Car, Airplane 빈을 생성하고, 아무 베터리나 의존성 주입
		//각 객체 안에 있는 베터리를 자바 틀래스에서 출력

		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("application-context.xml");
		
		Car car = ctx.getBean(Car.class);
		
		Airplane ap = ctx.getBean("ap", Airplane.class);
		
		car.getBattery().energy();
		
		
	}

}
