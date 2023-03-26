<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동적쿼리작성</title>
</head>
<body>
	<h3><a href="${path}/emp/selectEmpAll.do">전체사원 조회하기</a></h3>
	
	<h3><a href="${path}/job/selectjob.do?jobcode=J6">클래스 연관관계 맵핑하기 -job-</a></h3>
	
	<h2><a href="${path}/member/memberList.do">web member 가져오기</a></h2>
</body>
</html>