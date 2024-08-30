<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

<script>
	window.onload = function() {
	
		function getCookie(name) {
		    const cookies = document.cookie.split('; ');
		    
		    for (let i = 0; i < cookies.length; i++) {
		        const cookie = cookies[i];
		        var [cookieName, cookieValue] = cookie.split('=');
		        
		        if (cookieName === name) {
		            return decodeURIComponent(cookieValue);
		        }
		    }
		    return null;
		}

		// 'id'라는 이름의 쿠키 값을 불러오기
		const idCookieValue = getCookie('id');
		const reCheckedValue = getCookie('re');

		if (idCookieValue === 'admin' && reCheckedValue === 'on') {
		    document.getElementById('id').value = idCookieValue;
		    document.getElementById('check').checked = true;
		}
	};
</script>

</head>
<body>
	<div id="div-login">
		<form action="<%=request.getContextPath()%>/login.do" method="get">
		
			ID: <input type="text" placeholder="ID 입력하세요." name="id" id="id"><br>
			PASS: <input type="text"placeholder="PassWord 입력하세요." name="pw"><br>
			<input type="checkbox" id="remember" name="re" id="check">id 기억하기<br>
			<input type="submit" value="Login" name="login"><br>
			<input type="submit" value="Register" name="register"><br>
		
		</form>
		<!--
		<form>
			ID: <input type="text" placeholder="ID 입력하세요."><br>
			PASS: <input type="text"placeholder="PassWord 입력하세요."><br>
			<input type="checkbox" id="remember">id 기억하기<br>
			<input type="button" value="Login"><br>
		</form>
		-->
	</div>
</body>
</html>