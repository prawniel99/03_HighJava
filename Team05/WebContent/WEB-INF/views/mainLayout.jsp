<%@page import="kr.or.ddit.member.vo.AdminVO"%>
<%@ page import="kr.or.ddit.member.vo.MemberVO" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
    //session = request.getSession();
    MemberVO loggedInMember = (MemberVO) session.getAttribute("loggedInMember");
	AdminVO loggedInAdmin = (AdminVO) session.getAttribute("loggedInAdmin");
%>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <title>Main Layout</title>
    <script>

    document.addEventListener("DOMContentLoaded", function() {
        const slider = document.querySelector('.slider');
        let currentSlide = 0;
        const slides = slider.children.length;
        const slideHeight = 40; // .notification의 높이와 동일하게 설정
        const intervalTime = 8000; // 슬라이드 전환 간격을 3초로 설정

        setInterval(function() {
            currentSlide = (currentSlide + 1) % slides;
            slider.style.transform = `translateY(-${currentSlide * slideHeight}px)`;
        }, intervalTime);
    });

    </script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>



<div class="header-top">
   <a href="<%=request.getContextPath()%>/main?view=index">
       <img src="<%=request.getContextPath()%>/images/연근옷장로고.jpg" alt="연근옷장로고.jpg" style="height: 35px;">
   </a>
</div>


<nav class="main-nav">
    <ul>
        <div class="nav-left">
            <li class="dropdown">
                <a href="#">Shop</a>
                <ul class="dropdown-content">
                    <li><a href="<%=request.getContextPath()%>/prod/prodNewArrList.do">New Arrivals</a></li>
                    <li><a href="<%=request.getContextPath()%>/prod/prodBestList.do">Best</a></li>
                    <li><a href="<%=request.getContextPath()%>/prod/prodList.do">All</a></li>
                    <li><a href="<%=request.getContextPath()%>/prod/prodOuterList.do">Outer</a></li>
                    <li><a href="<%=request.getContextPath()%>/prod/prodTopList.do">Top</a></li>
                    <li><a href="<%=request.getContextPath()%>/prod/prodBottomList.do">Bottom</a></li>
                    <li><a href="<%=request.getContextPath()%>/prod/prodAccList.do">Acc</a></li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#">Community</a>
                <ul class="dropdown-content">
                    <li><a href="<%=request.getContextPath()%>/notice/noticeList.do">Notice</a></li>
                    <li><a href="<%=request.getContextPath()%>/qnaMain.do">QnA</a></li>
                    <li><a href="<%=request.getContextPath()%>/reviewList.do">Review</a></li>
                </ul>
            </li>

            <!-- 알림창을 네비게이션 왼쪽에 배치 -->
            <div class="notification">
                <div class="slider">
                    <p>회원가입 시 10% COUPON</p>
                    <p>전 상품 무료배송!</p>
                    <p>지금 가입하고 혜택을 받아보세요!</p>
                </div>
            </div>
        </div>

        <div class="nav-right">
          
        
    
		    <% if (loggedInMember != null) { %>
		        <!-- 회원일 때 My Page 표시 -->
		        <li><a href="<%=request.getContextPath()%>/cart/cartList.do">Cart</a></li>
		        <li><a href="<%=request.getContextPath()%>/member/myPage.do">My Page</a></li>
		        <li><a href="<%=request.getContextPath()%>/member/logout.do">Logout</a></li>
		    <% } else if (loggedInAdmin != null) { %>
		        <!-- 관리자인 경우 Admin Page 표시 -->
		        <li><a href="<%=request.getContextPath()%>/member/adminDashboard.do">Admin Page</a></li>
		        <li><a href="<%=request.getContextPath()%>/member/logout.do">Logout</a></li>
		    <% } else { %>
		        <!-- 로그인이 안 되어 있을 때 로그인/회원가입 표시 -->
		        <li><a href="<%=request.getContextPath()%>/member/login.do">Login</a></li>
		        <li><a href="<%=request.getContextPath()%>/member/register.do">Join</a></li>
		    <% } %>
		</div>
    </ul>
</nav>





<!-- 메인 콘텐츠 -->
<div class="main-content">
    <jsp:include page="${contentPage}" />
</div>




<!-- 공통 푸터 -->
<div class="footer">
    <p>CUSTOMER CENTER 042.256.2569</p>
    <p>MON-FRI [10:00 - 17:00] WEEKEND, HOLIDAYS OFF</p>
    <p>Lotus Root Closet No.5 .All rights reserved</p>
</div>
</body>
</html>
