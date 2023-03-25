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
	<p>select 문을 실행한 결과를 java에서 사용하는 vo객체에 저장</p>
	<p>mybatis 에서는 resultSet 으로 가져온 데이터를 지정한 vo에 자동으로 저장해줌 -> mapping</p>
	
	<h3>학생 수 조회하기</h3>
	<h4><a href="${pageContext.request.contextPath}/student/studentCount.do">학생수 조회하기</a></h4>
	
	<h4>
		<a href="${pageContext.request.contextPath}/student/selectStudent.do?no=61">61 학생 조회</a>
	</h4>
	
	<h4>이름으로 조회</h4>
	<form action="${pageContext.request.contextPath }/student/selectStudentName.do" method="post">
		<input type="text" name="name" placeholder="조회할 이름" >
		<input type="submit" value="조회" >
	</form>
	
	
	<h4>
		<a href="${pageContext.request.contextPath}/student/selectAll.do">전체학생조회</a>
	</h4>
	
	<h4>vo 객체를 생성하지 않고 db데이터를 가져오기</h4>
	<p>HashMap 클래스를 이용해서 저장관리할 수 있다.</p>
	<h4><a href="${pageContext.request.contextPath}/student/selectStusentMap.do?no=61">61번학생조회 Map으로조회</a></h4>
	
	
	<h4><a href="${pageContext.request.contextPath}/student/selectStusentMapAll.do">전체학생조회 Map으로조회</a></h4>
	
	<h3>페이징처리 하기</h3>
	<p>mybatis 에서 페이징처리.. selectList메소드에 페이징처리용 클래스를 생성해서 매개변수를 넣어주면 된다.</p>
	<h4><a href="${pageContext.request.contextPath}/student/studentPage.do">페이징 처리하기</a></h4>
	
	<h3>Map을 이용해서 학생정보입력받아 저장하기</h3>
	   <form action="${pageContext.request.contextPath }/student/insertStudentInfoMap.do"
	   method="post">
	      <input type="text" name="name"><br>
	      <input type="text" name="phone"><br>
	      <input type="text" name="email"><br>
	      <input type="text" name="address"><br>
	      <input type="submit" value="저장">
	   </form>
	   <h3>Map을 이용해서 학생정보 수정하기</h3>
	   <form action=""
	   method="post">
	      <input type="text" name="studentNo" placeholder="수정할 학생번호"/>
	      <input type="text" name="name" placeholder="이름"/>
	      <input type="text" name="phone" placeholder="전화번호"/>
	      <input type="text" name="email" placeholder="이메일"/>
	      <input type="submit" value="학생정보수정">
	   </form>
</body>
</html>











