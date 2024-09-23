<%@page import="kr.or.ddit.review.vo.ReviewVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review prod list page</title>

<script type="text/javascript">
window.onload = function() {
	reviewpid = document.getElementById('qnapid').value;
	
	$.ajax({
		url : `<%=request.getContextPath()%>/reviewProd.do`,
		type : 'POST',
		data : {'prodid' : reviewpid},
		success : function(res) {
			alert('상세페이지 reivew 가져오기 성공');
		},
		error : function(xhr) {
			alert('상세페이지 review 가져오기 오류 : ' + xhr.status);
		},
		dataType : 'json'
	});
};
  $(function(){
      $('#btninsert').on("click", function(){
          location.href="<%=request.getContextPath()%>/reviewInsert.do";
      });
      
      $('#btnhome').on("click", function(){
          location.href="<%=request.getContextPath()%>/reviewList.do";
      });
  });
</script>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f4f4f4;
    }
    h1 {
        color: #333;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
        background-color: #fff;
        border: 1px solid #ddd;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    }
    th, td {
        padding: 12px;
        border-bottom: 1px solid #ddd;
        text-align: center;
    }
    th {
        background-color: #f8f8f8;
        color: #333;
    }
    tr:nth-child(even) {
        background-color: #fafafa;
    }
    tr:hover {
        background-color: #f0f0f0;
    }
    .button-container {
        text-align: right;
        margin-bottom: 20px;
    }
    .button-container input {
        padding: 10px 20px;
        font-size: 16px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        background-color: #e0d6d6;
        color: #333;
    }
    .button-container input:hover {
        background-color: #d0cfcf;
    }
    .star-rating {
        color: gold; /* 별 색깔 설정 */
        font-size: 18px;
    }
</style>

</head>

<body>
<div class="container">
<h1>상품리뷰</h1>

<div class="button-container">
    <input id="btnhome" type="hidden" value="리뷰 목록으로 가기"> 
    <input id="btninsert" type="button" value="리뷰 남기기"> 
</div>

<%
    List<ReviewVO> rList = (List<ReviewVO>) request.getAttribute("myreviewList");
    if (rList == null || rList.isEmpty()) {
%>
    <p>아직 리뷰가 없습니다.</p>
<%
    } else {
%>
<table>
    <thead>
        <tr>
            <th>리뷰 ID</th>
            <th>리뷰 내용</th>
            <th>리뷰 별점</th>
            <th>리뷰 작성 날짜</th>
            <th>상세 보기</th>
        </tr>
    </thead>
    <tbody>
        <%
            for (ReviewVO review : rList) {
                // 별점을 시각적으로 표시하기 위해 빈 별과 채워진 별을 계산
                int starRating = review.getReview_star();
                int emptyStars = 5 - starRating;
        %>
            <tr>
                <td><%= review.getReview_id() %></td>
                <td><%= review.getReview_content() %></td>
                <td class="star-rating">
                    <!-- 채워진 별 표시 -->
                    <%
                        for (int i = 0; i < starRating; i++) {
                    %>
                        &#9733; <!-- 채워진 별 Unicode -->
                    <%
                        }
                    %>
                    <!-- 빈 별 표시 -->
                    <%
                        for (int i = 0; i < emptyStars; i++) {
                    %>
                        &#9734; <!-- 빈 별 Unicode -->
                    <%
                        }
                    %>
                </td>
                <td><%= review.getReview_date() %></td>
                <td><a href="<%=request.getContextPath()%>/reviewDetail.do?review_id=<%=review.getReview_id()%>" style="color: #007BFF;">상세보기</a></td>
            </tr>
        <%
            }
        %>
    </tbody>
</table>
<%
    }
%>
</div>
</body>
</html>