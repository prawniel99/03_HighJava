<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>
<body>

<%
	// JSP 문서에서의 Session은 'session'이라는 이름으로 이미 지정되어 있다.

	MemberVO loginMember = (MemberVO)session.getAttribute("loginMemVo");

    if (loginMember != null) {
%>
		<h1><%= loginMember.getMem_name()%>님 환영합니다</h1>
    	<a href="<%=request.getContextPath()%>/sessionLogoutDb.do %>">로그아웃</a>

		<script>
			window.onload = function() { document.getElementById('tab').style.display = 'none';	}
		</script>
<% } %>

	<form action="<%=request.getContextPath()%>/sessionLoginDb.do">
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