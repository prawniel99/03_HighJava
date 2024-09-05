<%@page import="kr.or.ddit.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
<%

	// 컨트롤러(서블릿)가 보낸 데이터를 받는다.
	List<LprodVO> lprodList = (List<LprodVO>)request.getAttribute("lprodList");

%>
	</head>
	<body>
		<h3>Lprod 자료 목록 (동기방식)</h3>
		<table border="1">
			<tr>
				<td>LPROD_ID</td>
				<td>LPROD_GU</td>
				<td>LPROD_NM</td>
			</tr>
<%
			for(LprodVO lvo : lprodList){
%>
				<tr><td><%=lvo.getLprod_id()%></td></tr>
				<tr><td><%=lvo.getLprod_gu()%></td></tr>
				<tr><td><%=lvo.getLprod_nm()%></td></tr>
<%
			}
%>
		</table>
	</body>
</html>