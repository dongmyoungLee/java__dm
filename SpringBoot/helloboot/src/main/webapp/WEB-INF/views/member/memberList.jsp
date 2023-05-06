<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 조회</title>
</head>
<body>
	<div>
		<form action="${pageContext.request.contextPath}/member/searchMember.do">
			<span>조회할 ID</span>
			<input type="text" name="id">
			<input type="submit" value="조회"> 
		</form>
	</div>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>나이</th>
			<th>이메일</th>
			<th>전화번호</th>			
		</tr>
		<c:forEach var="m" items="${members}">
			<tr>
				<td>${m.userId}</td>
				<td>${m.userName}</td>
				<td>${m.age}</td>
				<td>${m.email}</td>
				<td>${m.phone}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>