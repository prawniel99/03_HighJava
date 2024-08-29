<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
	</head>
	
	<!-- HTML 주석 -->
	
	<%-- JSP 주석 --%>
	
	<% // jsp 문서에서 java 명령을 사용할 수 있는 영역 %>
	<% /* 주석 사용 가능 */ // 주석 사용 가능 %>
	<% // 이 영역을 Scriptlet(스크립트릿) 이라고 함 %>
	<% String name = "홍길동"; %>
	
	<%-- <%= (자바?)변수 or 수식을 쓸 수 있다 %> --%>
	<%-- jsp문서에서 변수의 값이나 수식의 처리 결과를 출력할 때 사용한다 --%>
	<%-- 이것은 '표현식(Expression)'이라고 한다 --%>
	
	<!-- <form>태그의 속성 -->
	<!-- 1) action  ==> form에서 구성한 데이터를 받아서 처리할 문서명 또는 서블릿 URL -->
	<!-- 2) method  ==> 전송방식 GET 또는 POST 지정 ==> 기본값: GET -->
	<!-- 3) target  ==> (잘안씀) 응답이 나타날 프레임을 지정할 때 사용한다. 지정하지 않으면 현재 위치에 온다. -->
	<!-- 4) enctype ==> 서버로 파일을 전송할 때 사용하는 속성이다. (파일 전송때 외엔 거의 안씀) -->
	<!-- 				(파일을 전송할 때에는 이 속성에 'multipart/form-data'라고 설정해야 한다.) -->
	
	<body>
	TEST
	<h2><%= name %>의 Request 연습용 Form <%=3*5%></h2>
	
	<form action="<%=request.getContextPath()%>/requestTest01.do" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" size="10" name="username"></td>
			</tr>
			<tr>
				<td>직업</td>
				<td>
					<select name="job">
						<option value="무직">== 무직 ==</option>
						<option value="학생">== 학생 ==</option>
						<option value="회사원">== 회사원 ==</option>
						<option value="전문직">== 전문직 ==</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<input type="checkbox" name="hobby" value="여행">여행
					<input type="checkbox" name="hobby" value="독서">독서
					<input type="checkbox" name="hobby" value="바둑">바둑
					<input type="checkbox" name="hobby" value="장기">장기
					<input type="checkbox" name="hobby" value="테니스">테니스
					<input type="checkbox" name="hobby" value="배드민턴">배드민턴
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center;">
					<input type="submit" value="전송">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	
	</form>
	
	
	
	</body>
	
</html>
