<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import ="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날짜 데이터 처리</title>
</head>
<body>
	<h2>fmt : 태그는 날짜와 숫자를 원하는 패턴대로 출력해주는 기능을 하는 태그</h2>
	<p>
		1. formatNumber : 숫자형 데이터 금액표시(쉼표), 퍼센트표시, 소수점표시
		2. formatDate : 날짜형데이터를 원하는 형태로 출력
	</p>
	<h2>날짜데이터 처리하기</h2>
	<c:set var="today" value="<%=new Date() %>" />
	<c:out value="${today }" />
	
	
	<h4>date : <fmt:formatDate value="${today }" type="date" /></h4>
	<h4>time : <fmt:formatDate value="${today }" type="time" /></h4>
	<h4>both : <fmt:formatDate value="${today }" type="both" /></h4>
	
	<h3>기본 style적용 출력</h3>
	<h3>dateStyle</h3>
	<h4>default : <fmt:formatDate value="${today }" type="date" dateStyle="default" /></h4>
	<h4>short : <fmt:formatDate value="${today }" type="date" dateStyle="short" /></h4>
	<h4>long : <fmt:formatDate value="${today }" type="date" dateStyle="long" /></h4>
	<h4>full : <fmt:formatDate value="${today }" type="date" dateStyle="full" /></h4>
	
	<h3>timeStyle</h3>
	<h4>medium : <fmt:formatDate value="${today }" type="time" timeStyle="medium" /></h4>
	<h4>short : <fmt:formatDate value="${today }" type="time" timeStyle="short" /></h4>
	<h4>long : <fmt:formatDate value="${today }" type="time" timeStyle="long" /></h4>
	<h4>full : <fmt:formatDate value="${today }" type="time" timeStyle="full" /></h4>
	
	<h3>모두적용</h3>
	<h4><fmt:formatDate value="${today }" type="both" dateStyle="full" timeStyle="full" /></h4>
	
	<h3>원하는 패턴대로 날짜 출력</h3>
	<h4><fmt:formatDate value="${today }" type="both" pattern="yy/MM/dd hh:mm:ss" /></h4>
	<h4><fmt:formatDate value="${today }" type="both" pattern="yy/MM/dd (E) hh:mm:ss" /></h4>
	
	<h3>기준시간 설정하기</h3>
	<p>
		<fmt:timeZone value="GMT">
			<fmt:formatDate value="${today }" type="time" timeStyle="full" />
		</fmt:timeZone>
		<fmt:timeZone value="GMT+9">
			<fmt:formatDate value="${today }" type="time" timeStyle="full" />
		</fmt:timeZone>
	</p>	
</body>
</html>








