<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie 연습</title>
</head>
<body>
	
	<a href="<%=request.getContextPath()%>/cookieAdd.do">Cookie 정보 저장하기</a> <br> <!-- 이렇게 만들고, src폴더 아래에 cookie 패키지 안에 CookieAddTest servlet 만든거 -->
	<a href="<%=request.getContextPath()%>/cookieRead.do">Cookie 정보 읽어오기</a> <br>
	<a href="<%=request.getContextPath()%>/cookieDelete.do">Cookie 정보 삭제하기</a> <br>
	
</body>
</html>