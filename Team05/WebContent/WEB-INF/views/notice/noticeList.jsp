<%@ page import="java.util.List"%>
<%@ page import="kr.or.ddit.notice.vo.NoticeVO" %>
<%@ page import="kr.or.ddit.util.PageVO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="kr.or.ddit.member.vo.MemberVO" %>
<%@ page contentType="text/html;charset=UTF-8" %>

		<%
        String adminId = "";
        if (session.getAttribute("loggedInAdmin") != null) {
            adminId = ((kr.or.ddit.member.vo.AdminVO)session.getAttribute("loggedInAdmin")).getAdminId();
        }
        %>

<!-- 기존 JSP 코드 유지 -->
<div class="container">
    <h2 class="title">
        <a href="<%= request.getContextPath() %>/notice/noticeList.do" class="title-link">
            공지사항
        </a>
    </h2>

    <!-- 검색창 추가 -->
    <div class="search-bar" style="text-align: right; margin-bottom: 20px;">
        <form action="<%= request.getContextPath() %>/notice/noticeList.do" method="get">
            <select name="stype" class="form-control" style="display: inline-block; width: auto; margin-right: 10px;">
                <option value="title">제목</option>
                <option value="content">내용</option>
                <option value="title_content">제목+내용</option>
                <option value="writer">작성자</option>
            </select>

            <input type="text" name="sword" placeholder="검색어 입력" class="form-control" style="display: inline-block; width: auto;">

            <button type="submit" class="btn">검색</button>
        </form>
    </div>

    <table class="notice-table">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        </thead>
        <tbody>
        <%
            SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            if (request.getAttribute("noticeList") != null) {
                List<NoticeVO> noticeList = (List<NoticeVO>) request.getAttribute("noticeList");
                for (NoticeVO notice : noticeList) {
                    String formattedDate = dateFormat.format(notice.getNotiDate());
        %>
        <tr>
            <td><%= notice.getNotiNo() %></td>
            <td><a href="<%= request.getContextPath() %>/notice/noticeDetail.do?notiNo=<%= notice.getNotiNo() %>
                &stype=<%= request.getParameter("stype") %>&sword=<%= request.getParameter("sword") %>" class="notice-link">
                <%= notice.getNotiTitle() %>
            </a></td>
            <td><%= notice.getAdminId() %></td>
            <td><%= formattedDate %></td>
        </tr>
        <%    }
        } %>
        </tbody>
    </table>

    <!-- 페이지네이션 -->
    <div class="pagination">
        <%
            PageVO pageInfo = (PageVO) request.getAttribute("pageInfo");

            if (pageInfo != null) {
                if (pageInfo.getStartPage() > 1) { %>
        <a href="<%= request.getContextPath() %>/notice/noticeList.do?page=<%= pageInfo.getStartPage() - 1 %>&stype=<%= request.getParameter("stype") %>&sword=<%= request.getParameter("sword") %>" class="page-link">이전</a>
        <% }
            for (int i = pageInfo.getStartPage(); i <= pageInfo.getEndPage(); i++) { %>
        <a href="<%= request.getContextPath() %>/notice/noticeList.do?page=<%= i %>&stype=<%= request.getParameter("stype") %>&sword=<%= request.getParameter("sword") %>" class="page-link <%= (pageInfo.getCurrentPage() == i) ? "active-page" : "" %>"><%= i %></a>
        <% }
            if (pageInfo.getEndPage() < pageInfo.getTotalPage()) { %>
        <a href="<%= request.getContextPath() %>/notice/noticeList.do?page=<%= pageInfo.getEndPage() + 1 %>&stype=<%= request.getParameter("stype") %>&sword=<%= request.getParameter("sword") %>" class="page-link">다음</a>
        <% }
        }
        %>
    </div>

    <!-- 글쓰기 버튼 (관리자만 표시) -->
    <%
        if ("admin".equals(adminId)) {
    %>
    <div class="write-btn">
        <a href="<%= request.getContextPath() %>/notice/insertNotice.do" class="btn">글쓰기</a>
    </div>
    <%
        }
    %>
