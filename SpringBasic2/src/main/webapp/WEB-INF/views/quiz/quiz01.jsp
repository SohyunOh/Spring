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

	<%--
	1. QuizController에는 /quiz 폴더 아래의 모든 요청을 처리할 수 있는 컨트롤러를 생성하세요
	2. quiz01  화면처리를 할 수 있는 메서드를 생성 (quiz01 맵핑)
	3. 다음 생년월일을 받아서 콘솔에 출력하는 메서드를 생성 (sendBirth 맵핑)
		조건) Quiz01VO 커맨드객체 사용, 콘솔에 전송된 값을 붙여서 출력합니다 ex)20180615
	4. 출력후엔 quiz01_ok 페이지에 "당신의 생일은 ~~~~년 ~~월 ~~일" 을 출력하세요
	--%>
	
	<h2>quiz화면(화면 URL요청: /quiz/quiz01)</h2>
	<form action="sendBirth" method="post">
		생년월일:<br>
		<input type="text" name="year" maxlength="4" size="4" placeholder="년(4자)">
		<select name="month">
			<c:forEach var="i" begin="1" end="12">
				<option>${i }</option>
			</c:forEach>
		</select>
		<input type="text" name="day" maxlength="2" size="4" placeholder="일">
		
		<input type="submit" value="전송">
	</form>
</body>
</html>