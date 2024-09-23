<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.image.vo.ImageVO"%>
<%@page import="kr.or.ddit.review.vo.ReviewVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>리뷰 수정</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#btnList").on("click", function(){
                location.href="<%=request.getContextPath()%>/reviewList.do";
            });

            $("#btnUpdate").on("click", function(){
                $("#reviewForm").submit(); 
            });
        });
    </script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffffff; /* 배경 흰색 */
            margin: 20px;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }

        .review-container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            border: 1px solid #ddd;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }

        td:first-child {
            background-color: #f8f8f8; /* 연한 회색 */
            font-weight: bold;
            color: #333;
            width: 25%;
            text-align: left;
        }

        td:last-child {
            text-align: left;
            width: 75%;
        }

        textarea, input[type="number"], input[type="file"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .image-gallery {
            display: flex;
            flex-wrap: wrap;
            gap: 10px;
            justify-content: flex-start;
        }

        .image-gallery img {
            width: 100px;
            height: 100px;
            object-fit: cover;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .image-gallery label {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 10px;
        }

        .btn-group {
            text-align: center;
            margin-top: 20px;
        }

        input[type="button"], input[type="submit"], input[type="reset"] {
            background-color: #f2e6d6; /* 연한 아이보리 */
            color: #333;
            border: none;
            padding: 10px 20px;
            margin: 10px;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="button"]:hover, input[type="submit"], input[type="reset"]:hover {
            background-color: #f0d4d4; /* 연한 핑크색 */
        }

    </style>
</head>
<body>
<h2>리뷰 수정</h2>
<% 
    ReviewVO rvo = (ReviewVO)request.getAttribute("reviewVo"); 
    List<ImageVO> imageList = (List<ImageVO>)request.getAttribute("imageList");

    if (rvo == null) {
        out.println("리뷰 정보를 찾을 수 없습니다.");
        return;
    }
%>
<div class="review-container">
    <form id="reviewForm" method="post" action="<%=request.getContextPath()%>/reviewUpdate.do" enctype="multipart/form-data">
        <input type="hidden" name="review_id" value="<%=rvo.getReview_id()%>">
        <table>
            <tr>
                <td>리뷰 번호</td>
                <td><%=rvo.getReview_id()%></td>
            </tr>
            <tr>
                <td>리뷰 별점</td>
                <td><input type="number" name="review_star" value="<%=rvo.getReview_star()%>" min="1" max="5"></td>
            </tr>
            <tr>
                <td>리뷰 내용</td>
                <td><textarea name="review_content" rows="5" cols="40"><%=rvo.getReview_content()%></textarea></td>
            </tr>
            <tr>
                <td>첨부 이미지</td>
                <td>
                    <div class="image-gallery">
                    <% if (imageList != null && !imageList.isEmpty()) { %>
                        <% for (ImageVO image : imageList) { %>
                            <label>
                                <input type="checkbox" name="deleteImage" value="<%=image.getImageId()%>"> 삭제
                                <img src="<%=request.getContextPath() %>/PhotoView.do?image=<%= image.getImagePath() %>" alt="첨부 이미지" class="notice-image">
                            </label>
                        <% } %>
                    <% } else { %>
                        <p>첨부된 이미지가 없습니다.</p>
                    <% } %>
                    </div>
                </td>
            </tr>
            <tr>
                <td>이미지 추가</td>
                <td><input type="file" name="file" multiple></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;">
                    <input id="btnUpdate" type="button" value="수정">
                    <input type="reset" value="취소">
                    <input id="btnList" type="button" value="리스트로 돌아가기">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
