<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원추가</title>
</head>
<body>
	<h1>회원 정보 입력 폼</h1>
	<form>
		<table border="1">
			<tr>
				<td>회원ID</td>
				<td><input type="text" class="addInput"><input type="button" value="중복확인"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" class="addInput"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="text" class="addInput"></td>
			</tr>
			<tr>
				<td>회원이름</td>
				<td><input type="text" class="addInput"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" class="addInput"></td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td><input type="text" class="addInput"></td>
			</tr>
			<tr>
				<td>프로필사진</td>
				<td><input type="file" name="upFile1"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="저장">
					<input type="button" value="취소">
					<input type="button" value="회원목록">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>