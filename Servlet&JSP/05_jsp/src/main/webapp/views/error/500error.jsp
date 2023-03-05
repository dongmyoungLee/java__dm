<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%
	int count = 3;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 style="color: red">500에러^^</h2>
	<p style="color: red">에러내용 : <%=exception.getMessage() %></p>
	
	<p>관리자에게 문의하세요 : (<%=count %> 초후에 메인화면으로 이동합니다.)</p>
	<script>
		let count = <%=count%>;
		setTimeout(() => {
			location.replace('<%=request.getContextPath()%>');
		}, 3000)
	</script>
</body>
</html>