</div>

<!-- 스타일링 -->
<style>
    body {
        font-family: 'Noto Sans', sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 20px;
        color: black; /* 기본 텍스트 색상을 검정으로 설정 */
    }

    .container {
        width: 80%;
        margin: 0 auto;
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    }

    .title {
        font-size: 28px;
        font-weight: 700;
        text-align: left;
        margin-bottom: 20px;
        color: black; /* 제목도 검정으로 설정 */
    }

    .search-bar {
        text-align: right;
        margin-bottom: 20px;
    }

    .search-bar form {
        display: inline-block;
    }

    .search-bar select, .search-bar input[type="text"], .search-bar button {
        padding: 8px;
        font-size: 14px;
        border: 1px solid #ddd;
        border-radius: 4px;
        color: black; /* 검색바 텍스트 색상도 검정으로 설정 */
    }

    .search-bar button {
        background-color: #f4f0e6;
        color: black;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    .search-bar button:hover {
        background-color: #f4f0e6;
        
    }

    /* 테이블 레이아웃 고정 */
    table.notice-table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
        table-layout: fixed; /* 고정 레이아웃 */
    }

    table.notice-table th, table.notice-table td {
        padding: 15px;
        text-align: left;
        border-bottom: 1px solid #ddd;
        word-wrap: break-word; /* 텍스트 줄 바꿈 */
        color: black; /* 테이블 텍스트 검정으로 설정 */
    }

    table.notice-table th {
        background-color: #f2f2f2;
        font-size: 16px;
        font-weight: 600;
        text-transform: uppercase;
        color: black; /* 테이블 헤더도 검정 */
    }

    table.notice-table td {
        text-align: left;
    }

    /* 각 열의 너비를 고정 */
    table.notice-table th:nth-child(1),
    table.notice-table td:nth-child(1) {
        width: 10%; /* 번호 */
    }

    table.notice-table th:nth-child(2),
    table.notice-table td:nth-child(2) {
        width: 50%; /* 제목 */
    }

    table.notice-table th:nth-child(3),
    table.notice-table td:nth-child(3) {
        width: 20%; /* 작성자 */
    }

    table.notice-table th:nth-child(4),
    table.notice-table td:nth-child(4) {
        width: 20%; /* 작성일 */
    }

    table.notice-table tr:hover {
        background-color: #f5f5f5;
    }

    /* 링크 스타일 설정 */
    a {
        text-decoration: none; /* 밑줄 제거 */
        color: black; /* 링크를 검정색으로 설정 */
    }

    a:hover {
        color: black; /* 링크가 눌릴 때도 검정색 유지 */
    }

    .title-link {
        font-size: 24px;
        text-decoration: none;
        color: black;
    }

    .notice-link {
        text-decoration: none;
        color: black;
    }

    .notice-link:hover {
        color: black; /* 링크를 눌러도 검정색 유지 */
    }

    /* 페이지네이션 */
    .pagination {
        text-align: center;
        margin-top: 20px;
    }

    .pagination a {
        margin: 0 5px;
        padding: 10px 15px;
        text-decoration: none;
        color: black; /* 페이지네이션 링크도 검정색 */
        background-color: #f4f0e6;
        border: 1px solid #ddd;
        border-radius: 4px;
        transition: all 0.3s ease;
    }

    .pagination a:hover {
        background-color: #f4f0e6;
    }

    .pagination .active-page {
        background-color: #e0d8b0;
        color: white;
        pointer-events: none;
        border: 1px solid #ddd;
    }

    /* 글쓰기 버튼 */
    .write-btn {
        text-align: right;
    }

    .write-btn a {
        display: inline-block;
        padding: 10px 20px;
        background-color: #f4f0e6; 
        color: black; /* 버튼의 텍스트도 검정색 */
        border-radius: 4px;
        text-decoration: none;
        transition: background-color 0.3s;
    }

    .write-btn a:hover {
        background-color: #f4f0e6;
    }
</style>
