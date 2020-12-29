package com.team404.common.util.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect //AOP 를 적용시킬 클래스
@Component
public class LogAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	//맨앞 * 는 접근제어자를 의미, 맨 뒤에 *는 메서드를 의미
	//@Before("execution(* com.team404.controller.*Controller.*(..))")

	//	@Before("execution(* com.team404.*.service.*ServiceImpl.*(..))")
	public void beforeLog() {
		System.out.println("---메서드 실행 전----");
	}
//	
//	@After("execution(* com.team404.*.service.*ServiceImpl.*(..))")
	public void afterLog() {
		System.out.println("---메서드 실행 후---");
	}
	
	//에러가 발생할 때 동작(throwing = "e") -에러를 처리할 변수
//	@AfterThrowing(pointcut = "execution(* com.team404.*.service.*ServiceImpl.*(..))", throwing = "e")
	public void errorLog(Exception e) {
		
		System.out.println("에러 로그:"+e);
		
	}
	
	
	/*
	<!-- aop 패키지를 로그레벨로 추가 -->
	<logger name="com.team404.common.util.aop">
		<level value="info" />
	</logger>
	*/
	
	
	//Before,After,AfterThrowing 세가지를 한번에 처리할수잇는  Around
	//메서드실행 권한을 가지고ㅡ 카겟베서드랑 접목시켜서 사용
	//규칙 - Object 반환 ,매개변수로 메서드의 실행지점을 결정짓는 ProceedingJoinPoint를 선언합니다.
	@Around("execution(* com.team404.*.service.*ServiceImpl.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) {
		
		long start = System.currentTimeMillis();
		
		logger.info("실행클래스:"+ jp.getTarget());
		logger.info("실행메서드:"+ jp.getSignature().toString());
		logger.info("매개값:"+ Arrays.toString(jp.getArgs()));
		
		Object result = null;
		try {
			result = jp.proceed();//타겟 메서드의 실행
		} catch (Throwable e) {
			//...에러 로그 출력
//			System.out.println("에러로그:" + e);
			e.printStackTrace();
		} 
		long end = System.currentTimeMillis();
		logger.info("메서드  소요시간:" + (end - start) * 0.001);
		return result;//proceed()의 결과를 반환해야 메서드의 정상 흐름으로 돌아갑니다
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
}
