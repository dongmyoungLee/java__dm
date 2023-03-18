<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
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
	<p><%=request.getAttribute("name2") %></p>
	<%
		session.setAttribute("age", 19);
		application.setAttribute("address", "경기도 시흥시");
	%>
	<p>age : ${age }</p>
	<p>address : ${address }</p>
	
	<h4>
		<a href="<%=request.getContextPath()%>/ElDataTestServlet">내장객체</a>
	</h4>
	
	<h3>파라미터 전송하기</h3>
	<form action="<%=request.getContextPath()%>/ElDataTestServlet">
		<input type="text" name="msg" ><br>
		<input type="checkbox" name="hobby" value="운동">운동
		<input type="checkbox" name="hobby" value="코딩">코딩
		<input type="checkbox" name="hobby" value="등산">등산
		<input type="checkbox" name="hobby" value="노래">노래
		<input type="submit" value="전송">
	</form>
	
	<h3>EL 표현식 내부에서 연산처리하기</h3>
	
	<%
		request.setAttribute("su", 100);
		request.setAttribute("su2", 200);
		request.setAttribute("testData", "안녕하세요!");
		List<String> list = List.of("유병승", "유병승1", "유병승2");
		List<Integer> number = null;
		
		request.setAttribute("names", list);
		request.setAttribute("numbers", number);
	%>
	
	<h4>산술연산처리</h4>
	<p>+ : ${su + su2 }</p>
	<p>+ : ${su - su2 }</p>
	<p>+ : ${su * su2 }</p>
	<p>+ : ${su / su2 }</p>
	
	
	<h4>비교연산</h4>
	<h5>대소 비교하기</h5>
	<p>${su < su2 } : ${su lt su2 }</p>
	
	<h4>논리연산</h4>
	<p>${su < su2 && testData eq "안녕하세요?" }</p>
	
	<h5>삼항연산</h5>
	<input type="checkbox" name="adminCheck" ${testData eq "안녕하세요!" ? "checked" : "" }>
	
	<h4>기타 제공되는 데이터 출력</h4>
	<p>header, contextRoot, Cookie 정보출력</p>
	<h3>
		<a href="${pageContext.request.contextPath }/el/extradata.do">추가데이터</a>
	</h3>
	
	
	
	
	
	