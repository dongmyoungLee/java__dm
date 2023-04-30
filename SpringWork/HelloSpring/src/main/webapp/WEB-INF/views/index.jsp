<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="MainPage" name="title"/>
</jsp:include>


<section id="content">
	<h2>Hello Spring</h2>
	<div id="jpaContainer">
		<h3><a href="${path}/jpa/basicJpa">기본 JPA 구문 활용하기</a></h3>
		<h3><a href="${path}/jpa/insertJpa">기본 입력하기</a></h3>
		<h3><a href="${path}/jpa/member?no=1">회원조회</a></h3>
		<h3><a href="${path}/jpa/members">전체회원조회</a></h3>
		<h3><a href="${path}/jpa/dev?no=1">DEV test 조회</a></h3>
	</div>
	<img src="${path}/resources/images/logo-spring.png" id="center-image" alt="스프링로고" />
	
	<button onClick="selectMemberAll();" class="btn btn-outline-primary">전체회원조회</button>
	
	<button onClick="insertMember();" class="btn btn-outline-primary">회원가입</button>

	<div id="memberList">
	
	</div>
</section>


<script>
const selectMemberAll = () => {
	
	$.get("${path}/member/selectMemberAll.do", data => {
		console.log(data);
		
		const table = $("<table>");
		const header = $("<tr>");
		header.append("<th>아이디</th>")
			  .append("<th>이름</th>")
			  .append("<th>나이</th>")
			  .append("<th>전화번호</th>")
			  .append("<th>이메일</th>")
			  .append("<th>주소</th>")
			  .append("<th>취미</th>")
			  .append("<th>가입일</th>");
		table.append(header);
		
		data.forEach((item,idx) => {
			let tr = $("<tr>");
			let userId = $("<td>").text(item.userId);
			let userName = $("<td>").text(item.userName);
			let userAge = $("<td>").text(item.age);
			let userPhone = $("<td>").text(item.phone);
			let userEmail = $("<td>").text(item.email);
			let userAddress = $("<td>").text(item.address);
			let userHobby = $("<td>").text(item.hobby.toString());
			let userEnrollDate = $("<td>").text(new Date(item.enrollDate));
			
			tr.append(userId);
			tr.append(userName);
			tr.append(userAge);
			tr.append(userPhone);
			tr.append(userEmail);
			tr.append(userAddress);
			tr.append(userHobby);
			tr.append(userEnrollDate);

			
			table.append(tr);
			  
		});
		
		
			$("#memberList").html(table);
		
		});
	}

const insertMember = async () => {
	// 비동기식 통신을 할때 js가 기본으로 제공하는 함수를 만들었음.
	// fetch()
	
	/*
	const response = await fetch("${path}/member/ajax/insert", {
		method: "post",
		headers: {
			"Content-Type" : "application/json"
		},
		body: JSON.stringify(
				{
					userId:"test22",
					userName: "유병숭",
					password:"1234",
					gender: "M",
					age: 19
				}
		)
	});
	
	const data = await response.json();

	console.log(data)
	*/
	
	
	fetch("${path}/member/ajax/insert", {
		method: "post",
		headers: {
			"Content-Type" : "application/json"
		},
		body: JSON.stringify(
				{
					userId:"test22",
					userName: "유병숭",
					password:"1234",
					gender: "M",
					age: 19
				}
		)
	}).then((res) => {
		return res.json();
	}).then((data) => {
		console.log(data);
	});
	

}
</script>





<jsp:include page="/WEB-INF/views/common/footer.jsp" />


