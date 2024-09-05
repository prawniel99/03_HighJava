<%@page import="kr.or.ddit.vo.FileInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>File Upload List</title>
	</head>
	
<%

	// 서블릿에서 보내온 자료 받기 // 형변환 항상 하는거! 가져오는건 스트링이니까!
	List<FileInfoVO> fileList = (List<FileInfoVO>)request.getAttribute("fileList");
	

%>
	
	<body>
		<h3>전체 파일 목록</h3>
		
		<a href="<%=request.getContextPath()%>/fileUpload.do">파일 업로드</a>
		
		<table border="1">
			<thead>
				<tr><th>번호</th><th>작성자</th><th>저장파일명</th>
				<th>원래의 파일명</th><th>파일 크기</th><th>날짜</th><th>비고</th></tr>
			</thead>
			
			<tbody>
			<%
				if(fileList == null || fileList.size() == 0){
			%>
					<tr><td colspan="7">파일 목록이 하나도 없습니다</td>
			<%		
				} else {
			
					for(FileInfoVO fileVo : fileList){
			%>
				<tr>
					<td><%=fileVo.getFile_no()%></td>
					<td><%=fileVo.getFile_writer()%></td>
					<td><%=fileVo.getSave_file_name()%></td>
					<td><%=fileVo.getOrigin_file_name()%></td>
					<td><%=fileVo.getFile_size()%></td>
					<td><%=fileVo.getFile_date()%></td>
					<td><a href="<%=request.getContextPath()%>/fileDownload.do?fileno=<%=fileVo.getFile_no()%>">Download</a></td>
				</tr>
			<%
					}
				}
			%>
			</tbody>
		</table>
	</body>
</html>






