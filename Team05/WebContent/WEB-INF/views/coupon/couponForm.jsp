<%@page import="kr.or.ddit.coupon.vo.CouponVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="kr.or.ddit.member.vo.MemberVO"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>쿠폰 등록</title>
    <style>
body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 20px;
    background-color: #ffffff; /* 흰색 배경 */
    display: flex;
    flex-direction: column;
    min-height: 100vh;
}

.container {
    max-width: 600px;
    margin: 0 auto;
    padding: 30px;
    background-color: #fff;
    border: 1px solid #ddd;
    box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
}

h1 {
    text-align: center;
    color: #333;
    margin-bottom: 20px;
    font-size: 24px;
}

label {
    display: block;
    margin-bottom: 8px;
    color: #555;
    font-weight: bold;
}

input[type="text"], input[type="date"], select {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    box-sizing: border-box;
}

/* 버튼 컨테이너에 flexbox 적용 */
.button-container {
    display: flex;
    justify-content: space-between; /* 버튼 사이 공간 */
    gap: 10px; /* 버튼 간 간격 */
}

input[type="submit"], .batch-submit-btn {
    flex: 1; /* 모든 버튼이 동일한 크기를 갖도록 */
    background-color: #e0d6d6; /* 연한 베이지 */
    color: white;
    padding: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px; /* 글씨 크기 살짝 줄임 */
}

input[type="submit"]:hover, .batch-submit-btn:hover {
    background-color: #d0cfcf; /* 버튼 hover 시 더 진한 색 */
}

.form-group {
    margin-bottom: 20px;
}


    </style>
    <script>
    window.onload = function() {
        // 여러 회원에게 한번에 쿠폰을 등록하는 함수
        window.submitBatchForm = function() {
            const form = document.createElement('form');
            form.method = 'post';
            form.action = '<%=request.getContextPath()%>/coupon/allInsert.do';

            // 회원 선택한 값들을 추가
            const memSelect = document.getElementById('mem_id');
            for (let i = 0; i < memSelect.options.length; i++) {
                const input = document.createElement('input');
                input.type = 'hidden';
                input.name = 'mem_id';
                input.value = memSelect.options[i].value;
                form.appendChild(input);
            }

            // 유효기간, 할인율, 이름도 추가
            const coupEdate = document.getElementById('coup_edate').value;
            const coupAmount = document.getElementById('coup_amount').value;
            const coupName = document.getElementById('coup_name').value;

            const edateInput = document.createElement('input');
            edateInput.type = 'hidden';
            edateInput.name = 'coup_edate';
            edateInput.value = coupEdate;
            form.appendChild(edateInput);

            const amountInput = document.createElement('input');
            amountInput.type = 'hidden';
            amountInput.name = 'coup_amount';
            amountInput.value = coupAmount;
            form.appendChild(amountInput);

            const nameInput = document.createElement('input');
            nameInput.type = 'hidden';
            nameInput.name = 'coup_name';
            nameInput.value = coupName;
            form.appendChild(nameInput);

            // 폼을 제출
            document.body.appendChild(form);
            form.submit();
        }
    };

    </script>
</head>
<body>
    <div class="container">
        <h1>쿠폰 등록</h1>
        <form action="<%=request.getContextPath()%>/coupon/couponInsert.do" method="post">
            <div class="form-group">
                <label for="mem_id">회원 선택 :</label>
                <select name="mem_id" id="mem_id">
                    <%
                        List<CouponVO> memberList = (List<CouponVO>) request.getAttribute("coupList");
                        for (CouponVO member : memberList) {
                    %>
                        <option value="<%= member.getMem_id() %>"><%= member.getMem_id() %></option>
                    <%
                        }
                    %>
                </select>
            </div>
            
            <div class="form-group">
                <label for="coup_edate">유효 기간:</label>
                <input type="date" name="coup_edate" id="coup_edate">
            </div>
            
            <div class="form-group">
                <label for="coup_amount">쿠폰 할인율:</label>
                <input type="text" name="coup_amount" id="coup_amount" placeholder="숫자로 입력"> 
            </div>
            
            <div class="form-group">
                <label for="coup_name">쿠폰 이름:</label>
                <input type="text" name="coup_name" id="coup_name" placeholder="쿠폰 이름을 입력하세요">
            </div>
            
            <div class="button-container">
	            <input type="submit" value="쿠폰 등록">
	            <!-- 여러 회원에게 한번에 등록하는 버튼 -->
	            <button type="button" class="batch-submit-btn" onclick="submitBatchForm()">한번에 등록하기</button>
	            <button type="button" class="batch-submit-btn" onclick="history.back()">뒤로가기</button>
        	</div>
        </form>
    </div>
</body>
</html>
