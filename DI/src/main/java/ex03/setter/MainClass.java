package ex03.setter;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	
	
	public static void  main(String[] args){
//		DatabaseDev db = new DatabaseDev();
//		db.setUrl("데이터베이스주소~");
//		db.setUid("아이디");
//		db.setUpw("비번");
//		
//		MemberDAO dao = new MemberDAO();
//		dao.setDs(db);
//		
//		dao.info();
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("application-context.xml");
		
		// DatabaseDev 확인
		DatabaseDev db = ctx.getBean(DatabaseDev.class);
		
		System.out.println(db.getUrl());
		// MemberDAO 확인
		
		MemberDAO dao = ctx.getBean(MemberDAO.class);
		dao.info();
		
	}

	
	
	
}
