package com.simple.basic;

import org.junit.Test;


interface Car {
	public void run(); //반드시 구현해야하는 추상메서드
}

class Tico implements Car{
	@Override
	public void run() {
		System.out.println("티코생성");
	}
}


public class JDBCAnomymous {

	@Test
	public void test() {
		
		Car car = new Car() {
			@Override
			public void run() {
				System.out.println("익명클래스 티코");
			}
		};
		
		car.run();

	}
	
}
