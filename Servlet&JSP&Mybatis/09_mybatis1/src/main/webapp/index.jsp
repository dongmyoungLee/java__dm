<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis 활용하기</title>
</head>
<body>
	<h2>MyBatis</h2>
	<p>
		MyBatis를 사용하기 위해서는 먼저 설정파일을 생성해야한다
		config : DB접속정보, mapper설정, DB연결관련 추가 설정 등..
		mapper : DB에 실행할 sql문, DB에서 가져온 데이터 맵핑정보를 설정
	</p>
	<p>
		MyBatis가 제공하는 클래스를 이용해서 연결 객체 만들기
		 -> Connection 객체를 생성한것과 동일한 작업임
		 
	</p>
	
	<h3><a href="${pageContext.request.contextPath }/insertStudent.do">학생정보등록</a></h3>
	
</body>
</html>