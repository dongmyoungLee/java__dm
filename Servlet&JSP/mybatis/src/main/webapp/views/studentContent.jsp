<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생정보</h2>
	<h3>학생정보출력</h3>
	<table>
		<c:if test="${empty list}">
			<tr>
				<td colspan="6">조회된 데이터가 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty list }">
			<c:forEach var="s" items="${list }">
				<tr>
					<td>${s.studentNo }</td>
					<td>${s.name }</td>
					<td>${s.phone }</td>
					<td>${s.email }</td>
					<td>${s.address }</td>
					<td>${s.reg_date }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div id="pageBar">
		${pageBar }
	</div>
</body>
</html>