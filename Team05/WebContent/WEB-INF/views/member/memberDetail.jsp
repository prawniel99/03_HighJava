<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kr.or.ddit.member.vo.MemberVO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 상세 정보</title>
    <style>
    /* - 정석진 2024-09-23-  */
    /* 전체 페이지 스타일 */
body {
    font-family: Arial, sans-serif;                  /* Arial 폰트 사용 */
    display: flex;                                   /* Flexbox 레이아웃 사용 */
    justify-content: center;                         /* 수평 중앙 정렬 */
    align-items: center;                             /* 수직 중앙 정렬 */
    height: 100vh;                                   /* 뷰포트 높이의 100% 설정 */
    margin: 0;                                       /* 바깥 여백 제거 */
}

/* 컨테이너 스타일 */
.container {
    background-color: rgba(230, 226, 211, 0.8);      /* 반투명한 베이지색 배경 */
    padding: 2rem;                                   /* 안쪽 여백 설정 */
    border-radius: 8px;                              /* 둥근 모서리 설정 */
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);        /* 그림자 효과 추가 */
    width: 350px;                                    /* 컨테이너 너비 설정 */
    backdrop-filter: blur(5px);                      /* 배경 흐림 효과 추가 */
}

/* 제목 스타일 */
h2 {
    text-align: center;                              /* 텍스트 중앙 정렬 */
    color: #4a4a4a;                                  /* 진한 회색 텍스트 색상 */
    margin-bottom: 1.5rem;                           /* 아래쪽 여백 설정 */
}

/* 테이블 스타일 */
table {
    width: 100%;                                     /* 테이블 전체 너비 설정 */
    border-collapse: collapse;                       /* 셀 경계선 병합 */
    margin-bottom: 20px;                             /* 아래쪽 여백 설정 */
}

/* 테이블 헤더와 셀 공통 스타일 */
th, td {
    padding: 10px;                                   /* 셀 안쪽 여백 설정 */
    border: 1px solid #d4cfc0;                       /* 연한 베이지색 테두리 */
    text-align: left;                                /* 텍스트 왼쪽 정렬 */
}

/* 테이블 헤더 스타일 */
th {
    background-color: #e6e2d3;                       /* 연한 베이지색 배경 */
    font-weight: bold;                               /* 굵은 글씨체 */
    color: #4a4a4a;                                  /* 진한 회색 텍스트 색상 */
    text-align: center;                              /* 텍스트 중앙 정렬 */
    width: 30%;                                      /* 첫 번째 열의 너비를 30%로 고정 */
}

/* 버튼 컨테이너 스타일 */
.button-container {
    display: flex;                                   /* Flexbox 레이아웃 사용 */
    justify-content: space-between;                  /* 버튼 사이에 공간을 균등하게 분배 */
    margin-top: 20px;                                /* 위쪽 여백 설정 */
}

/* 버튼 공통 스타일 */
.btn {
    padding: 10px 5px;                               /* 안쪽 여백 설정 */
    border: none;                                    /* 테두리 제거 */
    border-radius: 4px;                              /* 둥근 모서리 설정 */
    cursor: pointer;                                 /* 마우스 오버 시 포인터 모양 변경 */
    font-size: 14px;                                 /* 글꼴 크기 설정 */
    color: white;                                    /* 흰색 텍스트 */
    width: 22%;                                      /* 버튼 너비 설정 */
    text-align: center;                              /* 텍스트 중앙 정렬 */
    text-decoration: none;                           /* 텍스트 장식 제거 */
    display: flex;                                   /* Flexbox 레이아웃 사용 */
    justify-content: center;                         /* 수평 중앙 정렬 */
    align-items: center;                             /* 수직 중앙 정렬 */
    transition: background-color 0.3s;               /* 배경색 전환 효과 */
    height: 40px;                                    /* 모든 버튼의 높이를 동일하게 설정 */
}

/* 수정 버튼 스타일 */
.btn-edit {
    background-color: #7a6f5d;                       /* 갈색 배경 */
    color: white;                                    /* 흰색 텍스트 */
    text-decoration: none;                           /* 텍스트 장식 제거 */
}

.btn-edit:hover {
    background-color: #5f5648;                       /* 호버 시 진한 갈색으로 변경 */
}

/* 삭제 버튼 스타일 */
.btn-delete {
    background-color: #d32f2f;                       /* 빨간색 배경 */
}

.btn-delete:hover {
    background-color: #b71c1c;                       /* 호버 시 진한 빨간색으로 변경 */
}

