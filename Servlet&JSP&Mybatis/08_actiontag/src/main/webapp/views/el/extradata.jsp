<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>cookie 데이터 가져오기</h2>
	<p>${cookie }</p>
	<p>${cookie.cValue }</p>
	<p>${cookie.cValue.name }</p>
	<p>${cookie.cValue.value }</p>
	
	<h2>header의 정보가져오기</h2>
	<p>${header }</p>
	<p>${header['user-agent'] }</p>
	<p>${header['referer'] }</p>
</body>
</html>