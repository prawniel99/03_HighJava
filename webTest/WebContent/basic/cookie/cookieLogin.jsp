<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		
		<%
			// 쿠키값을 확인하여 로그인 정보를 가져온다
			Cookie[] cookieArr = request.getCookies();
			String loginId = ""; // 쿠키에 저장된 ID값이 저장될 변수
			String chk = ""; // checkbox의 체크 여부를 처리할 변수
			if(cookieArr != null) {
				for(Cookie cookie : cookieArr) {
					if("LOGIN_ID".equals(cookie.getName())) { // 쿠키 이름이 있으면
						loginId = cookie.getValue(); // 쿠키값(로그인 할 때 사용한 ID)
						chk = "checked";
					}
				}
			}
		%>
	</head>
	<body>
		<form action="/src/kr/or/ddit/cookieLoginServlet.do" method="post">
			<table border="1">
				<tr>
					<td>ID: </td>
					<td><input type="text" name="userid" placeholder="ID 입력" <%= loginId %>></td>
				</tr>
				<tr>
					<td>PW: </td>
					<td><input type="password" name="userpass" placeholder="PW 입력"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="checkbox" name="idchk" value="check" <%= chk %>>ID 기억하기</td> <!-- value가 있으면 그게 넘어간다 오 -->
				</tr>
				<tr>
					<td colspan="2" style="text-align: center"><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</body>
</html>