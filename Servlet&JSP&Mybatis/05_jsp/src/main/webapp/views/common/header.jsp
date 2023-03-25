<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<ul>
			<li><a href="<%=request.getContextPath()%>/index.jsp">메인화면</a></li>
			<li><a href="<%=request.getContextPath()%>/views/board.jsp">게시판</a></li>
			<li><a href="<%=request.getContextPath()%>/views/gallery.jsp">갤러리</a></li>
		</ul>
	</header>