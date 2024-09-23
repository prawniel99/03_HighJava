<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery-3.7.1.js"></script>
		<script src="${pageContext.request.contextPath}/js/qna.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.serializejson.min.js"></script>
		<link rel="stylesheet" href="qnaStyle.css">
		<link rel="icon" href="cat-jump.png" type="image/x-icon">
		
	
		<meta charset="UTF-8">
		<title>QnA</title>
		
		<style>

		</style>
		
<%
	// 로그인 상태 확인 start
	MemberVO vo = (MemberVO)session.getAttribute("loggedInMember"); // LoginContgroller.java에서 session으로 넘어옴.
	String loggedInMember = null;
	Gson gson = new Gson();
	if(vo != null) loggedInMember = gson.toJson(vo);
	
	// 관리자 = 댓글쓰기, 댓글수정, 댓글삭제, 글삭제
	// 일반 회원 = 글쓰기, 자기글수정
	// loggedInMember 저거를 사용해서, 로그인 한 사람의 id와 비번, 그리고 mem_role 을 가져와서, mem_role이 관리자인 사람일때를 분리해야함
	// int memRole = vo.getMemRole(); // memRole = 1 = 관리자 // memRole = 0 = 회원
	

	
	
%>
		<script>
			/* 보관함
			$(document).ready(function() { });
			$('#id').on('click', function() { });
			$('.class').on('click', function() { });
			$('#testbtn1').on('click', function() { });
			*/
			
			
			// 변수 설정
			uvo = <%= loggedInMember %>;
			
			// 테스트용 시작
			<% String loginId = "admin"; %>;
			loginId = "admin";
			uvo = "admin";
			// 테스트용 끝
			
			reply = {};
			
			currentPage = 1;
			mypath = '<%=request.getContextPath()%>'
			
			
			$(document).ready(function() {
				
				// 리스트 출력 기능 시작
				// 화면에 qna 리스트 출력하기
			    $.qnaList();
				
				// 다음버튼 클릭 이벤트
				$(document).on('click', '#next', function(){
					currentPage = parseInt($('.pageno').last().text()) + 1;
					$.qnaList();
				});
				
				// 이전버튼 클릭 이벤트
				$(document).on('click', '#prev', function(){
					currentPage = $('.pageno').first().text() - 1;
					$.qnaList();
				});
				
				// 페이지 번호 클릭 이벤트
				$(document).on('click', '.pageno', function(){
					currentPage = $(this).text();
					$.qnaList();
				})
				
				// 검색어 입력 후 검색버튼 클릭 이벤트
				$(document).on('click', '#search', function(){
					currentPage = 1;
					$.qnaList();
				})
				// 리스트 출력 기능 끝

			
			

				// 문의글쓰기 기능 모달창 시작
				$(document).ready(function() {
					// qna 작성용 모달창 열기 시작
					$('#qnaInsert').on('click', function(){
						console.log('글쓰기 진입');
						
						if(uvo == null) {
							alert("로그인 하세요");
							return;
						}
						// 모달 이름칸에 이름 넣기
						// $('#writer').val(uvo.memId);
						$('#writer').val(uvo); // 임시변수
						$('#prod').val('test'); // 임시변수, 선택한 아이템 정보 불러와서 넣기.
					
						// 모달 이름 수정 불가 설정
						$('#writer').prop('readonly', true);
						$('#prod').prop('readonly', true);
						
						// 모달 보이게 하기
						$('#qnaModal').modal('show');
						$('#qnaModal #subject').val("");
					})
					// qna 작성용 모달창 열기 끝
					
					// 완료 버튼 클릭 시작
					$('#send').on('click', function(){
						console.log('글쓰기 완료 버튼 클릭');
						// 입력한 모든 내용 가져오기
						fdata3 = $('#qnaForm').serializeJSON();
						console.log(fdata3);
						
						// 글쓰기 함수 호출
						$.qnaInsertPost();
						
						// 모달창 닫기
						$('#qnaModal').modal('hide');
						
						// 모달창 내용 지우기
						$('#qnaModal .txt').val("");
					})
					// 완료 버튼 클릭 끝
				})
				// 문의글쓰기 기능 모달창 끝
	
				
				
				// action 기능 시작
				// $(document).on('click', '.action', function(){
				$(document).on('click', '.action', function(){
					target = $(this);
					vname = $(this).attr('name');
					vidx = $(this).attr('idx');
					vstat = $(this).attr('status');
					console.log(target);
					console.log(vname);
					console.log('첫번재 vidx는 '+vidx);
					
					// 글 수정하기 기능 시작
					if (vname == "modify") {
						// 원글의 내용을 가져온다
						// 수정버튼을 기준으로 공통조상 찾기
						vcard = $(this).parents('.card');
						vqnaid = $(vcard).find('.btn.action').attr('idx');
						vtitle = $(vcard).find('#title').text().trim();
						vname = $(vcard).find('.wr').text().trim();
						vcont = $(vcard).find('.p3').html().trim(); // <br> 태그가 포함
						vcont = vcont.replaceAll(/<br>/g, "");
						
						//console.log(vcard);
						//console.log(vtitle);
						//console.log(vname);
						console.log(vcont);
						//console.log(vqnaid);
						
						
						// 모달창에 출력한다
						$('#uwriter').val(vname).prop('readonly', true);
						$('#usubject').val(vtitle);
						$('#uprod').val('test').prop('readonly', true); // 이것도 연결해야함
						$('#ucontent').val(vcont);
						$('#unum').val(vqnaid);
						
						// 모달창 실행
						$('#uModal').modal('show');
						
					// 글 수정하기 기능 끝
					// 글 삭제하기 시작
					} else if (vname == "delete") { // 글 삭제하기
						if(confirm("정말로 삭제하시겠습니까?")) {
							// 함수 호출. board.js에 있는거.
							$.qnaDeletePost();
						} else {
							return;
						}
					
					// 글 삭제하기 끝
					// 댓글 달기 시작 (수정기능 동일)
					} else if (vname == "reply") {
						// 문의글 댓글 작성은 관리자만 가능
						if(uvo != 'admin') {
							alert("잘못된 접근");
							return;
						}
						
						// 입력한 댓글내용 가져오기
						vcont = $(this).prev().val().trim();
						
						// 저장할 데이터 수집 renum bonum cont
						// 위에서 만들어둔 빈 스크립트 객체 reply, 동적으로 속성 추가하기
						reply.qna_no = vidx; // 게시글 번호
						// reply.name = uvo.mem_name; // 작성자명
						reply.qna_answer = vcont; // 내용
						
						// 전송 - board.js의 함수를 호출
						$.qnaInsertReply();
						$(this).prev().val("");
						
						// 댓글 리스트 가져오기 // 비동기니까 데이터도 안가져왔는데 출력부터 해버릴려고 할 수 있음
						// 그래서 ajax에서 해야함
						
					// 댓글 달기 끝
					// 문의글 신고하기 시작
					} else if (vname == "report") {
						if (confirm("정말로 신고하시겠습니까?")) {
							reportPostNum = $(this).parents('.card').find('#title').attr("idx");
							console.log(idx);
							$.reportPost();
						} else {
							return;
						}
						/*
						// 입력한 모든 값을 가져온다
						udata = $('#uform').serializeJSON();
						console.log(udata);
						
						// 모달창에 입력된 내용 지우기
						$('#uform .txt').val("");
						
						// 모달창 닫기
						$('#uModal').modal('hide');
						
						// 서버로 전송한다 - js함수 호출 - 동기방식은 가져와야하고, 비동기는 안가져와도 된다.. 흐음.. 동기 비동기..
						*/
						
					// 문의글 신고하기 끝
					// 댓글 출력하기 시작
					} else if (vname == "title") {
						// 함수 호출
						$.qnaReplyList();
					}
					// 댓글 출력하기 끝
					
				})
				// action 기능 끝
				
				
				
				// 수정 버튼 클릭 시작
				$('#usend').on('click', function(){
				// 입력한 모든 값을 가져온다
				udata = $('#uform').serializeJSON();
				console.log(udata);
				
				// 모달창에 입력된 내용 지우기
				$('#uform .txt').val("");
				
				// 모달창 닫기
				$('#uModal').modal('hide');
				
				// 서버로 전송한다 - js함수 호출 - 동기방식은 가져와야하고, 비동기는 안가져와도 된다.. 흐음.. 동기 비동기..
				$.qnaUpdatePost();
			})
				
			
			

			});
			</script>
			
			
		
		
		
		
		
	</head>
	







	<body>

		

	