/* 뒤로 버튼 스타일 */
.btn-back {
    background-color: #9e9e9e;                       /* 회색 배경 */
}

.btn-back:hover {
    background-color: #757575;                       /* 호버 시 진한 회색으로 변경 */
}

/* 로그아웃 버튼 스타일 */
.btn-logout {
    background-color: #607d8b;                       /* 청회색 배경 */
}

.btn-logout:hover {
    background-color: #455a64;                       /* 호버 시 진한 청회색으로 변경 */
}

/* 에러 메시지 스타일 */
.error-message {
    color: #d32f2f;                                  /* 빨간색 텍스트 */
    text-align: center;                              /* 텍스트 중앙 정렬 */
    margin-bottom: 10px;                             /* 아래쪽 여백 설정 */
    font-size: 0.9em;                                /* 글꼴 크기 설정 */
}
</style>
    <script>
    // 회원 삭제 확인 함수
    function confirmDelete() {
        if(confirm('정말로 회원을 삭제하시겠습니까?')) {
            // 확인 시 숨겨진 삭제 폼 제출
            document.getElementById('deleteForm').submit();
        }
    }
    
    // 로그아웃 함수
    function logout() {
        if(confirm('로그아웃 하시겠습니까?')) {
            // 확인 시 로그아웃 처리 페이지로 이동
            location.href = '<%=request.getContextPath()%>/member/logout.do';
        }
    }
    </script>
</head>
<body>
    <div class="container">
        <h2>회원 상세 정보</h2>
        
        <%
            // 컨트롤러에서 전달받은 회원 정보를 가져옴
            MemberVO memberDetail = (MemberVO) request.getAttribute("memberDetail");
            
            // 생년월일 포맷팅을 위한 SimpleDateFormat 객체 생성
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
        %>
        
        <!-- 회원 정보를 표시하는 테이블 -->
        <table>
            <tr>
                <th>ID</th>
                <td><%= memberDetail.getMemId() %></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><%= memberDetail.getMemName() %></td>
            </tr>
            <tr>
                <th>생년월일</th>
                <td>
                    <%
                        Date memBirth = memberDetail.getMemBirth();
                        // 생년월일이 null이 아닐 경우 포맷팅, 그렇지 않으면 "정보 없음" 표시
                        out.print(memBirth != null ? sdf.format(memBirth) : "정보 없음");
                    %>
                </td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><%= memberDetail.getMemEmail() %></td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td><%= memberDetail.getMemPhone() %></td>
            </tr>
            <tr>
                <th>주소</th>
                <td><%= memberDetail.getMemAddress() %></td>
            </tr>
            <tr>
                <th>상세주소</th>
                <td><%= memberDetail.getMemDetailAddress() %></td>
            </tr>
            <tr>
                <th>마일리지</th>
                <td><%= memberDetail.getMemMileage() %></td>
            </tr>
            <tr>
                <th>상태</th>
                <td><%= memberDetail.getMemStatus() == 1 ? "활성" : "비활성" %></td>
            </tr>
        </table>
        
        <!-- 회원 삭제 실패 시 에러 메시지 표시 -->
        <% if(request.getParameter("error") != null && request.getParameter("error").equals("deleteFailed")) { %>
            <p class="error-message">회원 삭제에 실패했습니다.</p>
        <% } %>
        
        <!-- 버튼 그룹 -->
        <div class="button-container">
            <!-- 수정 버튼: 회원 정보 수정 페이지로 이동 (스타일 적용) -->
            <button onclick="location.href='<%=request.getContextPath()%>/member/editMember.do?memId=<%= memberDetail.getMemId() %>'" class="btn btn-edit">수정</button>
            
            <!-- 삭제 버튼: 삭제 확인 함수 호출 -->
            <button type="button" onclick="confirmDelete()" class="btn btn-delete">회원탈퇴</button>
            
            <!-- 뒤로가기 버튼 -->
            <button type="button" class="btn btn-back" onclick="history.back()">뒤로가기</button>
            
            <!-- 로그아웃 버튼: 로그아웃 함수 호출 -->
            <button type="button" onclick="logout()" class="btn btn-logout">로그아웃</button>
        </div>
        
        <!-- 회원 삭제를 위한 숨겨진 폼 -->
        <form id="deleteForm" action="<%=request.getContextPath()%>/member/deleteMember.do" method="post" style="display:none;">
            <input type="hidden" name="memId" value="<%= memberDetail.getMemId() %>">
        </form>
    </div>
</body>
</html>