<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>이미지 처리하기</h2>
	<img src="<%=request.getContextPath()%>/images/cat-jump.png" width="300px"><br><br>
	<img src="d:/d_other/images/cat-jump.png" width="300px"><br><br> <!-- 이렇게는 안됨 -->
	
	<img src="<%=request.getContextPath()%>/images/imageView.do?fileno=2" width="300px"><br><br>
</body>
</html>