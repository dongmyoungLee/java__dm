<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="header.jsp" %> --%>
<%
	String name = "유병승2";
%> 

<!-- 불러오는 헤더페이지에 데이터 전송하기 -->
<jsp:include page="header.jsp" >
	<jsp:param name="title" value="basicContent" />
</jsp:include>

<section>
	<h2>여기는 본문태그 입니다.</h2>
	<h3>데이터 출력 : <%=name %></h3>
	<a href="includes2.jsp">두번째화면</a>
</section>

</body>
</html>