<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %><!-- 타일즈 라이브러리를 jsp에서 사용 -->    
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>공통 모듈</title>

    <link href="${pageContext.request.contextPath }/resources/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!--개인 디자인 추가-->
    <link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
</head>
<body>
	
	<!-- base 레이아웃을 가지는 타일즈 템플릿(공통부분) -->
	
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
	
	
</body>
</html>