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
		<%-- <tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>등록일</th>
		</tr>
		<c:if test="${student != null }">
			<td>${student.studentNo }</td>
			<td>${student.name }</td>
			<td>${student.phone }</td>
			<td>${student.email }</td>
			<td>${student.address }</td>
			<td>${student.reg_date }</td>
		</c:if>
		<c:if test="${student == null }">
			<tr>
				<td colspan="6">조회한 결과가 없습니다.</td>
			</tr>
		</c:if> --%>
	</table>
</body>
</html>