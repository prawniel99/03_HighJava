<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
    // 세션에서 "username"이라는 이름으로 저장된 값 꺼내기
    String id = (String)session.getAttribute("id");

    if (id != null) {
		out.println("<h1>"+id+"님 반갑습니다</h1>");
		out.println("<a href='"+request.getContextPath()+"/basic/session/sessionLoginDb.jsp'>로그아웃</a>");
%>

<script>
	window.onload = function() { document.getElementById('tab').style.display = 'none';	}
</script>

<%
	}
%>

</head>
<body>
	<form action="<%=request.getContextPath()%>/seLogin.do">
		<table border="1" id="tab">
			<tr>
				<td>ID:</td>
				<td><input type="text" placeholder="ID를 입력하세요" name="id"></td>
			</tr>
			<tr>
				<td>PW:</td>
				<td><input type="text" placeholder="PW를 입력하세요" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center"><input type="submit" value="Login"></td>
			</tr>
		</table>
		<div id="aa">
		</div>
	</form>
</body>
</html>