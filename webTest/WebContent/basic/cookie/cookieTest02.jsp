<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방문 기록</title>

<style>
	body {
		margin: 0;
		padding: 0;
	}
	div {
		position: relative;
		margin: 0;
		padding: 0;
	}
	#div1 {
		width: 100%;
		height: 260px;
	}
	#div2 {
		left: 0;
		width: 100%;
		height: 1000px;
		background-color: rgb(0,98,65);
		color: white;
		font-size: 50px;
	}
</style>
</head>
<body>
	<div id="div1">
	
	</div>
	
	<div id="div2">
	
		<a href="<%=request.getContextPath()%>/visitCount.do">Cookie Count<br>증가 하기</a> <br><br><br><br>
		<a href="<%=request.getContextPath()%>/visitReset.do">Cookie Count<br>초기화 하기</a> <br>
	</div>
</body>
</html>