<div class="title">
	<h2>문의 게시판 / Q&amp;A</h2>
</div>

<div id="qnaNotice">
	상품에 관해 궁금한 점들을 작성해주시면 답변 드리겠습니다.
	타인에게 불쾌감을 주거나 사회적으로 부적절한 내용들은 삭제될 수 있습니다.
</div>

<!-- 리스트 5개씩을 출력 -->
<div id="result"></div> <br><br>

<!-- 글쓰기 버튼 -->
<% if(!loginId.equals("admin")) { %>
<div class="container-fluid">
	<input type="button" id="qnaInsert" value="글쓰기"><br><br>
</div>
<% } %>


<!-- 페이지정보를 출력 공간 -->
<div id="pagelist"></div>


<!-- 검색창 -->
<br><br>
	    <div class='container' id='container-main'>
	    	<div class='wrapper' id='wrapper-qna'>
	        <form action="submitQnA.jsp" method="post">
	        	<div class='content' id="content-qna">
					<select class="form-select" id="stype">
						<option value="">a</option>
						<option value="writer">b</option>
						<option value="subject">c</option>
						<option value="content">d</option>
					</select>
	        		<input class="form-control me-2" type="text" id="sword" placeholder="Search">
	        	</div>
	        	<button type="submit">검색</button>
	        </form>





