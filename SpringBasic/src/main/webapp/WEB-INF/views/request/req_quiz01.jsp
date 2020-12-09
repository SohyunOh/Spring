<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	<%--
	맵핑
	1.RequestController에 현재 파일의 화면 처리를 하는 메서드를 생성.
	2.폼 전송을 처리하는 메서드 생성(login맵핑)
	3.아이디가 abc123, 비밀번호가 xxx123이라면 req_quiz01_ok.jsp 로 화면 이동
	4.아니라면 req_quiz01_no.jsp로 화면이동 
	--%>

	<form action="login" method="post">
		ID:<input type="text" name="id"><br>
		PW:<input type="password" name="pw"><br>
		<input type="submit" value="로그인" >
	</form>
	
	
</body>
</html>