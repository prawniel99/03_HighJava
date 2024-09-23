<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 대시보드</title>
<style>
/* 전체 페이지 스타일 */
body {
    font-family: Arial, sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
    background-color: #f0f0f0;
}

/* 대시보드 컨테이너 스타일 */
.container {
    background-color: white;
    padding: 2rem;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 600px;
}

/* 제목 스타일 */
h1 {
    text-align: center;
    color: #333;
}

/* 메뉴 버튼 스타일 */
.menu-button {
    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 0.75rem 1rem;
    cursor: pointer;
    font-size: 1rem;
    margin-top: 1rem;
    width: 100%;
    text-align: left;
}

.menu-button:hover {
    background-color: #45a049;
}

/* 로그아웃 버튼 스타일 */
.logout-button {
    background-color: #f44336;
    color: white;
    border: none;
    padding: 0.75rem;
    cursor: pointer;
    font-size: 1rem;
    margin-top: 1rem;
    width: 100%;
}

.logout-button:hover {
    background-color: #d32f2f;
}
</style>
</head>
<body>
    <div class="container">
        <h1>관리자 대시보드(임시)</h1>
        
        <%
        String adminId = "";
        if (session.getAttribute("loggedInUser") != null) {
            adminId = ((kr.or.ddit.member.vo.AdminVO)session.getAttribute("loggedInUser")).getAdminId();
        }
        %>
       
        <p>안녕하세요. 관리자 페이지 입니다.</p>
        
        <button class="menu-button" onclick="location.href='<%=request.getContextPath()%>/member/memberListHAMIN.do'">회원 관리</button>
        <button class="menu-button" onclick="location.href='<%=request.getContextPath()%>/member/adminDashboardHAMIN.do'">대시보드</button>
        <!-- 하민 -->
        <button class="menu-button" onclick="location.href='<%=request.getContextPath()%>/mainHAMIN?view=indexHAMIN'">index</button>
        <!-- 하민 -->
        
        <form action="<%=request.getContextPath()%>/member/logout.do" method="post">
            <input type="submit" value="로그아웃" class="logout-button">
        </form>
    </div>
</body>
</html>