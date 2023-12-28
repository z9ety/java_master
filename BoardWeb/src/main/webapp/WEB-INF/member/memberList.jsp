<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- member/memberList.jsp -->
<!-- 아이디 이름 비밀번호 권한 -->
<h3>회원목록</h3>

<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>권한</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="Mvo" items="${memberList }">
			<tr>
				<td><a href="getMember.do?id=${Mvo.id}">${Mvo.id }</a></td>
				<td>${Mvo.pw }</td>
				<td>${Mvo.name }</td>
				<td>${Mvo.responsibility }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>