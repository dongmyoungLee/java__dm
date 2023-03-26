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
						<option value="emp_id" ${param.type eq "emp_id" ? "selected" : ""}>사원번호</option>
						<option value="emp_name" ${param.type eq "emp_name" ? "selected" : ""}>사원명</option>
						<option value="email" ${param.type eq "email" ? "selected" : ""}>이메일</option>
						<option value="phone" ${param.type eq "phone" ? "selected" : ""}>전화번호</option>
					</select>
				</td>
				<td>
					<input type="text" name="keyword" value="${param.keyword.length() > 0 ? param.keyword : ''}">
				</td>
			</tr>
			<tr>
				<tr>
					<td>
						성별조회
					</td>
					<td>
						<label>
							<input type="radio" name="gender" value="M" ${param.gender eq "M" ? "checked" : " "}>
							남
						</label>
						<label>
							<input type="radio" name="gender" value="F" ${param.gender eq "F" ? "checked" : " "}>
							여
						</label>
					</td>
				</tr>
				<tr>
					<td>급여</td>
					<td>
						<input type="number" name="salary" step="500000" min="1200000">
						<label>
							<input type="radio" name="salFlag" value="ge">이상
						</label>
						<label>
							<input type="radio" name="salFlag" value="le">이하
						</label>
					</td>
				</tr>
				<tr>
					<td>입사일</td>
					<td>
						<input type="date" name="hireDate">
						<label>
							<input type="radio" name="dateFlag" value="ge">이후
						</label>
						<label>
							<input type="radio" name="dateFlag" value="le">이전
						</label>
					</td>
				</tr>
				<tr>
					<td>직책조회</td>
					<td>
						<label><input type="checkbox" name="jobCode" value="J1">대표</label>
						<label><input type="checkbox" name="jobCode" value="J2">부사장</label>
						<label><input type="checkbox" name="jobCode" value="J3">부장</label>
						<label><input type="checkbox" name="jobCode" value="J4">차장</label>
						<label><input type="checkbox" name="jobCode" value="J5">과장</label>
						<label><input type="checkbox" name="jobCode" value="J6">대리</label>
						<label><input type="checkbox" name="jobCode" value="J7">사원</label>
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
					<td>부서</td>
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
						<td>
							<ul>
								<li>부서명 : ${emp.dept.deptTitle}</li>
								<li>부서코드 : ${emp.dept.deptId}</li>
								<li>지역코드 : ${emp.dept.locationId}</li>
							</ul>
						</td>
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