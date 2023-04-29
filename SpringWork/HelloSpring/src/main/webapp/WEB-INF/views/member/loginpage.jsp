<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 로그인 페이지</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/loginend.do" method="post">
		<input type="text" name="userId" /><br>
		<input type="password" name="pw" /><br>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>