<!------- qna 글쓰기 modal --------->
<!------- qna 글쓰기 modal --------->
<!------- qna 글쓰기 modal --------->
<!------- qna 글쓰기 modal --------->
<!------- qna 글쓰기 modal --------->
<div class="modal" id="qnaModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">문의글 작성하기</h4>
				<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<form name="qnaForm" id="qnaForm">
					<div id="qnaProdPic-container">
						<div id="qnaProdPic-container-head">
							<span>제품사진</span> <br>
						</div>
						<div id="qnaProdPic-container-body">
							<img src="cat-jump.png" id="qnaProdPic" class="qnaInsertPic"> <br> <!-- 여기 이미지를 상품페이지에서 가져오는 prod id를 해야함 -->
						</div>
					</div> <br>
					
					<label>상품명</label>&nbsp;&nbsp;&nbsp;
					<input type="text" class="txt" id="prod" name="prod_id"> <br>
					
					<label>ID</label>&nbsp;&nbsp;&nbsp;
					<input type="text" class="txt" id="writer" name="mem_id"> <br>
					
					<label>제목</label>
					<input type="text" class="txt" id="subject" name="qna_title"> <br>

					<label>암호</label>
					<input type="password"  class="txt" id="password" name="qna_pass"> <br>

					<label>내용</label>
		            <br>
        		    <textarea rows="5" cols="40"  class="txt" id="content"  name="qna_content"></textarea>
            		<br>
		            <br>
		            <div id="confirmbtn-container">
						<input type="button" value="완료" id="send">
		            </div>
				</form>
			</div>
			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>









<!----- qna 글수정 Modal    ----->
<!----- qna 글수정 Modal    ----->
<!----- qna 글수정 Modal    ----->
<!----- qna 글수정 Modal    ----->
<!----- qna 글수정 Modal    ----->
<div class="modal" id="uModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">게시글 수정하기</h4>
				<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			</div>
			<!-- Modal body -->
			<div class="modal-body">
				<form name="ufrom" id="uform">
					<div id="qnaProdPic-container">
						<div id="qnaProdPic-container-head">
							<span>제품사진</span> <br>
						</div>
						<div id="qnaProdPic-container-body">
							<img src="cat-jump.png" id="qnaProdPic" class="qnaInsertPic"> <br> <!-- 여기 이미지를 상품페이지에서 가져오는 prod id를 해야함 -->
						</div>
					</div> <br>
					<label>상품명</label>
					<input type="text" class="txt" id="uprod" name="prod_id"> <br>
		
					<input type="hidden" id="unum" name="qna_no">
					<label>ID</label>
					<input type="text" class="txt" id="uwriter" name="mem_id"> <br> 
		
					<label>제목</label>
					<input type="text" class="txt" id="usubject" name="qna_title"> <br> 
		
					<label>암호</label>
					<input type="text"  class="txt" id="upassword" name="qna_pass"> <br> 
		
					<label>내용</label>
					<br>
					<textarea rows="5" cols="40"  class="txt" id="ucontent"  name="qna_content"></textarea>
					<br>
					<br>
					<input type="button" value="전송" id="usend">
				</form>
			</div>
			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>






	
<!-- 입력창(수정 내용 입력창)
	<div id="modifyform">
		<textarea rows="5" cols="50"></textarea>
		<input type="button" value="확인" id="btnok">
		<input type="button" value="취소" id="btnreset">
	</div>
-->

















			
			








	    	</div>
	    </div>
	</body>
</html>