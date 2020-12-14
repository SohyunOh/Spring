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
	1.BoardServiceController 를 생성하세요. 
	2.다음 화면을 처리하는 메서드를 컨트롤러 에 생성하세요 
	3.폼 태그 요청을 처리하는 메서드를 생성하세요.
	4.service계층 - DAO계층 연동을 통해 게시글을 등록하는 작업을 처리하세요.
	5.등록 후에는 boardResult 페이지로 이동하세요.
	--%>
	
	<h2>게시글 등록 (화면 URL요청: 컨패스/service/boardRegister)</h2>
	<form action="boardForm" method="post">

		작성자:<input name="name"><br>
		제목:<input name="title"><br>
		내용:<textarea rows="3" name="content"></textarea><br>
		
		<input type="submit" value="등록">
		
		<%--
		1.boardList 요청을 처리하는 메서드를 컨트롤러에 생성하세요. 
		2.service계층 -DAO계층 연동을 통해 게시글 목록을 가지고 boardList 페이지로 이동하세요.
		3.boardList 페이지에서는 게시글 목록을 화면에 출력하세요
		--%>
		<input type="button" value="목록" onclick="location.href='????'">
	</form>


</body>
</html>