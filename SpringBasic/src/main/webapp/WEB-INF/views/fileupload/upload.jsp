<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 파일 업로드 폼태그의  enctype 을multipart/form-data으로 반드시 설정 -->
	
	<form action="upload_ok" method="post" enctype="multipart/form-data">
		파일설정: <input type="file" name="file"><br/>
		<input type="submit" value="확인">
	</form>
	<hr/>
	
	<!-- 여러파일 업로드 : multifle 옵션사용 -->
	<form action="upload_ok2" method="post" enctype="multipart/form-data">
		다중파일선택: <input type="file" name="files" multiple="multiple"><br/>
		<input type="submit" value="확인">
	</form>
	<hr/>
	
	<!-- 여러파일 업로드 : 복수태그방법 -->
	<form action="upload_ok3" method="post" enctype="multipart/form-data">
		파일선택: <input type="file" name="file"><br/>
		파일선택: <input type="file" name="file"><br/>
		파일선택: <input type="file" name="file"><br/>
		<input type="submit" value="확인">
		
	</form>
	
	<!-- 가변적인 폼일 경우 -->
	<form action="upload_ok4" method="post" enctype="multipart/form-data">
		<input type="text" name="List[0].name">
		파일선택 : <input type="file" name="List[0].file"><br/>
		
		<input type="text" name="List[1].name">
		파일선택 : <input type="file" name="List[1].file"><br/>
		
			<input type="text" name="List[2].name">
		파일선택 : <input type="file" name="List[2].file"><br/>
		
		
		<input type="submit" value="확인">
	</form>
	
	
	
	
	
	
</body>
</html>