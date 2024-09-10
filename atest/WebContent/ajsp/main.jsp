<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>main</h1>
		<a href="<%= request.getContextPath() %>/aservlet.do">aservlet go</a>
		
		<hr>
		
		<p>form</p>
		<form action="<%= request.getContextPath() %>/Bservlet" method="post">
			<% if(request.getAttribute("servletpw")!=null) { %>
			<input type="text" name="id" value="<%= request.getAttribute("servletpw") %>">
			<% } else { %>
			<input type="text" name="id" placeholder="your id">
			<% } %>
			<% if(request.getAttribute("servletpw")!=null) { %>
			<input type="text" name="id" value="<%= request.getAttribute("servletid") %>">
			<% } else { %>
			<input type="text" name="id" placeholder="your pw">
			<% } %>
			<input type="submit" value="bservlet">
		</form>
		
		<hr>
		
		<p>memlist</p>
		<a href="<%= request.getContextPath() %>/cservlet">cservlet memlist</a>
	</body>
</html>