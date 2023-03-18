<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>El 표현식 활용</title>
</head>
<body></body>
	<h2>EL 표현식 활용하기</h2>
	<p>EL은 <%-- ${ } --%> 표현을 이용해서 데이터를 출력하는 방식을 의미함</p>
	<p>EL 에서 출력하는 데이터는 내장객체에 저장된 데이터, parameter 로 전송된데이터,
		requestHeader, Cookie 에 저장된 데이터등을 의미한다.
		* 지역변수로 선언된 데이터는 못불러옴
	</p>
	<h3>리터럴값 EL 표현식으로 출력하기</h3>
	<p><%= "안녕하세요" %> <%= 19 %></p>
	<p>${"안녕하세요"} ${19 }</p>
	<%String name = "유병승"; %>
	<p>${name } -> 못불러온다.</p>
	<h3>내장객체(HttpServletRequest, HttpSession, ServletContext)에 저장된 데이터를 불러오기</h3>
	<p>request, session, application</p>
	<%
		request.setAttribute("name2", name);
	%>
	<p>${ name2 }</p>