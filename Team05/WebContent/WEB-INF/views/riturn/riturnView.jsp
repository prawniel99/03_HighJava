<%@page import="kr.or.ddit.riturn.vo.RiturnVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>반품 내역</title>
    <% List<RiturnVO> riList = (List<RiturnVO>)request.getAttribute("riList"); %>
    <style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #ffffff;
    display: flex;
    flex-direction: column;
    min-height: 100vh;
}

.container {
    flex-grow: 1;
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
}

.content-box {
    width: 70%;
    max-width: 900px;
    padding: 30px;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 10px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    text-align: center;
}

h2 {
    font-size: 24px;
    margin-bottom: 30px;
    color: #333;
    border-bottom: 1px solid #ddd;
    padding-bottom: 10px;
}

.product-list {
    margin-bottom: 40px;
}

.product-item {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
    padding: 10px;
    border: 1px solid #ddd;
    background-color: #fafafa;
}

.product-image {
    width: 150px;
    height: 150px;
    background-color: #f4f4f4;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 14px;
    color: #666;
}

.product-details {
    flex-grow: 1;
    margin-left: 20px;
    text-align: left;
}

.product-details p {
    margin: 5px 0;
}

.button-container {
    display: flex;
    justify-content: center; /* 중앙에 버튼을 배치 */
    gap: 10px; /* 버튼 사이 간격 */
    margin-top: 20px; /* 버튼 위쪽 간격 추가 */
}

.back-button, .home-button {
    width: 100px; /* 버튼 너비를 작게 설정 */
    padding: 10px; /* 여백을 줄여서 버튼 크기 축소 */
    background-color: #e4dcdc;
    border: none;
    border-radius: 5px;
    font-size: 14px; /* 글씨 크기 조정 */
    cursor: pointer;
    transition: background-color 0.3s;
    text-align: center;
}

.back-button:hover, .home-button:hover {
    background-color: #d3c5c5; /* 버튼 호버 시 더 진한 색 */
}

.footer {
    background-color: #e8e4d9;
    color: #333;
    text-align: center;
    padding: 10px 0;
    width: 100%;
    margin-top: auto;
}

h3 {
    text-align: center;
}


    </style>
</head>
<body>

<div class="container">
    <div class="content-box">
        <h3>반품 내역</h3>

        <div class="product-list">
            <% for(RiturnVO ri : riList){ %>
            <div class="product-item">
                <div class="product-image"><%=ri.getProd_image() %></div>
                <div class="product-details">
                    <p>상품 이름: <%=ri.getProd_name()%></p>
                    <p>주문 번호: <%=ri.getPay_id() %></p>
                    <p>반품 날짜: <%=ri.getRe_date() %></p>
                    <p>반품 사유: <%=ri.getRe_reason() %></p>
                </div>
            </div>
            <% } %>
        </div>
        
        <div>
 		<button class="back-button" onclick="history.back()">뒤로가기</button>
        <button class="home-button" onclick="location.href='<%=request.getContextPath()%>/main'">홈으로</button>
        </div>
        
        
    </div>
</div>



</body>
</html>
