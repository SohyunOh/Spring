<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>모델(model) 전달자</h2>
	
	<a href="res_ex02">res_ex02로 이동</a>
	<a href="res_ex03">res_ex03로 이동</a>
	<a href="res_ex04?num=1&name=홍길자">res_ex04로 이동</a>
	
	
	<form action="res_ex05">
		이름:<input type="text" name="id"> <br>
		이름:<input type="text" name="name"> <br>
		
		<button type="submit">확인</button>
	</form>

</body>
</html>