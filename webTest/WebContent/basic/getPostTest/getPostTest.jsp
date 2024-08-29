<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	window.onload = function(){
		document.getElementById('getBtn').addEventListener("click", function(){
			location.href = "http://localhost/webTest/servletTest03.do"; // webTest가 context pattern
			// location.href = "/webTest/servletTest03.do"; // webTest 특정 안해주면 기능 안 함
			// location.href = "/servletTest03.do"; // 주소 끝자리를 이걸로 대체하겠다 라는 것. 
			// 하이튼 이거 주소 잘 써줘야 404 지옥에 빠지지 않음.
		});
	}
</script>

</head>
<body>
	<h2>Servlet 요청 연습</h2><br><br><br>
	
	<h3>GET방식 요청1 ==> 링크 방식 (a태그)</h3>
	<a href="http://localhost/webTest/servletTest03.do">GET 방식 요청 1</a>
	<hr><br>
	
	<h3>GET방식 요청2 ==> JavaScript의 location.href속성을 이용한 경우</h3>
	<form>
		<input type="button" value="GET방식 요청2" id="getBtn">
	</form>
	<hr><br>
	
	<h3>GET방식 요청3 ==> form태그의 method속성을 생략하거나 'GET'으로 지정한 경우</h3>
	<h5>method 생략하면 get 방식, method에는 get post 둘다 가능</h5>
	<form action="http://localhost/webTest/servletTest03.do" method="get"> 
		<input type="submit" value="GET방식 요청3">
	</form>
	<hr><br>
	
	<h3>POST방식 요청 ==> form태그의 method속성을 'POST'로 지정한 경우</h3>
	<form action="http://localhost/webTest/servletTest03.do" method="post"> 
		<input type="submit" value="POST방식 요청">
	</form>
	<hr><br>
	
</body>
</html>