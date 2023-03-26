<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직책조회 결과</title>
</head>
<body>
	<h2>${param.jobCode } 직책조회 결과</h2>
	<ul>
		<li>직책명 : ${job.jobName}</li>
		<li>직책코드 : ${job.jobCode}</li>
		<li>
			<table>
				<tr>
					<th>사번</th>
					<th>이름</th>
					<th>급여</th>
					<th>보너스</th>
				</tr>
				
				<c:forEach var="e" items="${job.employees}">
					<tr>
						<td>${e.empId }</td>
						<td>${e.empName }</td>
						<td>${e.salary }</td>
						<td>${e.bonus }</td>
					</tr>
				</c:forEach>
			</table>
		</li>
	</ul>
</body>
</html>