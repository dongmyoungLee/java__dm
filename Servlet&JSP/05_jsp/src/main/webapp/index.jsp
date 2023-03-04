<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 첫 JSP 페이지</title>
</head>
<body>
	<h2>JSP !!</h2>
	<h3>jsp에 대해 알아보자</h3>
	<p>jsp는 html 페이지에 java코드를 jsp태그를 이용해서 넣을 수 있게 만든 페이지이다</p>
	<p>jsp도 하나의 java 파일이다</p>
	
	<h4>jsp 태그에 대해 알아보자</h4>
	<ul>
		<li>
			지시자 : <%-- <% 태그명 속성설정 %> --%> <br>
			page : 페이지에 대한 설정을 하는 태그
			include : 다른 jsp 페이지를 불러와 출력해주는 태그
			taglib : 외부 jsp태그 라이브러리를 불러올 때 사용하는 태그 (JSTL 이용시 사용함)
		</li>
		<li>
			선언문 : <%-- <%! java 코드 작성 %> --%> <br>
			자바 클래스에 선언되는 코드를 작성, 멤버변수 선언, 멤버메소드 선언 등을 함.
			조건문, 반복문은 사용할 수 없다. * 잘안씀... mvc2 패턴에서...	
		</li>
		<li>
			스크립트릿 : <%-- <% java 코드 작성 %> --%> <br>
			메소드 내부에 사용하는 java 코드 작성 지역변수 선언, 조건문, 반복문 사용가능. * 가장 많이 이용함
		</li>
		<li>
			표현식 : <%-- <%= 페이지에 출력된 데이터 %> --%> <br>
			변수값을 페이지에 출력하거나 메소드의 반환값을 출력할 때 사용
		</li>		
	</ul>
	
	<h2>선언문 이용하기</h2>
	<%! 
		private String name = "유병승";
		
		public String test() {
			return "멤버 메소드";
		}
		/* 조건문 반복문 못씀.. */
	%>
	
	<h2>스크립트립 이용하기</h2>
	<%
		// 메소드 내부에 선언되는 내용을 모두 선언할 수 있음.
		// 지역변수, 조건문, 반복문, 메소드 호출 가능함.
		
		String test = "test";
		Date today = new Date();
		int[] number = {1,2,3,4,5};
		
		if(test.equals("test")) {
			
		}
		
		for(int i = 0; i < number.length; i++) {
			
		}
	
	%>
	
	<h2>표현식 활용하기</h2>
	<h3><%= name %></h3>
	<p><%= today %></p>
	<h4><%= name.charAt(0) %></h4>
	
	<%
		String[] names = {"유병승", "오윤재", "박세현", "김수진", "이동명", "김성훈"};
	%>
	<ul>
		<%for(String n : names) { %>
			<li><%=n %></li>
		<%} %>
	</ul>
</body>
</html>








