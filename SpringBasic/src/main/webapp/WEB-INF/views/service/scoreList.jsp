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
	
	<h2>점수 결과 확인</h2>
	
	<c:forEach var="vo" items="${list }" varStatus="num"> <!-- var변수의 상태 -->
		번호:${vo.num }
		이름:${vo.name }
		국어:${vo.kor }
		영어:${vo.eng }
		수학:${vo.math }
		<button type="button" onclick="location.href='scoreDelete?num=${vo.num }' ">점수삭제</button>
		<br/>
	</c:forEach>
	
	<a href="scoreRegist">점수추가 등록</a>
	

	
	 
</body>
</html>