<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- core태그 : 조건문, 반복문, 변수저장, 변수출력 태그제공 -->
<%@ page import="java.util.List" %>
<%@ page import="com.el.vo.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL의 제어문 태그 이용하기</h3>
	<h4>조건문 이용하기</h4>
	
	<c:set var="su" value="100" />
	<c:set var="su1" value="200" />
	
	<c:if test="${su < su1 }">
		<p>${su }는 ${su1 }보다 작다</p>
		
		<c:if test="${su <150 }">
			<p>${su }는 150보다도 작다</p>
		</c:if>
	</c:if>
	
	<%
		List <String> names = List.of("유병승1", "유병승2", "유병승3");
		request.setAttribute("names", names);
		
		List<Member> list = List.of(
				Member.builder()
				.userId("admin")
				.password("1234")
				.userName("관리자")
				.age(40)
				.weight(65.5)
				.build(),
				Member.builder()
				.userId("user01")
				.password("1111")
				.userName("유저01")
				.age(11)
				.weight(65.5)
				.build(),
				Member.builder()
				.userId("admin")
				.password("1234")
				.userName("관리자")
				.age(40)
				.weight(65.5)
				.build()
				);
		
		request.setAttribute("members", list);
	%>
	
	<c:if test="${empty names }" var="result">
		<h4>저장된 이름이 없습니다.</h4>
	</c:if>
	<c:if test="${not empty names }">
		<h4>저장된 이름은 ${names.size() }개 있습니다.</h4>
	</c:if>
	<p>empty names의 결과는 ${result }</p>
	
	<h3>c:choose 태그 이용하기</h3>
	
	<c:choose>
		<c:when test="${su < 50 }">
			<h4>${su } 는 50보다 작다</h4>
		</c:when>
		<c:when test="${su < 70 }">
			<h4>${su } 는 70보다 작다</h4>
		</c:when>
		<c:when test="${su < 110 }">
			<h4>${su } 는 110보다 작다</h4>
		</c:when>
		<c:otherwise>
			<h4>해당없음</h4>
		</c:otherwise>
	</c:choose>
	
	<h3>반복문</h3>
	<ul>
		<c:forEach var="i" begin="1" end="10" step="1">
			<li>${i }</li>
		</c:forEach>
		
	</ul>

	<ul>
		<c:forEach var="m" items="${members }">
			<li>${m.userId }</li>
		</c:forEach>
	</ul>
	
	<table>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
			<th>나이</th>
			<th>몸무게</th>
		</tr>
		<c:forEach var="m" items="${members }" varStatus="vs">
			<c:if test="${m.age >20 }">
				<tr>
					<td><c:out value="${vs.count } ${vs.index} ${vs.last }" /></td>
					<td><c:out value="${m.userId }" /></td>
					<td><c:out value="${m.password }" /></td>
					<td><c:out value="${m.userName }" /></td>
					<td><c:out value="${m.age }" /></td>
					<td><c:out value="${m.weight }" /></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	
	<h4>c:forTokens 태그 이용하기</h4>
	
	<ul>
		<li>var : 값을 저장하는변수</li>	
		<li>items : 특정 구분자로 구분될수있는 문자열</li>	
		<li>delims: 특정 구분자 선택</li>
		
		<c:set var="hobby" value="코딩,운동,여행,영화" />
		<c:forTokens var="h" items="${hobby }" delims=",">
			<p><c:out value="${h }" /></p>
		</c:forTokens>
		
		<h4>그외 태그들</h4>
		<h4>c:import</h4>
		<p>다른 jsp 페이지를 저장하고 불러와 출력하는 태그</p>
		
		<c:import var="content" url="/views/includes.jsp"></c:import>
		<div>
			${content }
		</div>
		
		<h4>c:catch 에러처리 태그</h4>
		<%
			String name = null;
		%>
		<p>
			<c:catch var="e">
				<%=name.length() %>
			</c:catch>
		</p>
		<c:out value="${e }" />
	</ul>
	
</body>



</html>







