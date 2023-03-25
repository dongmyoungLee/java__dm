<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.jsptest.vo.Department" %>
<%
	List<Department> departments = (List<Department>)request.getAttribute("departments");
 %>
<%@ include file="/views/common/header.jsp" %>
<section>
	<h3>부서정보</h3>
	
	<form action="<%=request.getContextPath()%>/searchdepartment.do">
		<input type="text" name="keyword">
		<input type="submit" value="조회">
	</form>
	
	<table>
		<tr>
			<th>부서코드</th>
			<th>부서명</th>
			<th>지역코드</th>
		</tr>
		<%if(departments.isEmpty()) { %>
		<tr>
			<td colspan="3">등록된 부서가 없습니다.</td>
		</tr>
		<%} else {
			for(Department d : departments) { %>
				<tr>
					<td><%=d.getDeptId() %></td>
					<td><%=d.getDeptTitle() %></td>
					<td><%=d.getLocationId() %></td>
				</tr>
		<%} 
		}%>

		
		
	</table>
</section>
<%@ include file="/views/common/footer.jsp" %>