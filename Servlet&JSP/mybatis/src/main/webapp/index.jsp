<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이바티스 활용하기</title>
</head>
<body>
	<h2>mybatis경험해보자</h2>
	<p>
		mybatis를 사용하기 위해서는 먼저 설정파일을 생성해야한다.
		config : DB접속정보, mapper설정, DB연결관련 추가 설정 등....
		mapper : DB에 실행할 sql문, DB에서 가져온 데이터 맵핑정보를 설정
	</p>
	<p>
		mybatis가 제공하는 클래스를 이용해서 연결(SqlSession)객체만들기
		 -> Connection객체를 생성한것과 동일한 작업
	</p>
	
	<h3>
		<a href="${pageContext.request.contextPath }/insertStudent.do">학생정보등록</a>
	</h3>
	
	<h3>학생이름을 입력받아 저장하기</h3>
	<form action="${pageContext.request.contextPath }/insertStudentParam.do" method="post">
		<input type="text" name="name" size="5">
		<input type="submit" value="학생저장"> 
	</form>
	
	<h3>학생정보 입력받아 저장하기</h3>
	<form action="${pageContext.request.contextPath }/insertStudentAll.do" method="post">
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="phone" placeholder="폰"><br>
		<input type="text" name="email" placeholder="이메일"><br>
		<input type="text" name="address" placeholder="주소"><br>
		<input type="submit" value="저장">
	</form>
	
	<h3>학생정보 수정하기</h3>
	<form action="${pageContext.request.contextPath }/updateStudent.do" method="post">
		<input type="text" name="studentNo" placeholder="수정할 학생번호" >
		<input type="text" name="name" placeholder="이름" >
		<input type="text" name="phone" placeholder="전화번호" >
		<input type="text" name="email" placeholder="이메일" >
		<input type="submit" value="수정" >
	</form>
	
	<h3>학생정보 삭제하기</h3>
	<form action="${pageContext.request.contextPath }/deleteStudent.do" method="post">
		<input type="text" name="no" placeholder="수정할 학생번호" >
		<input type="submit" value="삭제" >
	</form>
	
	<h2>DB에 저장된 데이터 조회하는 기능 구현하기</h2>
	<p></p>
</body>
</html>






