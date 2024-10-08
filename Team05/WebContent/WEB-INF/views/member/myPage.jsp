<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.or.ddit.member.vo.MemberVO"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Page</title>
<style>
/* 전체 페이지 스타일 */
body {
    font-family: Arial, sans-serif;                  /* Arial 폰트 사용 */
    margin: 0;                                       /* 바깥 여백 제거 */
    padding: 0;                                      /* 안쪽 여백 제거 */
    background-color: #ffffff;                       /* 흰색 배경 설정 */
    display: flex;                                   /* Flexbox 레이아웃 사용 */
    flex-direction: column;                          /* 세로 방향으로 요소 배치 */
    min-height: 100vh;                               /* 최소 높이를 뷰포트 높이로 설정 */
}

/* 메인 콘텐츠 영역 스타일 */
.main-content {
    flex-grow: 1;                                    /* 남은 공간을 모두 차지하도록 설정 */
    padding: 20px;                                   /* 안쪽 여백 설정 */
}

/* 푸터 스타일 */
.footer {
    background-color: #e8e4d9;                       /* 연한 베이지색 배경 */
    color: #333;                                     /* 진한 회색 텍스트 */
    text-align: center;                              /* 텍스트 중앙 정렬 */
    padding: 10px 0;                                 /* 위아래 안쪽 여백 설정 */
    width: 100%;                                     /* 전체 너비 사용 */
    margin-top: auto;                                /* 항상 페이지 하단에 위치하도록 설정 */
}

/* 헤더 스타일 */
.header-top {
    display: flex;                                   /* Flexbox 레이아웃 사용 */
    justify-content: center;                         /* 로고를 수평 가운데 정렬 */
    align-items: center;                             /* 로고를 수직 가운데 정렬 */
    background-color: #ffffff;                       /* 흰색 배경 */
    padding: 20px;                                   /* 안쪽 여백 설정 */
    border-bottom: 1px solid #ddd;                   /* 하단 테두리 추가 */
    position: relative;                              /* 상대적 위치 설정 */
}

/* 헤더 옵션 스타일 */
.header-options {
    position: absolute;                              /* 절대 위치 설정 */
    right: 20px;                                     /* 오른쪽에서 20px 떨어진 위치에 배치 */
}

/* 네비게이션 스타일 */
.main-nav ul {
    list-style-type: none;                           /* 목록 마커 제거 */
    padding: 0;                                      /* 안쪽 여백 제거 */
    background-color: #f4f0e6;                       /* 연한 베이지색 배경 */
    overflow: hidden;                                /* 내용이 넘칠 경우 숨김 처리 */
}

.main-nav li {
    float: left;                                     /* 왼쪽으로 정렬 */
}

.main-nav li a {
    display: block;                                  /* 블록 레벨 요소로 표시 */
    padding: 14px 20px;                              /* 안쪽 여백 설정 */
    color: #333;                                     /* 진한 회색 텍스트 */
    text-align: center;                              /* 텍스트 중앙 정렬 */
    text-decoration: none;                           /* 텍스트 장식 제거 */
}

.main-nav li a:hover {
    background-color: #e0dbcf;                       /* 호버 시 배경색 변경 */
    color: #333;                                     /* 호버 시 텍스트 색상 유지 */
}

/* 컨테이너 스타일 */
.container {
    width: 70%;                                      /* 너비를 70%로 설정 */
    max-width: 1200px;                               /* 최대 너비 제한 */
    padding: 15px;                                   /* 안쪽 여백 설정 */
    background-color: #faf9f7;                       /* 연한 베이지색 배경 */
    border: 1px solid #ddd;                          /* 테두리 추가 */
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);     /* 그림자 효과 추가 */
    text-align: center;                              /* 텍스트 중앙 정렬 */
    margin: 20px auto;                               /* 상하 여백 및 가운데 정렬 */
    border-radius: 10px;                             /* 둥근 모서리 설정 */
}

/* 제목 스타일 */
h2 {
    font-size: 28px;                                 /* 글꼴 크기 설정 */
    margin-bottom: 30px;                             /* 아래쪽 여백 설정 */
}

/* 그리드 메뉴 스타일 */
.grid-menu {
    display: grid;                                   /* 그리드 레이아웃 사용 */
    grid-template-columns: repeat(2, 1fr);           /* 2열 그리드 설정 */
    grid-gap: 40px;                                  /* 그리드 간격 설정 */
    padding: 20px;                                   /* 안쪽 여백 설정 */
    margin: 0 auto;                                  /* 가운데 정렬 */
    justify-items: center;                           /* 항목을 수평 가운데 정렬 */
    text-align: center;                              /* 글자를 가운데 정렬 */
}

