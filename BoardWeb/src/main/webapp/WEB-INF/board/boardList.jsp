<%@page import="com.yedam.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h3>게시판</h3>
<!-- EL(Expression Language) -->
<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${boardList }">
			<tr>
				<td>${vo.boardNo}</td>
				<td><a href="getBoard.do?bno=${vo.boardNo}">${vo.title}</a></td>
				<td>${vo.writer}</td>
				<td><fmt:formatDate value="${vo.writerDate}" pattern="yyyy-MM-dd" /></td>
				<td>${vo.clickCnt}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
