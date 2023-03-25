<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- core태그 : 조건문, 반복문, 변수저장, 변수출력 태그제공 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<!-- fmt태그 : 숫자, 날짜에 대해 문자열 패턴으로 변환해주는 태그를 제공 -->	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl 활용하기</title>
</head>
<body>
	<h2>jstl 활용하기</h2>
	<p>
		1.jstl 활용하려면 제공하는 jar 파일을 추가해야한다.
		2. 이용할태그에 대해 페이지마다 선언해줘야함.
	</p>
	
	<%request.setAttribute("name", "유병승"); %>
	
	<c:if test="${name == null }">
		<h2>name 데이터는 없습니다.</h2>
	</c:if>
</body>
</html>