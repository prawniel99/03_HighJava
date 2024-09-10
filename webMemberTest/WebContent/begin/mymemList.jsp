<%@page import="kr.or.ddit.mymem.vo.MymemVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 전체 목록</title>
	
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	
		<script>
		</script>
	</head>
	
	<%
	
	List<MymemVO> mymemList = (List<MymemVO>)request.getAttribute("mymemList");
	
	%>
	
	<body>
		<h1>회원 전체 목록</h1>
		<form action="<%=request.getContextPath()%>/insertMymem.do" method="post">
			<table border="1">
				<% if(mymemList == null || mymemList.size() == 0){	%>
						<tr><td colspan="7">회원이 없습니다</td></tr>
				<% } else { %>
						<tr><td colspan="5"><input type="submit" value="회원추가"></td></tr>
						<tr><td>ID</td><td>비밀번호</td><td>이름</td><td>전화</td><td>주소</td></tr>
				<% for(MymemVO mymemVo : mymemList){ %>
					<tr>
						<td id="id"><%=mymemVo.getMem_id()%></td>
						<td id="pw"><%=mymemVo.getMem_pass()%></td>
						<td id="nm"><%=mymemVo.getMem_name()%></td>
						<td id="ph"><%=mymemVo.getMem_tel()%></td>
						<td id="ad"><%=mymemVo.getMem_addr()%></td>
					</tr>
				<% } } %>
			</table>
		</form>
	</body>
</html>