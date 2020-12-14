<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>점수등록</h2>
	<form action="scoreForm" method="post">
		이름:<input type="text" name="name"> <br/>
		국어:<input type="text" name="kor"> <br/>
		영어:<input type="text" name="eng"> <br/>
		수학:<input type="text" name="math"> <br/>
		<button type="submit">확인</button>
	</form>

</body>
</html>