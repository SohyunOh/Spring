<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	1.QuizController에 화면처리 메서드 생성	
	2.폼 처리 메서드 생성
	3.입력한 정보를 quiz02_ok.jsp 화면에 출력
	4.방법 (VO객체를 이용하도록)
	 --%>
	<h2>회원가입</h2>
	<form action="join" method="post">
		아이디:<input type="text" name="id"><br>
		비밀번호:<input type="password" name="pw"><br>
		이름:<input type="text" name="name"><br>
		이메일:<input type="email" name="email"><br>
		<input type="submit" value="회원가입">
	</form>
	
	
</body>
</html>