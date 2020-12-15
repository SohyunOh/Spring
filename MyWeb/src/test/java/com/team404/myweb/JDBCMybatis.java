package com.team404.myweb;

import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/springconfig/DB-context.xml")

public class JDBCMybatis {

	
	@Autowired
	private SqlSessionFactoryBean sql;
	
	public void test() {
		System.out.println(sql);
	}
}
