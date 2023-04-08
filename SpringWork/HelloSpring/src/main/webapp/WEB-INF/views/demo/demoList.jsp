<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
   <jsp:param name="title" value=" "/>
</jsp:include>
<section id="content">
   <table class="table">
      <tr>
         <th scope="col">번호</th>
         <th scope="col">이름</th>
         <th scope="col">나이</th>
         <th scope="col">이메일</th>
         <th scope="col">성별</th>
         <th scope="col">개발가능언어</th>
         <th scope="col">수정</th>
      </tr>
      <c:forEach var="d" items="${demos }" varStatus="vs">
      	<tr>
      		<td scope="col">${vs.count }</td>
      		<td scope="col">${d.devName }</td>
      		<td scope="col">${d.devAge }</td>
      		<td scope="col">${d.devEmail }</td>
      		<td scope="col">${d.devGender }</td>
      		<td scope="col">
      			${Arrays.toString(d.devLang)}
      		</td>
      		<td scope="col"><button class="btn btn-outline-primary">수정</button></td>
      	</tr>
      </c:forEach>
   </table>   
</section>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>