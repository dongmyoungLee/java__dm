<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL 함수 이용하기</h2>
	<c:set var="data" value="How Are You ? I am Fine" />
	<p><c:out value="${data }" /></p>
	<p>${fn:toUpperCase(data) }</p>
	<p>${fn:replace(data, "fine", "tired") }</p>
	<p>${fn:contains(data, "You") ? "test" : "test22"}</p>
	
</body>
</html>