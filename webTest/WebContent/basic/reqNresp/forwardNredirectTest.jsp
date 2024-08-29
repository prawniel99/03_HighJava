<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	
	</head>
	
	<body>
	
		<h3>forward, redirect 연습</h3>
		<hr>
		<form action="<%=request.getContextPath()%>/forwardTest.do" method="post">
			forward 방식: <input type="text" name="username">
			<input type="submit" value="전송">
		</form>
		<br><hr>
	
		<form action="<%=request.getContextPath()%>/redirectTest.do" method="post">
			redirect 방식: <input type="text" name="username">
			<input type="submit" value="전송">
		</form>
		<br><hr><br>
	
	</body>
</html>