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
	1. quiz03 파일의 화면처리를 할 수 있는 메서드를 생성하세요. (res_quiz01 맵핑)
	2. 폼태그의 맵핑은 join2 으로 맵핑하세요.
	3. 아이디가 적지 않았다면 이라면 quiz03화면으로 이동해서 화면에 "아이디를 입력하세요" 출력
	4. 비밀번호와 비밀번호 체크가 다르다면 quiz03화면으로 이동해서 "비밀번호를 확인하세요" 출력
	5. 정상적으로 처리된경우라면 quiz03_ok로 이동해서 "id님 회원가입을 축하합니다" 출력
	
	6. 힌트:문자열 비교는 equals()를 이용, RedirectAttribute 이용 
	--%>
 
	<form action="join2" method="post">
		ID: <input type="text" name="id" size="10"><br>
		비밀번호 : <input type="password" name="pw" size="10"><br>
		비밀번호 확인: <input type="password" name="pw_check" size="10"><br>
		<span>${msg }</span>
		<input type="submit" value="로그인">
	</form>

</body>
</html>


