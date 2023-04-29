<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AccessError</title>
</head>
<body>
	<h2>잘못된 접근 입니다.</h2>
	<h3 style="color:red">
	<%=exception != null ? exception.getMessage() : "에러발생" %> <br> 3초후 메인으로 이동</h3>
	<script>
		setTimeout(() => {
			location.replace("${pageContext.request.contextPath}");
		}, 3000);
	</script>
</body>
</html>