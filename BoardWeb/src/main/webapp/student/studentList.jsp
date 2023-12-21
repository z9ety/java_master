<%@page import="common.Student"%>
<%@page import="java.util.List"%>
<%@page import="common.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>studentList.jsp</title>
</head>
<body>
	<table border='1'>
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>영어</th>
				<th>수학</th>
			</tr>
		</thead>
		<tbody>
			<%
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.getStudentList();
			for (Student std : list) {
			%>
			<tr>
				<td><a href='studentInfo.jsp?sno=<%=std.getStudentNo()%>'><%=std.getStudentNo()%></a></td>
				<td><%=std.getStudentName()%></td>
				<td><%=std.getStudentEng()%></td>
				<td><%=std.getStudentMath()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>