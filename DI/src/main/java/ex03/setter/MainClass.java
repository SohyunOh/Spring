package ex03.setter;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		//MemberDAO가 DatabaseDev에 의존적이다.
//		DatabaseDev db = new DatabaseDev();
//		db.setUrl("데이터베이스주소~~~");
//		db.setUid("아이디");
//		db.setUpw("비밀번호");
//		
//		MemberDAO dao = new MemberDAO();
//		dao.setDs(db);
//		dao.info();
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("application-context.xml");
		
		//DatabaseDev확인
		DatabaseDev db = ctx.getBean(DatabaseDev.class);
		System.out.println(db.getUrl() );
		
		//memberDAO확인
		MemberDAO dao = ctx.getBean(MemberDAO.class);
		dao.info();
		
	}
}
