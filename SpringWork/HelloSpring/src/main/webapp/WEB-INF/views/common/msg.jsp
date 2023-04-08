<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	
	</head>
	<body>
		<script>
			alert("${msg}");
			location.replace("${pageContext.request.contextPath}${loc}");
		</script>
	</body>
</html>