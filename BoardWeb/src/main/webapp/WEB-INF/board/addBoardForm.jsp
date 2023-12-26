<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>addBoardForm.jsp</title>
</head>
<body>
	<h3>등록화면</h3>
	<form action="addBoard.do">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="30" rows="10"></textarea></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="홍길동"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="저장">
				<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>