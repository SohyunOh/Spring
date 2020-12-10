<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h2>점수결과 확인</h2>
	
	<c:forEach var="i" items="${list}">
		이름: ${i.name }
		국어: ${i.kor }
		영어: ${i.eng }
		수학: ${i.math }
		<br>
	</c:forEach>
	
	
	
</body>
</html>