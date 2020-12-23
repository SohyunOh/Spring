<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>누구나 접근 가능한 가입페이지</h2>

	<form action="joinForm" method="post">
		아이디 : <input type="text" name="id"><br>
		비밀번호: <input type="password" name="pw"><br>
		이름:<input type="text" name="name"><br>
		<input type="submit" value="가입">
	</form>

</body>
</html>