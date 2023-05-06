<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boot !!!</title>
</head>
<body>
	<h2>boot!!</h2>
	<h3><a href="${pageContext.request.contextPath}/member/memberAll.do">전체회원 조회</a></h3>
	
	<h2>파일 업로드 처리하기</h2>
	<form action="${pageContext.request.contextPath}/fileupload" method="post" enctype="multipart/form-data">
		<input type="file" name="upfile">
		<input type="submit" value="파일 전송">
	</form>
</body>
</html>