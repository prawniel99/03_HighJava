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
				// 문자열 처리
				$('#strBtn').on('click', function(){
					$.ajax({
						// 전송용
						url : "<%=request.getContextPath()%>/json/jsonTest.do", // 요청을 보낼 주소 (데이터를 받아서 처리할 문서의 주소)(servlet)
						type : "POST",  		// 전송방식 (GET, POST) (ajax는 방식 별 상관 없음)
						data : "choice=string",	// 서버로 전송할 데이터를 구성한다. // 얘가 어떻게 request.getparameter("choice") 로 가냐고!
						
						// 응답용
						success : function(data){	// 응답이 정상적으로 도달했을때 처리할 함수
							// 매개변수 data에는 응답으로 온 데이터가 자동으로 저장된다.
							// data : "안녕하세요"
							let htmlCode = "<h3>문자열 응답 결과</h3>";
							htmlCode += data;
							$('#result').html(htmlCode);
						},
						error : function(xhr){	// 오류 응답 처리
							alert("응답 코드: " + xhr.status);
						},
						dataType : 'json'		// 응답으로 받을 데이터의 Type을 지정한다. json 받고싶으면 'json' html은 'html' 'xml' 'text' 등
					})
				})
				// 문자열 처리 끝
				// 배열 처리
				$('#arrayBtn').on('click', function(){
					$.ajax({
						// 전송용
						url : "<%=request.getContextPath()%>/json/jsonTest.do", // 요청을 보낼 주소 (데이터를 받아서 처리할 문서의 주소)(servlet)
						type : "POST",  		// 전송방식 (GET, POST) (ajax는 방식 별 상관 없음)
						data : "choice=array",	// 서버로 전송할 데이터를 구성한다.
						
						// 응답용
						success : function(data){	// 응답이 정상적으로 도달했을때 처리할 함수
							// 매개변수 data에는 응답으로 온 데이터가 자동으로 저장된다.
							// data = [10,20,30,40,50];
							// let htmlCode = "<h3>배열 응답 결과</h3>";
							// htmlCode += data;
							// $('#result').html(htmlCode); // 이것도 되긴 하는데
							let htmlCode = "<h3>배열 응답 결과</h3>";
							$.each(data, function(i,v){ // i는 index, v는 값
								htmlCode += i + "번째 자료: " + v + "<br>";
							})
							$('#result').html(htmlCode);
						},
						error : function(xhr){	// 오류 응답 처리
							alert("응답 코드: " + xhr.status);
						},
						dataType : 'json'		// 응답으로 받을 데이터의 Type을 지정한다. json 받고싶으면 'json' html은 'html' 'xml' 'text' 등
					})
				})
				// 배열 처리 끝
				// 객체 처리
				$('#objBtn').on('click', function(){
					$.ajax({
						// 전송용
						url : "<%=request.getContextPath()%>/json/jsonTest.do", // 요청을 보낼 주소 (데이터를 받아서 처리할 문서의 주소)(servlet)
						type : "POST",  		// 전송방식 (GET, POST) (ajax는 방식 별 상관 없음)
						data : "choice=object",	// 서버로 전송할 데이터를 구성한다. // 얘가 어떻게 request.getparameter("choice") 로 가냐고!
						
						// 응답용
						success : function(data){	// 응답이 정상적으로 도달했을때 처리할 함수
							// 매개변수 data에는 응답으로 온 데이터가 자동으로 저장된다.
							// 객체 구조는 '이름 콜론 값' '이름 : 값' 'name : value'
							// data : {"num":1,"name":"홍길동"}
							let htmlCode = "<h3>객체 응답 결과</h3>";
							htmlCode += "번호: " + data.num + "<br>";
							htmlCode += "이름: " + data.name + "<br>";
							$('#result').html(htmlCode);
						},
						error : function(xhr){	// 오류 응답 처리
							alert("응답 코드: " + xhr.status);
						},
						dataType : 'json'		// 응답으로 받을 데이터의 Type을 지정한다. json 받고싶으면 'json' html은 'html' 'xml' 'text' 등
					})
				})
				// 객체 처리 끝
				// 리스트 처리
				$('#listBtn').on('click', function(){
					$.ajax({
						// 전송용
						url : "<%=request.getContextPath()%>/json/jsonTest.do", // 요청을 보낼 주소 (데이터를 받아서 처리할 문서의 주소)(servlet)
						type : "POST",  		// 전송방식 (GET, POST) (ajax는 방식 별 상관 없음)
						data : "choice=list",	// 서버로 전송할 데이터를 구성한다. // 얘가 어떻게 request.getparameter("choice") 로 가냐고!
						
						// 응답용
						success : function(data){	// 응답이 정상적으로 도달했을때 처리할 함수
							// 매개변수 data에는 응답으로 온 데이터가 자동으로 저장된다.
							// data = [{"num":100,"name":"초콜렛"},{"num":200,"name":"햄버거"},{"num":300,"name":"설렁탕"}]
							let htmlCode = "<h3>리스트 응답 결과</h3>";
							// htmlCode += data;
							// data는 배열처럼 오고, 그 배열 안에는 객체처럼 되어있으니, 두가지 합친 방식으로,
							// 몇번째걸 가져오고, 그것 점(.)뭐시기
							/* for(let i=0; i<data.length; i++) {
								htmlCode += i + "번째 자료<br>";
								htmlCode += "번호: " + data[i].num + "<br>";
								htmlCode += "이름: " + data[i].name + "<hr>";
							} */
							// 다른 방법
							$.each(data, function(i,v){
								htmlCode += i + "번째 자료<br>";
								htmlCode += "번호: " + v.num + "<br>";
								htmlCode += "이름: " + v.name + "<hr>";
							})
							$('#result').html(htmlCode);
						},
						error : function(xhr){	// 오류 응답 처리
							alert("응답 코드: " + xhr.status);
						},
						dataType : 'json'		// 응답으로 받을 데이터의 Type을 지정한다. json 받고싶으면 'json' html은 'html' 'xml' 'text' 등
					})
				})
				// 리스트 처리 끝
				// 맵 처리
				$('#mapBtn').on('click', function(){
					$.ajax({
						// 전송용
						url : "<%=request.getContextPath()%>/json/jsonTest.do", // 요청을 보낼 주소 (데이터를 받아서 처리할 문서의 주소)(servlet)
						type : "POST",  		// 전송방식 (GET, POST) (ajax는 방식 별 상관 없음)
						data : "choice=map",	// 서버로 전송할 데이터를 구성한다. // 얘가 어떻게 request.getparameter("choice") 로 가냐고!
						
						// 응답용
						success : function(data){	// 응답이 정상적으로 도달했을때 처리할 함수
							// 매개변수 data에는 응답으로 온 데이터가 자동으로 저장된다.
							// data = {"name":"머스크","tel":"010-6666-8888","addr":"대전"}
							let htmlCode = "<h3>맵 응답 결과</h3>";
							// htmlCode += data.get("name");
							htmlCode += "이름: " + data.name + "<br>";
							htmlCode += "전화: " + data.tel + "<br>";
							htmlCode += "주소: " + data.addr + "<br>";
							htmlCode += "대한: " + data.대한 + "<br>"; // 이게 되네..
							$('#result').html(htmlCode);
						},
						error : function(xhr){	// 오류 응답 처리
							alert("응답 코드: " + xhr.status);
						},
						dataType : 'json'		// 응답으로 받을 데이터의 Type을 지정한다. json 받고싶으면 'json' html은 'html' 'xml' 'text' 등
					})
				})
				// 맵 처리 끝
			})
		</script>
	</head>
	<body>
		<form>
			<input type="button" id="strBtn" value="String">
			<input type="button" id="arrayBtn" value="Array">
			<input type="button" id="objBtn" value="Object">
			<input type="button" id="listBtn" value="List">
			<input type="button" id="mapBtn" value="Map">
		</form>
		<div id="result"></div>
	</body>
</html>