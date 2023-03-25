<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] students = (String[])request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생정보</h2>
	<ul>
		<%for(String s : students) { %>
			<li><%=s %></li>
		<%} %>
	</ul>
</body>
</html>