package com.simple.basic;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

//스프링 단위 테스트
//pom.xml에서 junit 4.12이상이 있어야 하며, Spring-test가 있어야 합니다.
@RunWith(SpringJUnit4ClassRunner.class) //스프링프레임워크에서 독립적인 테스트환경 제겅
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") //해당파일을 스프링설정파일로 사용
public class JDBCBasic {
	
	@Autowired
	private HikariDataSource ds;
		
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test //해당 메서드만 실행
	public void test() {
		
		 
		try {
			Connection conn = (Connection)ds.getConnection();
			System.out.println(conn); //JDBC코드 작성이 가능....!
			
			
			System.out.println("스프링템플릿객체확인:" + jdbcTemplate);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		 
	}
}
