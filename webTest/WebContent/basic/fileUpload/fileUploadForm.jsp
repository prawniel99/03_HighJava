<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>File Upload 연습</h3>
		<!-- 파일 업로드할때 form의 method는 항상 post. form 뒤에 붙인거 세가지 전부 must -->
		<form method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/fileUpload.do">
			작성자 이름: <input type="text" name="username"><br><br>
			<!-- input type file 이게 파일 올리기 기본 -->
			한 개 파일 선택: <input type="file" name="upFile1"><br><br>
			여러개 파일 선택: <input type="file" name="upFile2" multiple="multiple"><br><br>
			<input type="submit" value="전송">
		</form>
	</body>
</html>