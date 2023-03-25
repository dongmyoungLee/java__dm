<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core 태그이용</title>
</head>
<body>
	<h2>set/out 태그 이용하기</h2>
	<p>c:set태그 -> 필요한 데이터를 저장하는 태그 -> key, value 형식</p>
	<p>c:out태그 -> 저장된 데이터를 출력해주는 태그 -> key 값으로...</p>
	
	<ul>c:set 태그 속성
		<li> var : key 이름(변수명)</li>
		<li> value : value, 저장될 데이터</li>
		<li> scope : 저장될 객체를 지정(request, session, application)</li>
	</ul>
	
	<ul>c:out 태그 속성
		<li>value : 페이지에 출력될 값, EL표현식으로 key값 설정, 리터럴가능</li>
		<li>default : value에 설정한 값이 없을경우 출력할 값</li>
		<li>escapeXml : value 값에 html 코드가 있을때 해석할지 문자열로 처리할지 결정</li>
	</ul>
	
	<h3>변수선언하기</h3>
	<c:set var="comment" value="꽃피는 봄이네요" />
	<p>c:set 태그로 저장된 내용은 EL이나, c:out 태그로 출력할 수 있다.</p>
	<h4>${comment }</h4>
	<h4><c:out value="${comment }" /></h4>
	<c:set var="path" value="${pageContext.request.contextPath }" />
	<a href="${path }/test/test.do">test</a>  
	
	<h3>저장할때 영역설정하기</h3>
	<c:set var="request" value="requestData" scope="request" />
	<c:set var="session" value="sessionData" scope="session" />
	<c:set var="session" value="requestSessionData" scope="request" />
	<p>${request } ${session } ${sessionScope.session }</p>
	
	<h3>c:out 태그를 이용해서 출력하기</h3>
	<p><c:out value="안녕하세요" /></p>
	<p><c:out value="${request }" /></p>
	
	<c:set var="data" value="<script>location.assign('http://www.naver.com')</script>"/>
	
	<p><c:out value="${data }" /></p>
	
	<c:set var="tag" value="<h3>태그를 출력하자</h3>" />
	
	<div>
		<c:out value="${tag }" escapeXml="false" />
	</div>
	
	<h3>기본값 설정하기</h3>
	<c:set var="defaultdata" value="실제데이터" />
	<p><c:out value="${defaultdata }" default="기본값으로 출력" /></p>
	<c:set var="images" value="https://mp-seoul-image-production-s3.mangoplate.com/597979_1629857347523897.jpg?fit=around|738:738&crop=738:738;*,*&output-format=jpg&output-quality=80" />
	<img src="<c:out value="${images }" default="" />">
</body>
</html>



