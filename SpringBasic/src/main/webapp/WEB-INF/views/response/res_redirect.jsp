<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>리다이렉트 확인하기</h2>

	<form action="login" method="post"> 
		ID: <input type="text" name="id"> <br/>
		PW: <input type="password" name="pw"> <br/>
		<span>${msg }</span>
		<button type="submit">로그인</button>
	</form>
	
</body>
</html>