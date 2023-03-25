<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보 Map으로 가져오기</title>
</head>
<body>
	<h2>학생정보</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>등록일</th>
		</tr>
		<c:if test="${empty student}">
			<tr>
				<td colspan="6">조회된 데이터가 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty student }">
			<c:forEach var="s1" items="${student }">
				<tr>
					<td>${s1["STUDENT_NO"] }</td>
					<td>${s1["STUDENT_NAME"] }</td>
					<td>${s1["STUDENT_TEL"] }</td>
					<td>${s1["STUDENT_EMAIL"] }</td>
					<td>${s1["STUDENT_REG_DATE"] }</td>
				</tr>
			</c:forEach>
		</c:if>
		
		<%-- 주석 이걸로 작성 --%>
		<%-- <c:if test="${student != null }">
			<tr>
				<td>${student["STUDENT_NO"] }</td>
				<td>${student["STUDENT_NAME"] }</td>
				<td>${student["STUDENT_TEL"] }</td>
				<td>${student["STUDENT_EMAIL"] }</td>
				<td>${student["STUDENT_ADDR"] }</td>
				<td>${student["STUDENT_REG_DATE"] }</td>
			</tr>
		</c:if>
 		--%>		
	</table>
</body>
</html>