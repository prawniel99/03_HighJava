<%@page import="kr.or.ddit.review.vo.ReviewVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 목록</title>
		<%
        String adminId = "";
        if (session.getAttribute("loggedInAdmin") != null) {
            adminId = ((kr.or.ddit.member.vo.AdminVO)session.getAttribute("loggedInAdmin")).getAdminId();
        }
        %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styles.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
      $("#btnmyreview").on("click", function(){
          location.href="<%=request.getContextPath()%>/myreviewList.do";
      });
      
      $('#btninsert').on("click", function(){
          location.href="<%=request.getContextPath()%>/review/insertReview.do";
      });
      
      $('#btnhome').on("click", function(){
          location.href="<%=request.getContextPath()%>/main?view=index";
      });
  });
</script>
<style>
   body {
    font-family: Arial, sans-serif;
    margin: 20px;
    background-color: #f7f7f7; /* 아이보리 배경 */
    font-size : 14px;
}

h1, h3 {
    color: #333;
    text-align: center;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
    background-color: #fff; /* 흰색 배경 */
    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    font-size : 13px;
}

th, td {
    padding: 12px;
    border: 1px solid #ddd;
    text-align: center;
}

th {
    background-color: #f2f2f2; /* 연한 아이보리 */
    color: #333;
    font-size: 14px; /* 테이블 헤더 글씨 크기 조정 */
     white-space: nowrap; /* 모든 셀에서 줄바꿈 방지 */
}

tr:nth-child(even) {
    background-color: #f9f9f9; /* 연한 회색 */
}

tr:hover {
    background-color: #e6e6e6; /* 더 연한 회색 */
}

/* 버튼 스타일 */
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
    margin-left: 10px;
}


/* 각각의 버튼 색상 */
#btnmyreview {
    background-color: #d6cfcf !important; /* 아이보리 계열 */
    color: #333 !important;
}

#btninsert {
    background-color: #b9a69b !important; /* 더 어두운 아이보리 계열 */
    color: #fff !important;
}

#btnhome {
    background-color: #e0d6d6 !important; /* 연한 아이보리 계열 */
    color: #333 !important;
}


#btnmyreview:hover, #btninsert:hover, #btnhome:hover {
    background-color: #d0cfcf; /* hover시 더 어두운 색 */
}



#siren {
    width: 20px;
    height: 20px;
}
a {
    text-decoration: none; /* 밑줄 제거 */
    color: #6a0dad; /* 링크 기본 색상 설정 */
    font-size : 14px;
}

a:visited, a:hover, a:active {
    color: black; /* 링크 클릭 후 색상 유지 */
}

/* 별점 스타일 수정 */
.star-rating {
    color: gold; /* 별 색깔 */
    font-size: 16px;
    white-space: nowrap; /* 별점이 일렬로 표시되도록 설정 */
     font-size: 14px; /* 별점 글씨 크기 조정 */
}
.time{
	white-space: nowrap; /* 모든 셀에서 줄바꿈 방지 */
}

</style>
</head>
<body>
<h3>Review List</h3>

<div class="button-container">

<% if (adminId.isEmpty()) { %>
    <input id="btnmyreview" type="button" value="내가 쓴 리뷰 보기"> 
	<input id="btninsert" type="button" value="리뷰 쓰기"> 
    <% } %>

    <input id="btnhome" type="button" value="홈으로 가기"> 
</div>

<%
    List<ReviewVO> rList = (List<ReviewVO>) request.getAttribute("reviewList");
    if (rList == null || rList.isEmpty()) {
%>
<p>리뷰 목록이 없습니다.</p>
<%
    } else {
%>
<table>
    <thead>
        <tr>
            <th>리뷰 번호</th>
            <th>작성자 ID</th>
            <th>상품 이름</th>
            <th>상품 옵션</th>
            <th>별점</th>
            <th>내용</th>
            <th>작성 날짜</th>
       		<th>신고하기</th>
        </tr>
    </thead>
    <tbody>
    <%
        for (ReviewVO rvo : rList) {
            int starRating = rvo.getReview_star();
            int emptyStars = 5 - starRating;
    %>
        <tr>
            <td>
                <% if (!adminId.isEmpty()) { %>
                    <!-- admin일 때는 링크 추가 -->
                    <a href="<%= request.getContextPath() %>/reviewDetail.do?review_id=<%= rvo.getReview_id() %>">
                        <%= rvo.getReview_id() %>
                    </a>
                <% } else { %>
                    <!-- admin이 아닐 때는 단순히 리뷰 번호 표시 -->
                    <%= rvo.getReview_id() %>
                <% } %>
            </td>
            <td><%= rvo.getMem_id() %></td>
            <td>
			    <a href="<%= request.getContextPath() %>/prod/prodListView.do?prodId=<%= rvo.getProd_id() %>">
			        <%= rvo.getProd_name() %>
			    </a>
			</td>
            <td><%= rvo.getOption_name()%></td>
            <td class="star-rating">
                <%
                    for (int i = 0; i < starRating; i++) {
                %>
                    &#9733; <!-- 채워진 별 Unicode -->
                <%
                    }
                    for (int i = 0; i < emptyStars; i++) {
                %>
                    &#9734; <!-- 빈 별 Unicode -->
                <%
                    }
                %>
            </td>
            <td><%= rvo.getReview_content() %></td>
            
            <%
    String reviewDate = rvo.getReview_date(); // 예시: "2024-09-24 10:22:53"
    String formattedDate = reviewDate.substring(0, 16); // 초 부분을 제외 ("2024-09-24 10:22")
		%>

		<td class="time"><%= formattedDate %></td>

            
            
            
            
            <td>
                <a href="<%= request.getContextPath()%>/reportView.do?review_id=<%= rvo.getReview_id() %>">
                    <img src="<%= request.getContextPath()%>/images/사이렌.png" alt="사이렌" id="siren">
                </a>
            </td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>

<%
    }
%>
</body>
</html>
