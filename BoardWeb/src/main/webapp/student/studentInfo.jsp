<%@page import="com.yedam.student.vo.Student"%>
<%@page import="com.yedam.student.mapper.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>studentInfo.jsp</title>
</head>
<body>
	<%
	String str = "Hello";
	// 내장객체 : request
	String sno = request.getParameter("sno");
	StudentDAO dao = new StudentDAO();
	Student std = dao.getStudent(sno);
	%>
	<table border='1'>
		<caption>학생정보</caption>
		<tr>
			<th>학생번호</th>
			<td><%=std.getStudentNo()%></td>
		</tr>
		<tr>
			<th>학생이름</th>
			<td><%=std.getStudentName()%></td>
		</tr>
		<tr>
			<th>영어</th>
			<td><%=std.getStudentEng()%></td>
		</tr>
		<tr>
			<th>수학</th>
			<td><%=std.getStudentMath()%></td>
		</tr>
	</table>
	<a href='studentList.jsp'>목록</a>
</body>
</html>