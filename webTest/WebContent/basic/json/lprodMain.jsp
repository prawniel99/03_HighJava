<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
		<script type="text/javascript">
		$(function(){
			$('#lprodBtn').on('click', function(){
				$.ajax({
					// 전송용
					url : "<%=request.getContextPath()%>/json/lprodTest.do", // 요청을 보낼 주소 (데이터를 받아서 처리할 문서의 주소)(servlet)
					type : "POST",  		// 전송방식 (GET, POST) (ajax는 방식 별 상관 없음)
					data : "table=lprod", // 서버로 전송할 데이터를 구성한다. // 얘가 어떻게 request.getparameter("choice") 로 가냐고!
					// data : {"table" : "lprod", "test" : "good"}, // 서버로 전송할 데이터를 구성한다. // 얘가 어떻게 request.getparameter("choice") 로 가냐고!
					
					// 응답용
					success : function(data){	// 응답이 정상적으로 도달했을때 처리할 함수
						// 매개변수 data에는 응답으로 온 데이터가 자동으로 저장된다.
						// data : "안녕하세요"
						let htmlCode = "";
						htmlCode += "<table border='1'>";
						htmlCode += "<tr><td>번호</td><td>코드</td><td>품명</td></tr>";
						$.each(data, function(i,v){
							// htmlCode += `<tr><td colspan=3>${v.lprod_id}</td></tr>`;
							htmlCode += "<tr>";
							htmlCode += "<td>" + v.lprod_id + "</td>";
							htmlCode += "<td>" + v.lprod_gu + "</td>";
							htmlCode += "<td>" + v.lprod_nm + "</td>";
							htmlCode += "</tr>";
							//htmlCode += `<tr><td>${v.lprod_id}</td><td>${v.lprod_gu}</td><td>{v.lprod_nm}</td></tr>`;
							//htmlCode += "번호: " + v.lprod_id + "<br>";
							//htmlCode += "코드: " + v.lprod_gu + "<br>";
							//htmlCode += "품명: " + v.lprod_nm + "<hr>";
						})
						htmlCode += `</table>`;
						$('#result').html(htmlCode);
					},
					error : function(xhr){	// 오류 응답 처리
						alert("응답 코드: " + xhr.status);
					},
					dataType : 'json'		// 응답으로 받을 데이터의 Type을 지정한다. json 받고싶으면 'json' html은 'html' 'xml' 'text' 등
				})
			})
			
			//--------------------------------------------------------------------------------------
			
			$('#lprodBtn2').on('click', function(){
				location.href = "<%=request.getContextPath()/json/lprodList2.do";
			})
		})
		</script>
	</head>
	<body>
		<form>
			<input type="button" id="lprodBtn" value="Lprod 자료 가져오기(Ajax방식)">
			<input type="button" id="lprodBtn2" value="Lprod 자료 가져오기(동기방식)">
		</form>
		<h3>Lprod 자료 목록</h3>
		<div id="result"></div>
	</body>
</html>