/* 메뉴 항목 스타일 */
.menu-item {
    background-color: #fff;                          /* 흰색 배경 */
    padding: 20px;                                   /* 안쪽 여백 설정 */
    border: 1px solid #ddd;                          /* 테두리 추가 */
    border-radius: 10px;                             /* 둥근 모서리 설정 */
    width: 100%;                                     /* 전체 너비 사용 */
    max-width: 300px;                                /* 최대 너비 제한 */
}

/* 메뉴 항목 제목 스타일 */
.menu-item h3 {
    font-size: 18px;                                 /* 글꼴 크기 설정 */
    margin-bottom: 10px;                             /* 아래쪽 여백 설정 */
    color: #333;                                     /* 진한 회색 텍스트 */
}

/* 메뉴 항목 설명 스타일 */
.menu-item p {
    font-size: 12px;                                 /* 글꼴 크기 설정 */
    color: #666;                                     /* 중간 회색 텍스트 */
    line-height: 1.4;                                /* 줄 간격 설정 */
}

/* 메뉴 항목 링크 스타일 */
.menu-item h3 a {
    text-decoration: none;                           /* 밑줄 제거 */
    color: #333;                                     /* 진한 회색 텍스트 */
}

/* 메뉴 항목 링크 호버 및 방문 후 스타일 */
.menu-item h3 a:hover,
.menu-item h3 a:visited {
    color: #333;                                     /* 색상 유지 */
}

/* 메뉴 항목 링크 클릭 시 스타일 */
.menu-item h3 a:active {
    color: #333;                                     /* 색상 유지 */
} 
</style>
</head>
<body>
	<!-- 메인 콘텐츠 -->
	<div class="main-content">
		<%
            // 세션에서 전달된 사용자 정보 가져오기
            MemberVO loggedInMember = (MemberVO) request.getAttribute("loggedInMember");
            if (loggedInMember != null) {
        %>
		<div class="container">
			<p><%= loggedInMember.getMemName() %>님의 마이페이지입니다.
			</p>

			<div class="grid-menu">
			
				<div class="menu-item">
					<h3><a href="<%=request.getContextPath()%>/main?view=index">Home</a></h3>
					<p>메인 페이지로 이동합니다.</p>
					</div>
			
				<div class="menu-item">
					<h3><a href="<%=request.getContextPath()%>/member/logout.do">Logout</a></h3>
					<p>회원님의 로그인 상태를 비회원으로 전환합니다.</p>
				</div>
				
				<div class="menu-item">
					<h3><a href="<%=request.getContextPath()%>/member/editMember.do?memId=<%= loggedInMember.getMemId() %>">Profile</a>
</h3>			<p>회원이신 고객님의 개인정보를 관리하는 공간입니다.</p>
				</div>
				
				<div class="menu-item">
					<h3><a href="<%=request.getContextPath()%>/myreviewList.do?memId=<%=loggedInMember.getMemId()%>">Review</a></h3>
					<p>고객님께서 작성하신 리뷰를 관리하는 공간입니다.</p>
				</div>
				<div class="menu-item">
					<h3><a href="<%=request.getContextPath()%>/riturn/myBuyPage.do?memId=<%=loggedInMember.getMemId()%>">Order</a></h3>
					<p>고객님께서 주문하신 상품의 주문 내역을 확인하실 수 있습니다.</p>
				</div>
				<div class="menu-item">
					<h3><a href="<%=request.getContextPath()%>/prod/wishList.do">Wishlist</a></h3>
					<p>관심상품으로 등록하신 상품의 목록을 보여드립니다.</p>
				</div>
				<div class="menu-item">
					<h3><a href="<%=request.getContextPath()%>/coupon/mileCoupon.do?memId=<%=loggedInMember.getMemId()%>">Mileage/Coupon</a></h3>
					<p>고객님의 보유하고 계신 쿠폰과 마일리지 내역을 보여드립니다.</p>

				</div>
				
				<div class="menu-item">
					<h3><a href="<%=request.getContextPath()%>/riturn/riturnView.do?memId=<%=loggedInMember.getMemId()%>">Return</a></h3>
					<p>고객님께서 반품하신 상품의 반품 내역을 확인하실 수 있습니다.</p>

				</div>
					
					
				</div>
			</div>
		</div>
		<%
            } else {
        %>
		<p>로그인 정보가 없습니다.</p>
		<%
            }
        %>
</body>
</html>
