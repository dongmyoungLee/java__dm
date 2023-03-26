<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원조회 결과</title>
</head>
<body>
	<h3>사원조회 결과</h3>
	
	<form action="${path}/searchEmp.do">
		<table>
			<tr>
				<td>
					<select name="type">
						<option value="emp_id">사원번호</option>
						<option value="emp_name">사원명</option>
						<option value="email">이메일</option>
						<option value="phone">전화번호</option>
					</select>
				</td>
				<td>
					<input type="text" name="keyword">
				</td>
			</tr>
			<tr>
				<tr>
					<td>
						성별조회
					</td>
					<td>
						<label>
							<input type="radio" name="gender" value="M" >
							남
						</label>
						<label>
							<input type="radio" name="gender" value="F" >
							여
						</label>
					</td>
				</tr>
				<td colspan="2">
					<input type="submit" value="검색">
				</td>
			</tr>
		</table>
	</form>
	
	<table>
		<c:if test="${empty list}">
			<tr>
				<td colspan="14">조회된 데이터가 없습니다.</td>
			</tr>
		</c:if>
		
			<thead>
				<tr>
					<td>사원번호</td>
					<td>사원이름</td>
					<td>주민번호</td>
					<td>이메일</td>
					<td>이메일</td>
					<td>전화번호</td>
					<td>부서코드</td>
					<td>직책코드</td>
					<td>급여수준</td>
					<td>급여</td>
					<td>보너스</td>
					<td>매니저ID</td>
					<td>입사일</td>
				</tr>
			</thead>
			<c:if test="${not empty list}">
			<tbody>
				<c:forEach var="emp" items="${list}">
					<tr>
						<td>${emp.empId }</td>
						<td>${emp.empName }</td>
						<td>${emp.empNo }</td>
						<td>${emp.email }</td>
						<td>${emp.empName }</td>
						<td>${emp.phone }</td>
						<td>${emp.deptCode eq null ? "인턴" :  emp.deptCode}</td>
						<td>${emp.jobCode }</td>
						<td>${emp.salLevel }</td>
						<td>
							<fmt:formatNumber value="${emp.salary}"  type="currency" />
						</td>
						<td>
							<fmt:formatNumber value="${emp.bonus}"  type="percent" />
						</td>
						<td>${emp.managerId}</td>
						<td>
							<fmt:formatDate value="${emp.hireDate }"  type="date" pattern="yyyy/MM/dd E" />
						</td>
					</tr>	
				</c:forEach>
			</tbody>
		</c:if>
	</table>
</body>
</html>