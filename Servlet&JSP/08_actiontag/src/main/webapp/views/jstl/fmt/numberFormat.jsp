<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자패턴으로 출력하기</title>
</head>
<body>
	<h2>기본 숫자표현</h2>
	<c:set var="numtest" value="123456012" />
	<c:set var="numtest1" value="19883000" />
	<c:set var="numtest2" value="1" />
	<c:set var="numtest3" value="1234.567" />
	
	<p>기본숫자출력 : ${numtest }</p>
	<p>formatNumber 태그 이용 : <fmt:formatNumber value="${numtest }" /></p>
	
	<h3>숫자 쉼표처리를 제어</h3>
	<p>groupingUsed 속성 true / false</p>
	<p><fmt:formatNumber value="${numtest }" groupingUsed="true" /></p>
	<p><fmt:formatNumber value="${numtest }" groupingUsed="false" /></p>
	
	<h3>숫자를 화폐로 출력</h3>
	<p><fmt:formatNumber type="currency" value="${numtest }" />원</p>
	
	<h4>화폐표시 커스터마이징</h4>
	<p><fmt:formatNumber type="currency" currencySymbol="$" value="${numtest1 }" /></p>
	<fmt:setLocale value="fr_FR"/>
	<p><fmt:formatNumber type="currency" currencySymbol="$" value="${numtest1 }" /></p>
	<fmt:setLocale value="ko_Kr"/>
	<p><fmt:formatNumber type="currency" currencySymbol="$" value="${numtest1 }" /></p>
	<p>현재 로케일확인 ${pageContext.request.locale }</p>
	
	<h3>퍼센트표시</h3>
	<p><fmt:formatNumber value="${numtest2 }" type="percent" /></p>
</body>
</html>